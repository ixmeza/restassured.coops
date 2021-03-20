package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeadersConfig {

    public Map<String, String> defaultHeaders() {
        Map<String, String> defaultHeaders = new HashMap<>();
        defaultHeaders.put("Content-type", "application-json");
        defaultHeaders.put("Accept-Encoding", "gzip, deflate, br");
        return defaultHeaders;
    }
}
