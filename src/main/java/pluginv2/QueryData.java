package pluginv2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Arrays.asList;

import org.apache.arrow.adapter.jdbc.ArrowVectorIterator;
import org.apache.arrow.adapter.jdbc.JdbcToArrow;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.ArrowFileWriter;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
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
import pluginv2.jdbc.Connector;
import pluginv2.query.Query;

@GrpcService
public class QueryData extends DataImplBase {

	@Autowired
    private Connector connector;

	@Override
	public void queryData(QueryDataRequest request, StreamObserver<QueryDataResponse> responseObserver) {

		QueryDataResponse.Builder  builder = QueryDataResponse.newBuilder();

		request.getQueriesList().forEach(query -> {
			DataResponse.Builder respBuilder = DataResponse.newBuilder();
			try {			
				ByteString frame = runQuery(query);
				// ByteString value = ToArrowFrame();
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
		ByteString frames;
		Query q = Query.Load(query.getJson());
		System.out.println("Running query: " + q.getRawSql());
        try (BufferAllocator allocator = new RootAllocator()) {
			Connection connection = connector.getDataSource().getConnection();
			try (
				PreparedStatement statement = connection.prepareStatement(q.getRawSql());
				ResultSet resultSet = statement.executeQuery(q.getRawSql()); 
				ArrowVectorIterator iterator = JdbcToArrow.sqlToArrowVectorIterator(resultSet, allocator)) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();

				if (!iterator.hasNext()) {
					throw new IllegalStateException("The ArrowVectorIterator has no data!");
				}

				// Write schema and batches to file
				VectorSchemaRoot root = iterator.next();
				try (ArrowFileWriter writer = new ArrowFileWriter(root, null,  Channels.newChannel(out))) {
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

				frames = ByteString.copyFrom( out.toByteArray());
				out.close();
			}
        } catch (Exception e) {
            e.printStackTrace();
			throw e;
        }

		return frames;
	}

	// example of creating a dataframe response
	public ByteString ToArrowFrame() throws IOException {
		Field age = new Field("age",
        FieldType.nullable(new ArrowType.Int(32, true)),
        /*children*/null
		);
		Field name = new Field("name",
				FieldType.nullable(new ArrowType.Utf8()),
				/*children*/null
		);
		Schema schema = new Schema(asList(age, name), /*metadata*/ null);
		
		BufferAllocator allocator = new RootAllocator();
		VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);

		IntVector ageVector = (IntVector) root.getVector("age");
		ageVector.allocateNew(3);
		ageVector.set(0, 10);
		ageVector.set(1, 20);
		ageVector.set(2, 30);

		VarCharVector nameVector = (VarCharVector) root.getVector("name");
		nameVector.allocateNew(3);
		nameVector.set(0, "Dave".getBytes(StandardCharsets.UTF_8));
		nameVector.set(1, "Peter".getBytes(StandardCharsets.UTF_8));
		nameVector.set(2, "Mary".getBytes(StandardCharsets.UTF_8));

		root.setRowCount(3);
		// System.out.println("VectorSchemaRoot created: \n" + root.contentToTSVString());

		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			try (ArrowFileWriter writer = new ArrowFileWriter(root, null, Channels.newChannel(out))) {
				writer.start();
				writer.writeBatch();
				writer.end();
			}
			return ByteString.copyFrom( out.toByteArray() );
		}
	}
}
