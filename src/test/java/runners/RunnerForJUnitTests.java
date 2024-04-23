package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit.BookingTests;
import tests.junit.GoogleTests;
import tests.junit.SelectTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingTests.class, GoogleTests.class, SelectTests.class})

public class RunnerForJUnitTests {
}
