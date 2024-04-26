package tests;

import driver.Driver;
import org.testng.annotations.AfterClass;

public class BaseTestNG {

    @AfterClass
    public static void closeDriver() {

        Driver.killDriver();
    }
}
