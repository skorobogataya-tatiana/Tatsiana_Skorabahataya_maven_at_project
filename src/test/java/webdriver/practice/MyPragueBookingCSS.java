package webdriver.practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class MyPragueBookingCSS {
    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void checkRateOfPragueHotel() {
        driver.get("https://booking.com");

        try {
            driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.'] > span > span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        WebElement searchField = driver.findElement(By.cssSelector("input[name='ss']"));
        searchField.sendKeys("Прага");
        searchField.sendKeys(Keys.ENTER);

        try {
            driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.'] > span > span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

       driver.findElement(By.cssSelector("div[data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']")).click();
        driver.findElement(By.cssSelector("button[data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.cssSelector("ul.ad7c39949a > li:nth-child(3) > button > div span")).click();
        driver.findElement(By.cssSelector(".df7e6ba27d > div:nth-of-type(2) > div:nth-of-type(2) > div ~ div ~ div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) h3 a")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#js--hp-gallery-scorecard > a > div > div > div > div.a3b8729ab1.d86cee9b25")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String[] scoreInfo = driver.findElement(By
                .cssSelector("#js--hp-gallery-scorecard > a > div > div > div > div.a3b8729ab1.d86cee9b25")).getText().split(" ");
        double hotelScore = Double.parseDouble(scoreInfo[2]);
        Assert.assertTrue("Score of the hotel is less than 8", hotelScore > 8.0);

    }

/*    @After
    public void closeWindow() {
        driver.close();
    }*/
}
