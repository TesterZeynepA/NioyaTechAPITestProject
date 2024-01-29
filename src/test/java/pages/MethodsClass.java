package pages;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class MethodsClass {

    public static Response makeRequest(String method, String url, String body) {

        baseURI = ConfigReader.getProperty("url");

        RequestSpecification request = given().contentType("application/json");

        switch (method.toUpperCase()) {
            case "GET":
                return request.get(url);
            case "POST":
                return (request.body(body)).post(url);
            case "PUT":
                return (request.body(body)).put(url);
            case "DELETE":
                return request.delete(url);
            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }

    }

}
