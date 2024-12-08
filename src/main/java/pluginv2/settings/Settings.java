package pluginv2.settings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.aot.hint.annotation.Reflective;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;

// @Reflective
public class Settings {

  private static final Logger logger = LoggerFactory.getLogger(Settings.class);

  private Setting[] settings;

  public Settings() {

  }

  public Setting[] getSettings() {
    return settings;
  }

  public void setSettings(Setting[] settings) {
    this.settings = settings;
  }
  
  public static Settings Load(ByteString json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = json.toStringUtf8(); 
        logger.info("settings json", null, jsonString);
        System.out.println("settings json: " + jsonString);
        Settings settings = mapper.readValue(jsonString, Settings.class);
        return settings;
  }  
}

