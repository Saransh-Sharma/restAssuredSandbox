import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features"
        ,glue={"steps"}
        ,monochrome = false
        ,dryRun = false
        ,plugin = {"pretty" ,"html:REPORTS" ,
        "json:REPORTS/cucumber.json" ,
        "junit:REPORTS/cucumber.xml"}
)

public class TestRunner {
}
