package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/reports/html-reports/default-cucumber-reports.html",
                "json:target/reports/json-reports/cucumber1.json",
                "junit:target/reports/xml-reports/cucumber1.xml",
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@catFacts",
        dryRun = false

)
public class Runner {}