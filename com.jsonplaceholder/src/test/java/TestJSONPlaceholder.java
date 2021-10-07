import base.LoadProperties;
import base.RestAssuredClient;
import dataProviders.JSONPlaceholderDataProviders;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.util.HashMap;

import static org.hamcrest.Matchers.hasSize;

public class TestJSONPlaceholder extends RestAssuredClient {

    LoadProperties loadProperties;
    String URL;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeSuite
    public void loadProperties() {
        loadProperties = new LoadProperties();
        URL = loadProperties.properties.getProperty("url");
    }

    @Test
    public void testGetUsers() {
        String endpoint = JSONPlaceholderResources.USERS;
        String requestURI = URL + endpoint;

        response = get(requestURI);

        response.then().assertThat().statusCode(HttpURLConnection.HTTP_OK);
    }

    @Test
    public void testGetUsersCount() {
        String endpoint = JSONPlaceholderResources.USERS;
        String requestURI = URL + endpoint;

        response = get(requestURI);

        response.then().assertThat().statusCode(HttpURLConnection.HTTP_OK).body("id", hasSize(10));
    }

    @Test
    public void testGetPostsCount() {
        String endpoint = JSONPlaceholderResources.POSTS;
        String requestURI = URL + endpoint;

        response = get(requestURI);

        response.then().assertThat().statusCode(HttpURLConnection.HTTP_OK).body("id", hasSize(100));
    }

    @Test
    public void testGetCommentsCount() {
        String endpoint = JSONPlaceholderResources.COMMENTS;
        String requestURI = URL + endpoint;

        response = get(requestURI);

        response.then().assertThat().statusCode(HttpURLConnection.HTTP_OK).body("id", hasSize(500));
    }

    @Test
    public void testGetCommentsPhotos() {
        String endpoint = JSONPlaceholderResources.PHOTOS;
        String requestURI = URL + endpoint;

        response = get(requestURI);

        response.then().assertThat().statusCode(HttpURLConnection.HTTP_OK).body("id", hasSize(5000));
    }

    @Test (dataProvider = "userEmails", dataProviderClass = JSONPlaceholderDataProviders.class)
    public void testUserEmails(int id, String email) {
        String endpoint = JSONPlaceholderResources.USERS;
        String requestURI = URL + endpoint;

        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        response = getWithParams(requestURI, params);

        response.then().assertThat().statusCode(HttpURLConnection.HTTP_OK).body("email", Matchers.hasToString("[" + email + "]"));
    }
}
