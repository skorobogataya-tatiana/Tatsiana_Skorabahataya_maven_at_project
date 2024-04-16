package webdriver.practice;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

        WebElement gallery = driver.findElement(By.xpath("//div[@data-component='gallery-side-reviews']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gallery);
        actions.perform();

        String scoreInfo = driver.findElement(By.xpath("//div[@data-testid='review-score-right-component']/div")).getText();
        System.out.println(scoreInfo);
    }
}
