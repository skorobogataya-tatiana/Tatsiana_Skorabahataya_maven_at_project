package webdriver.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;

public class MyBookingLondon {
    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void checkLondonHotel() {
        driver.get("https://booking.com");
        String searchField = "//input[@name='ss']";
        try {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']/span")).click();
        } catch(NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.findElement(By.xpath(searchField)).sendKeys("London");
        driver.findElement(By.xpath(searchField)).sendKeys(Keys.ENTER);

        WebElement tenHotel = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", tenHotel);
        //((JavascriptExecutor) driver).executeScript("arguments[0].click()", tenHotel);
        byte[] asBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        try {
            Files.write(Paths.get("C:\\Users\\Tatsiana_Skorabahata\\Desktop\\automation\\JavaCourse\\hometasks\\hotels\\hotel.png"), asBytes);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @After
    public void closeWindow() {
        driver.close();
    }
}
