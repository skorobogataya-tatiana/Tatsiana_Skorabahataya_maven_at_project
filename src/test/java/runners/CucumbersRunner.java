package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "summary"},
        glue = { "tests.cucumber"},
        features = {
                "src/test/resources/features/booking.feature",
                "src/test/resources/features/google.feature",
                "src/test/resources/features/select.feature"
        }
)

public class CucumbersRunner {
}
