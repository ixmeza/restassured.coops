package APITests;

import BaseTest.BaseTest;
import apiConfigs.APIRoutes;
import apiConfigs.HeadersConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestCases extends BaseTest {

    HeadersConfig head = new HeadersConfig();

    @Test
    public void test_GetTokenValid(){
        // testing auth to retrieve bearer token
        Response response = RestAssured.given()
                .formParam("client_id", prop.getClientId())
                .formParam("client_secret", prop.getClientSecret())
                .formParam("grant_type", prop.getGrantType())
                .post(APIRoutes.apiRoutes.TOKEN);

        Assert.assertNotNull(response.jsonPath().get("access_token"));
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void test_GetTokenInvalid(){
        // testing auth to retrieve bearer token giving invalid credentials
        Response response = RestAssured.given()
                .formParam("client_id", "")
                .formParam("client_secret", "")
                .formParam("grant_type", "")
                .post(APIRoutes.apiRoutes.TOKEN);

        Assert.assertEquals(response.statusCode(),400);
        Assert.assertNull(response.jsonPath().get("access_token"));

    }

    @Test
    public void test_UnlockBarn(){
        RestAssured.given()
                .headers(head.defaultHeaders())
                .auth()
                .oauth2(prop.getKey())
                .post(APIRoutes.apiRoutes.UNLOCK_BARN)
                .then()
                .statusCode(200)
                .body("success",equalTo(true),
                        "message", Matchers.containsString("You just unlocked your barn! Watch out for strangers!"))
                .log()
                .body();
    }
    @Test
    public void test_FeedChickens(){
        RestAssured.given()
                .headers(head.defaultHeaders())
                .auth()
                .oauth2(prop.getKey())
                .post(APIRoutes.apiRoutes.FEED_CHICKENS)
                .then()
                .statusCode(200)
                .body("success",equalTo(true),
                        "message", Matchers.containsString("Your chickens are now full and happy"))
                .log()
                .body();
    }

    @Test
    public void test_CollectEggs(){
        RestAssured.given()
                .headers(head.defaultHeaders())
                .auth()
                .oauth2(prop.getKey())
                .post(APIRoutes.apiRoutes.COLLECT_EGGS)
                .then()
                .statusCode(200)
                .body("success",equalTo(true),
                        "message", Matchers.matchesRegex("Hey look at that, \\d.eggs have been collected!"),
                        "data", Matchers.notNullValue(),
                        "data", Matchers.greaterThan(0))
                .log()
                .body();
    }

    @Test
    public void test_CountEggs(){
        // counting egg number
        RestAssured.given()
                .headers(head.defaultHeaders())
                .auth()
                .oauth2(prop.getKey())
                .post(APIRoutes.apiRoutes.EGG_COUNT)
                .then()
                .statusCode(200)
                .body("success",equalTo(true),
                        "message",Matchers.matchesRegex("You have collected a total of \\d. eggs today"),
                        "data", Matchers.notNullValue(),
                        "data", Matchers.greaterThan(0));
    }
}
