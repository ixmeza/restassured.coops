package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    Properties prop = new Properties();

    public ReadProperties(){
        String environment = System.getProperty("env");
        if(environment.equalsIgnoreCase("dev")) {
            try (InputStream input = new FileInputStream("inputs/dev.properties")) {
                // load a properties file
                prop.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public String getBaseURL()
    {
        return  prop.getProperty("baseURL");
    }
    public String getKey(){
        return  prop.getProperty("apiKey");
    }
    public String getUserId(){

        return  prop.getProperty("userId");
    }

    public String getClientId(){

        return  prop.getProperty("clientId");
    }

    public String getClientSecret(){

        return  prop.getProperty("clientSecret");
    }

    public String getGrantType(){

        return  prop.getProperty("grantType");
    }
}
