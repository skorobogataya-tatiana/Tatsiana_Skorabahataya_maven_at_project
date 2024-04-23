package tests;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

    @AfterClass
    public static void closeDriver() {

        Driver.killDriver();
    }
}
