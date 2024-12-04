package pluginv2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.arrow.adapter.jdbc.ArrowVectorIterator;
import org.apache.arrow.adapter.jdbc.JdbcToArrow;
import org.apache.arrow.adapter.jdbc.JdbcToArrowConfig;
import org.apache.arrow.adapter.jdbc.JdbcToArrowConfigBuilder;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.ArrowFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.ByteString;
import com.grafana.backend.DataGrpc.DataImplBase;
import com.grafana.backend.DataQuery;
import com.grafana.backend.DataResponse;
import com.grafana.backend.QueryDataRequest;
import com.grafana.backend.QueryDataResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import pluginv2.converters.Converters;
import pluginv2.jdbc.Connector;
import pluginv2.query.Query;

@GrpcService
public class QueryData extends DataImplBase {

	private static final Logger logger = LoggerFactory.getLogger(QueryData.class);

	@Autowired
	private Connector connector;

	@Override
	public void queryData(QueryDataRequest request, StreamObserver<QueryDataResponse> responseObserver) {

		QueryDataResponse.Builder builder = QueryDataResponse.newBuilder();

		request.getQueriesList().forEach(query -> {
			DataResponse.Builder respBuilder = DataResponse.newBuilder();
			try {
				ByteString frame = runQuery(query);
				respBuilder.addFrames(frame);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
				respBuilder.setError(e.getMessage());
			}
			DataResponse response = respBuilder.build();
			builder.putResponses(query.getRefId(), response);
		});

		QueryDataResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	private ByteString runQuery(DataQuery query) throws JsonProcessingException, SQLException, IOException {
		Query q = Query.Load(query.getJson());
		logger.debug("Running query: " + q.getRawSql());

		try (BufferAllocator allocator = new RootAllocator()) {
			Connection connection = connector.getDataSource().getConnection();

			JdbcToArrowConfig config = new JdbcToArrowConfigBuilder(allocator, /* calendar= */null)
					.setReuseVectorSchemaRoot(true)
					.setJdbcConsumerGetter(new Converters.CustomJdbcConsumerFactory())
					.build();

			PreparedStatement statement = connection.prepareStatement(q.getRawSql());
			ResultSet resultSet = statement.executeQuery();

			return toDataFrame(config, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private ByteString toDataFrame(JdbcToArrowConfig config, ResultSet resultSet) throws IOException, SQLException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try (
			ArrowVectorIterator iterator = JdbcToArrow.sqlToArrowVectorIterator(resultSet, config)) {
			
			if (!iterator.hasNext()) {
				// TODO: probably don't need to throw error here
				throw new IllegalStateException("The ArrowVectorIterator has no data!");
			}

			// Write schema and batches to file
			VectorSchemaRoot root = iterator.next();

			try (ArrowFileWriter writer = new ArrowFileWriter(root, null, Channels.newChannel(out))) {
				writer.start();

				// Write the first batch
				writer.writeBatch();

				// Write the remaining batches
				while (iterator.hasNext()) {
					root = iterator.next();
					root.setRowCount(root.getRowCount()); // Ensure the batch has the correct count
					writer.writeBatch();
					root.close(); // Release resources for the batch after writing
				}

				// Finalize the file
				writer.end();
			} finally {
				root.close();
			}

			return ByteString.copyFrom(out.toByteArray());
		} finally {
			out.close();
		}
	}
}
