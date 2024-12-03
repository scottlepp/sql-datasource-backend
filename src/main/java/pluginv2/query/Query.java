package pluginv2.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query {
    private String rawSql;
    private String format;

    public static Query Load(ByteString json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = json.toStringUtf8(); 
        Query settings = mapper.readValue(jsonString, Query.class);
        return settings;
    }
}
