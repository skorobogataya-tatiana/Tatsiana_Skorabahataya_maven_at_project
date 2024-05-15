package runners;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import tests.testng.BookingTestNGTests;
import tests.testng.SelectTestNGTests;
import tests.testng.api.ChuckNorris;

public class TestNGRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[] {ChuckNorris.class, BookingTestNGTests.class, SelectTestNGTests.class});
        testNG.setParallel(XmlSuite.ParallelMode.TESTS);
        testNG.setThreadCount(3);
        testNG.run();
    }
}
