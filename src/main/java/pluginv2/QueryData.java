package pluginv2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import static java.util.Arrays.asList;

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

import com.google.protobuf.ByteString;
import com.grafana.backend.DataGrpc.DataImplBase;
import com.grafana.backend.DataResponse;
import com.grafana.backend.QueryDataRequest;
import com.grafana.backend.QueryDataResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class QueryData extends DataImplBase {

	@Override
	public void queryData(QueryDataRequest request, StreamObserver<QueryDataResponse> responseObserver) {

		QueryDataResponse.Builder  builder = QueryDataResponse.newBuilder();

		request.getQueriesList().forEach(query -> {
			DataResponse.Builder respBuilder = DataResponse.newBuilder();
			try {			
				ByteString value = ToGprcArrowFrame();
				respBuilder.addFrames(value);
			} catch (IOException e) {
				e.printStackTrace();
			}
			DataResponse response = respBuilder.build();
			builder.putResponses(query.getRefId(), response);
		});

		QueryDataResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	public ByteString ToGprcArrowFrame() throws IOException {
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
