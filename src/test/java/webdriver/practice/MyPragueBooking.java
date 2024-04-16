package webdriver.practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class MyPragueBooking {
    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void checkRateOfPragueHotel() {
        driver.get("https://booking.com");

        try {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']/span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        WebElement searchField = driver.findElement(By.xpath("//input[@name='ss']"));
        searchField.sendKeys("Прага");
        searchField.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[@data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']")).click();
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//span[text()='Property rating (high to low)']")).click();
        driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//a[@data-testid='title-link']")).click();

        String[] scoreInfo = driver.findElement(By
                .xpath("//*[@id='js--hp-gallery-scorecard']/a/div/div/div/div[1]/div")).getText().split(" ");
        double hotelScore = Double.parseDouble(scoreInfo[1]);
        Assert.assertTrue("Score of the hotel is less than 8", hotelScore > 8.0);

    }

    @After
    public void closeWindow() {
        driver.close();
    }
}
