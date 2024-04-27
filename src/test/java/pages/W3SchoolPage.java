package pages;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolPage {
    WebDriver driver = Driver.getWebDriver();

    public static final String TITLE_XPATH = "//span[text()='Tutorial']";

    public void openW3SchoolJavaPage() {
        driver.get("https://www.w3schools.com/java");
    }

    public void copyTitleOfThePage() {
        Actions make = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_XPATH)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement title = driver.findElement(By.xpath(TITLE_XPATH));
        make.doubleClick(title)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }
}
