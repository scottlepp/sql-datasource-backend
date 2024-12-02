package pluginv2;

import com.grafana.backend.CheckHealthRequest;
import com.grafana.backend.CheckHealthResponse;
import com.grafana.backend.CheckHealthResponse.HealthStatus;
import com.grafana.backend.DiagnosticsGrpc.DiagnosticsImplBase;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class Diagnostics extends DiagnosticsImplBase {

    @Override
    public void checkHealth(CheckHealthRequest request,
        io.grpc.stub.StreamObserver<CheckHealthResponse> responseObserver) {

		CheckHealthResponse.Builder builder = CheckHealthResponse.newBuilder();
        builder.setStatus(HealthStatus.OK).setMessage("OK");

        // TODO:  implement health check
        // marshal json and connect to the database

		CheckHealthResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
    }
}
