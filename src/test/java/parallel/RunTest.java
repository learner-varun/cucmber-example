package parallel;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        format = {"pretty", "html:target/html", "json:target/html/cucumber.json", "json:target/cucumber-report/cucumber.json"},
        features = {"feature/test.feature"},
        snippets = SnippetType.CAMELCASE,
        strict = false,
        glue = "parallel",
        plugin = {"json:target/cucumber-report/cucumber.json"})


public class RunTest {

}
