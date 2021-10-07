import base.LoadProperties;
import base.TwitterRestAssuredClient;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.util.Properties;

public class TestTwitterAPI extends TwitterRestAssuredClient {

    Response response;
    ValidatableResponse validatableResponse;
    String baseURL;
    LoadProperties loadProperties;
    private String API_KEY;
    private String API_SECRET_KEY;
    private String ACCESS_TOKEN;
    private String ACCESS_SECRET_TOKEN;

    @BeforeSuite
    public void loadProps() {
        loadProperties = new LoadProperties();
        Properties prop = loadProperties.properties;

        baseURL = prop.getProperty("base_url");
        API_KEY = prop.getProperty("api_key");
        API_SECRET_KEY = prop.getProperty("api_secret_key");
        ACCESS_TOKEN = prop.getProperty("access_token");
        ACCESS_SECRET_TOKEN = prop.getProperty("access_secret_token");
    }

    @Test
    public void testCreateTweet() {
        String tweet = "We are tweeting using Java + RestAssured";
        String URL = baseURL + TwitterResources.getCreateTweetEndpoint();

        validatableResponse = postTweet(API_KEY, API_SECRET_KEY, ACCESS_TOKEN, ACCESS_SECRET_TOKEN, URL, tweet);
        validatableResponse.extract().response().body().prettyPeek();

        validatableResponse.assertThat().statusCode(HttpURLConnection.HTTP_OK);
    }

    @Test
    public void testDeleteTweet() {
        String tweetID = "1445936906072727553";
        String URL = baseURL + TwitterResources.getDeleteTweetEndpoint(tweetID);

        validatableResponse = deleteTweet(API_KEY, API_SECRET_KEY, ACCESS_TOKEN, ACCESS_SECRET_TOKEN, URL);

        validatableResponse.extract().response().body().prettyPeek();
        validatableResponse.assertThat().statusCode(HttpURLConnection.HTTP_OK);
    }

}
