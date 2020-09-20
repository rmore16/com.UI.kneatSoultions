package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/java/Features"},
        plugin = {
                "pretty", "html:/target/cumcumber-html-report",
                "json:target/jsonReports/cucumber-report.json",
                "junit:target/jsonReports/cucumber-report.xml"
        },
        glue = {""})
public class TestRunner {
}
