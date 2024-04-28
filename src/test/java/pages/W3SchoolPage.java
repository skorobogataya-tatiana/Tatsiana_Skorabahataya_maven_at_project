package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class W3SchoolPage {
    private static final Logger LOGGER = LogManager.getLogger(W3SchoolPage.class);
    WebDriver driver = Driver.getWebDriver();

    public static final String TITLE_XPATH = "//span[text()='Tutorial']";

    public void openW3SchoolJavaPage() {

        driver.get("https://www.w3schools.com/java");
        LOGGER.info("W3School Java page was opened");
    }

    public void copyTitleOfThePage() {
        Actions make = new Actions(driver);
        WebElement title = driver.findElement(By.xpath(TITLE_XPATH));
        make.doubleClick(title)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        LOGGER.info("Title of the page was copied");
    }
}
