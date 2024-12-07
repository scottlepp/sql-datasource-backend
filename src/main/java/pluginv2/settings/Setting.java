package pluginv2.settings;

import org.springframework.aot.hint.annotation.Reflective;

@Reflective
public class Setting {
    private String Name;
    private String Value;
    private Boolean Secure;

    public Setting() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Boolean getSecure() {
        return Secure;
    }

    public void setSecure(Boolean secure) {
        Secure = secure;
    }
}
