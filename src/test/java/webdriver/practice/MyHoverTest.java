package webdriver.practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Arrays;

public class MyHoverTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void checkCurrencyTooltip() {
        driver.get("https://booking.com");

        try {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']/span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        WebElement currentcyButton = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']/span"));

        Actions actions = new Actions(driver);
        actions.moveToElement(currentcyButton);
        actions.perform();
        Assert.assertEquals("Value of the tooltip for currency is not correct", driver.
                findElement(By.xpath("//div[text()='Select your currency']")).getText(), "Select your currency");
    }

    @Test
    public void checkLanguageTooltip() {
        driver.get("https://booking.com");

        try {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']/span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        WebElement languagesButton = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(languagesButton);
        actions.perform();
        Assert.assertEquals("Value of the tooltip for languages is not correct", driver.
                findElement(By.xpath("//div[text()='Select your language']")).getText(), "Select your language");
    }

    @After
    public void closeWindow() {
        driver.close();
    }
}
