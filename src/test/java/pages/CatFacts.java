package pages;

import io.restassured.response.Response;
import utilities.ConfigReader;
import static pages.MethodsClass.makeRequest;

public class CatFacts {

    Response response;

    public void getListOf(String url, String endPoint) {
        response= makeRequest("GET", url + endPoint, null);
        response.prettyPrint();

    }

    public void verifyStatusCode(int statusCode) {
        getListOf(ConfigReader.getProperty("url"),"/breeds");
        response.then().assertThat().statusCode(statusCode);
    }

    public void verifyContentType(String contentType){
        getListOf(ConfigReader.getProperty("url"),"/breeds");
        response.then().assertThat().contentType(contentType);
    }
}
