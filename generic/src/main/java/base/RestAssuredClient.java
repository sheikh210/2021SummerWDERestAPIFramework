package base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {

    public static Response get(String URL) {
        RestAssured.defaultParser = Parser.JSON;

        return given().when().get(URL).then().contentType(ContentType.JSON).extract().response();
    }

    public static Response getWithParams(String URL, HashMap<String, Object> params) {
        RestAssured.defaultParser = Parser.JSON;

        return given().params(params).when().get(URL).then().contentType(ContentType.JSON).extract().response();
    }

    public static ValidatableResponse post(String URL, HashMap jsonBody) {
        RestAssured.defaultParser = Parser.JSON;

        return given().contentType(ContentType.JSON).with().body(jsonBody).when().post(URL).then();
    }

    public static ValidatableResponse patch(String URL, HashMap jsonBody) {
        RestAssured.defaultParser = Parser.JSON;

        return given().contentType(ContentType.JSON).with().body(jsonBody).when().patch(URL).then();
    }

//    public static ValidatableResponse delete(String URL, HashMap objectToDelete) {
//        RestAssured.defaultParser = Parser.JSON;
//
//        return given().contentType(ContentType.JSON).with().body(objectToDelete).delete(URL).then();
//    }

    public HashMap<String, Object> convertArrayOfArraysToHashMap(Object[][] arrayToConvert) {
        HashMap<String, Object> convertedMap = new HashMap<>();

        for (Object[] array: arrayToConvert) {
            convertedMap.put(String.valueOf(array[0]), array[1]);
        }

        return convertedMap;
    }
}
