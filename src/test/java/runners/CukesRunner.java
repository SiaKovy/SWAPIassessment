package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@Test",
        plugin = {"html:target/cucumber-report.html", "json:target/cucumber-report.json"}
)
public class CukesRunner extends AbstractTestNGCucumberTests {
}


