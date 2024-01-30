package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.CatFacts;
import utilities.ConfigReader;

import static io.restassured.RestAssured.baseURI;

public class CatFacts_SD {

   Logger logger = LogManager.getLogger(CatFacts_SD.class.getName());

    static String url= ConfigReader.getProperty("url");
    CatFacts cf = new CatFacts();

    @Given("user goes to url")
    public void user_goes_to_url() {

        logger.info("user goes to url");
        baseURI = ConfigReader.getProperty("url");
    }

    @When("GET request is send with {string} endpoint")
    public void getRequestIsSendWithEndpoint(String endpoint) {

        logger.warn("An unexpected situation occurred. Details are here:");
        logger.info("user get Request Is Send With Endpoint");
        cf.getListOf(url, endpoint);
    }

    @Then("verifies that Status Code is {int}")
    public void verifies_that_status_code_is(Integer statusCode) {
        logger.info("Verifying Status Code is 200");
        cf.verifyStatusCode(statusCode);
    }

    @And("verifies content-type: {string}")
    public void verifiesContentType(String contentType) {

        if (logger.isTraceEnabled()) {
            logger.trace("Ekstra ayrıntılar burada...");
        }

        logger.info("Verifying content-type is application/json");
        cf.verifyContentType(contentType);
    }
}

