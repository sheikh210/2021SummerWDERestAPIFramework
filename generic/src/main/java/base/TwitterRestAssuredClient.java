package base;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class TwitterRestAssuredClient {

    public ValidatableResponse postTweet(String apiKey, String apiSecretKey, String accessToken, String accessSecretToken, String URL, String tweet) {
        return given().auth().oauth(apiKey, apiSecretKey, accessToken, accessSecretToken).param("status", tweet).when().post(URL).then();
    }

    public ValidatableResponse deleteTweet(String apiKey, String apiSecretKey, String accessToken, String accessSecretToken, String URL) {
        return given().auth().oauth(apiKey, apiSecretKey, accessToken, accessSecretToken).when().post(URL).then();
    }
}
