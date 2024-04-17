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
import java.time.LocalDate;
import java.util.Arrays;


public class MyBookingCSS {
    private WebDriver driver;

    int startDay = LocalDate.now().plusDays(3).getDayOfMonth();
    int endDay = LocalDate.now().plusDays(10).getDayOfMonth();
    String closeAlertButton = "button[aria-label='Dismiss sign-in info.'] > span > span";
    String searchField = "input[name='ss']";
    String searchValue = "#autocomplete-result-0 > div > div > div > div.a3332d346a.d2f04c9037";
    String startDatePath = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    String endDatePath = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    String occupancy = "button[data-testid='occupancy-config']";
    String moreAdults = "div[data-testid='occupancy-popup'] > div > div:first-child > div > button~button > span";
    String moreRooms = "div[data-testid='occupancy-popup'] > div > div:nth-of-type(3) > div > button~button > span";
    String confirmOccupancy = "div[data-testid='occupancy-popup'] > button";
    String searchVariants = "button[type='submit']";
    String hotelsScoreCheckbox = "div.df7e6ba27d > div:nth-of-type(1) > div:nth-of-type(3) > div[data-filters-group='review_score']  > div:nth-of-type(10) > label span:nth-of-type(2)";
    String sortingDropdown = "button[data-testid='sorters-dropdown-trigger']";
    String lowToHighSorting = "ul.ad7c39949a > li:nth-child(6) > button > div span";
    String buttonWithSelectedFilter = "div.dcf496a7b9.bb2746aad9 > div:nth-of-type(1) > div > label > span > span > span > span";
    String rate = ".d4924c9e74 > div:nth-of-type(3) > div > div:nth-of-type(2) > div > div > div ~ div > div > div > a >span > div .ac4a7896c7";

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void searchParisHotels() {

        driver.get("https://booking.com");

        try {
            driver.findElement(By.cssSelector(closeAlertButton)).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.findElement(By.cssSelector(searchField)).sendKeys("Париж");
        driver.findElement(By.cssSelector(searchValue)).click();
        driver.findElement(By.xpath(String.format(startDatePath, startDay))).click();
        driver.findElement(By.xpath(String.format(endDatePath, endDay))).click();
        driver.findElement(By.cssSelector(occupancy)).click();
        driver.findElement(By.cssSelector(moreAdults)).click();
        driver.findElement(By.cssSelector(moreAdults)).click();
        driver.findElement(By.cssSelector(moreRooms)).click();
        driver.findElement(By.cssSelector(confirmOccupancy)).click();
        driver.findElement(By.cssSelector(searchVariants)).click();

        try {
            driver.findElement(By.cssSelector(closeAlertButton)).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(hotelsScoreCheckbox)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(buttonWithSelectedFilter)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[data-testid='loader-container']"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.cssSelector(sortingDropdown)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(lowToHighSorting)).click();
        String[] scoreText = driver.findElement(By.cssSelector(rate)).getText().split(" ");
        double score = Double.parseDouble(scoreText[1]);
        Assert.assertTrue("Score of the first sorted hotel is wrong", 5.9 < score);
    }

    @After
    public void closeWindow() {
        driver.close();
    }
}

