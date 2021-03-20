package apiVerifications;
import org.junit.Assert;
import io.restassured.response.Response;

public class APIVerification {
    public static void responseCodeValidator(Response response, int code){
        try{
            // Status code is the one expected
            Assert.assertEquals(response.statusCode(), code);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void responseTimeValidator(Response response){
        try{
            // Time is less than 1000 ms
            Assert.assertTrue(response.getTime() < 1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
