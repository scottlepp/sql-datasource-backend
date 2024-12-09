package pluginv2.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;

public class Query {
    private Datasource datasource;
    private String datasourceId;
    private String rawSql;
    private String format;
    private String intervalMs;
    private String maxDataPoints;
    private String refId;

    public Query() {
    }

    public static Query Load(ByteString json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonString = json.toStringUtf8(); 
        Query settings = mapper.readValue(jsonString, Query.class);
        return settings;
    }

    // Getters and Setters
    public Datasource getDatasource() {
        return datasource;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    public String getRawSql() {
        return rawSql;
    }

    public void setRawSql(String rawSql) {
        this.rawSql = rawSql;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getIntervalMs() {
        return intervalMs;
    }

    public void setIntervalMs(String intervalMs) {
        this.intervalMs = intervalMs;
    }

    public String getMaxDataPoints() {
        return maxDataPoints;
    }

    public void setMaxDataPoints(String maxDataPoints) {
        this.maxDataPoints = maxDataPoints;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }
}
