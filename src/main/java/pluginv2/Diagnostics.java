package pluginv2;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.ByteString;
import com.grafana.backend.CheckHealthRequest;
import com.grafana.backend.CheckHealthResponse;
import com.grafana.backend.CheckHealthResponse.HealthStatus;
import com.grafana.backend.DataSourceInstanceSettings;
import com.grafana.backend.DiagnosticsGrpc.DiagnosticsImplBase;

import net.devh.boot.grpc.server.service.GrpcService;
import pluginv2.jdbc.Connection;
import pluginv2.jdbc.Connector;
import settings.Setting;
import settings.Settings;

@GrpcService
public class Diagnostics extends DiagnosticsImplBase {

    @Autowired @Qualifier("connector")
    private Connector connector;

    @Override
    public void checkHealth(CheckHealthRequest request,
        io.grpc.stub.StreamObserver<CheckHealthResponse> responseObserver) {

        CheckHealthResponse.Builder builder = CheckHealthResponse.newBuilder();

        DataSourceInstanceSettings settings = request.getPluginContext().getDataSourceInstanceSettings();
        ByteString json = settings.getJsonData();
        Map<String, String> decrypted = settings.getDecryptedSecureJsonDataMap();

        try {
            Settings connectionSettings = Settings.Load(json);
            Connection conn = getConnection(connectionSettings, decrypted);
            connector.connect(conn);
            builder.setStatus(HealthStatus.OK).setMessage("OK");
        } catch (JsonProcessingException ex) {
            builder.setStatus(HealthStatus.ERROR).setMessage(ex.getMessage());
        } catch (SQLException ex) {
            builder.setStatus(HealthStatus.ERROR).setMessage(ex.getMessage());
        }

		CheckHealthResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
    }

    private Connection getConnection(Settings settings, Map<String, String> decrypted) {
        Connection conn = new Connection();

        Setting[] values = settings.getSettings();
        for (Setting setting : values) {
            String value = setting.getValue();
            if (setting.getSecure() != null && setting.getSecure()) {
                value = decrypted.get(setting.getName());
            }
            // typical JDBC connection settings
            switch (setting.getName()) {
                case "username":
                    conn.setUsername(value);
                    break;
                case "password":
                    conn.setPassword(value);
                    break;
                case "host":
                    conn.setHost(value);
                    break;
                 case "port":
                    conn.setPort(value);
                    break;
                case "database":
                    conn.setDatabase(value);
                    break;
                case "type":
                    conn.setType(value);
                    break;
            }
        }
        return conn;
    }
}
