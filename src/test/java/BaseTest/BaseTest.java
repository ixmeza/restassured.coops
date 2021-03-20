package BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.ReadProperties;


public class BaseTest {

    public final ReadProperties prop = new ReadProperties();

    @BeforeClass
    public void baseTest(){
        RestAssured.baseURI = prop.getBaseURL();
    }
}
