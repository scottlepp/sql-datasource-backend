package pluginv2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import static java.util.Arrays.asList;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.arrow.adapter.jdbc.ArrowVectorIterator;
import org.apache.arrow.adapter.jdbc.JdbcToArrow;
import org.apache.arrow.adapter.jdbc.JdbcToArrowConfig;
import org.apache.arrow.adapter.jdbc.JdbcToArrowConfig.JdbcConsumerFactory;
import org.apache.arrow.adapter.jdbc.JdbcToArrowConfigBuilder;
import org.apache.arrow.adapter.jdbc.JdbcToArrowUtils;
import org.apache.arrow.adapter.jdbc.consumer.JdbcConsumer;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.TimeStampVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.ArrowFileWriter;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
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
			Calendar calendarTimeZone = Calendar.getInstance();
			calendarTimeZone.setTimeZone(TimeZone.getTimeZone("UTC"));

			JdbcToArrowConfig config = new JdbcToArrowConfigBuilder(allocator, /* calendar= */null)
					.setReuseVectorSchemaRoot(true)
					.setJdbcConsumerGetter(new CustomJdbcConsumerFactory())
					// TODO: this was an attemp to convert timestamp to nanoseconds
					// the customJdbcConsumerFactory is a better way to do this

					// .setJdbcToArrowTypeConverter((jdbcFieldInfo -> {
					// 	switch (jdbcFieldInfo.getJdbcType()) {
					// 		case Types.TIMESTAMP:
					// 			return new ArrowType.Timestamp(TimeUnit.NANOSECOND, null);
					// 		default:
					// 			return JdbcToArrowUtils.getArrowTypeFromJdbcType(jdbcFieldInfo, null);
					// 	}
					// }))
					.build();

			PreparedStatement statement = connection.prepareStatement(q.getRawSql());
			ResultSet resultSet = statement.executeQuery(q.getRawSql());

			// helpful for debugging
			// ResultSetMetaData meta = resultSet.getMetaData();
			// int columns = meta.getColumnCount();
			// for (int i = 1; i <= columns; i++) {
			// 	System.out.println("Column " + i + ": " + meta.getColumnType(i));
			// 	System.out.println("TypeName " + i + ": " + meta.getColumnTypeName(i));
			// 	System.out.println("ClassName " + i + ": " + meta.getColumnClassName(i));
			// 	System.out.println("Scale " + i + ": " + meta.getScale(i));
			// 	System.out.println("Precision " + i + ": " + meta.getPrecision(i));
			// }

			try (
				ArrowVectorIterator iterator = JdbcToArrow.sqlToArrowVectorIterator(resultSet, config)) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();

				if (!iterator.hasNext()) {
					throw new IllegalStateException("The ArrowVectorIterator has no data!");
				}

				// Write schema and batches to file
				VectorSchemaRoot root = iterator.next();

				// TODO: this was a hack to convert timestamp to nanoseconds
				// we have a better way to do this now

				// Schema originalSchema = root.getSchema();
				// Convert all Timestamp fields to nanosecond precision
				// List<Field> updatedFields = new ArrayList<>();
				// for (Field field : originalSchema.getFields()) {
				// 	if (field.getType() instanceof ArrowType.Timestamp) {
				// 		ArrowType.Timestamp originalType = (ArrowType.Timestamp) field.getType();
				// 		ArrowType.Timestamp updatedType = new ArrowType.Timestamp(TimeUnit.NANOSECOND,
				// 				originalType.getTimezone());
				// 		Field updatedField = new Field(field.getName(), FieldType.nullable(updatedType),
				// 				field.getChildren());
				// 		updatedFields.add(updatedField);
				// 	} else {
				// 		updatedFields.add(field); // Keep other fields unchanged
				// 	}
				// }

				// Schema updatedSchema = new Schema(updatedFields);
				// System.out.println("Updated Schema: " + updatedSchema);

				// logger.info("Updated Schema: {}", updatedSchema);

				// Use the updated schema to create a VectorSchemaRoot
				// VectorSchemaRoot updatedRoot = VectorSchemaRoot.create(updatedSchema, allocator);

				try (ArrowFileWriter writer = new ArrowFileWriter(root, null, Channels.newChannel(out))) {
					writer.start();

					// Write the first batch
					writer.writeBatch();

					// System.out.println("Arrow Schema: " + root.getSchema());

					// helpful for debugging
					// String content = root.contentToTSVString();
					// System.out.println("Arrow content: \n" + content);

					// logger.info("Arrow Content: \n {}", content);

					// Write the remaining batches
					while (iterator.hasNext()) {
						root = iterator.next();
						root.setRowCount(root.getRowCount()); // Ensure the batch has the correct count
						writer.writeBatch();
						root.close(); // Release resources for the batch after writing

						// helpful for debugging
						// System.out.println("Arrow Schema: " + root.getSchema());

						// content = root.contentToTSVString();
						// System.out.println("Arrow content: \n" + content);
					}

					// Finalize the file
					writer.end();
				} finally {
					// updatedRoot.close();
					root.close();
				}

				frames = ByteString.copyFrom(out.toByteArray());
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
				/* children */null);
		Field name = new Field("name",
				FieldType.nullable(new ArrowType.Utf8()),
				/* children */null);
		Schema schema = new Schema(asList(age, name), /* metadata */ null);

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
		// System.out.println("VectorSchemaRoot created: \n" +
		// root.contentToTSVString());

		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			try (ArrowFileWriter writer = new ArrowFileWriter(root, null, Channels.newChannel(out))) {
				writer.start();
				writer.writeBatch();
				writer.end();
			}
			return ByteString.copyFrom(out.toByteArray());
		}
	}

	/**
	 * Custom JdbcConsumerFactory implementation to handle TIMESTAMP columns with custom logic.
	 * Grafana expects timestamps in nanoseconds, but the default implementation uses milliseconds.
	 */
	static class CustomJdbcConsumerFactory implements JdbcConsumerFactory {

		@Override
		public JdbcConsumer apply(
				ArrowType arrowType,
				int columnIndex,
				boolean nullable,
				FieldVector vector,
				JdbcToArrowConfig config) {

			// Handle TIMESTAMP columns with custom logic
			if (arrowType instanceof ArrowType.Timestamp) {
				return new JdbcConsumer<TimeStampVector>() {
					private final TimeStampVector timeStampVector = (TimeStampVector) vector;

					@Override
					public void consume(ResultSet resultSet) throws SQLException {
						Timestamp milliseconds = resultSet.getTimestamp(columnIndex);
						int currentIndex = timeStampVector.getValueCount();
						if (!resultSet.wasNull()) {
							// Convert milliseconds to nanoseconds
							long nanoseconds = milliseconds.getTime() * 1_000_000L;

							// Set the value at the current value count position
							timeStampVector.setSafe(currentIndex, nanoseconds);

							// Increment the value count to reflect the new value added
							timeStampVector.setValueCount(currentIndex + 1);
						} else {
							// TODO: not sure if timestamps are all nullable
							timeStampVector.setNull(timeStampVector.getValueCount());
							// Increment the value count to reflect the new value added
							timeStampVector.setValueCount(currentIndex + 1);
						}
					}

					@Override
					public void resetValueVector(TimeStampVector vector) {
						timeStampVector.clear();
					}

					@Override
					public void close() {
						timeStampVector.close();
					}
				};
			}

			// Fallback: Use the default consumer for other types
			return JdbcToArrowUtils.getConsumer(arrowType, columnIndex, nullable, vector, config);
		}
	}
}
