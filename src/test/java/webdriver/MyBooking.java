package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MyBooking {
    public static void main(String[] args)  {
        int startDay = LocalDate.now().plusDays(3).getDayOfMonth();
        int endDay = LocalDate.now().plusDays(10).getDayOfMonth();
        String closeAlertButton = "//button[@aria-label='Dismiss sign-in info.']/span";
        String searchField = "//input[@name='ss']";
        String searchValue = "//ul[@role='group']/li[1]";
        String startDatePath = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        String endDatePath = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        String occupancy = "//button[@data-testid='occupancy-config']";
        String moreAdults = "//input[@id='group_adults']/parent::div//button[2]";
        String moreRooms = "//input[@id='no_rooms']/parent::div//button[2]";
        String confirmOccupancy = "//button/span[text()='Done']";
        String searchVariants = "//button/span[text()='Search']";
        String hotelsScoreCheckbox = "//div[text()='Pleasant: 6+']";
        String sortingDropdown = "//button[@data-testid='sorters-dropdown-trigger']";
        String lowToHighSorting = "//span[text()='Property rating (low to high)']";
        String rate = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://booking.com");

        try {
            driver.findElement(By.xpath(closeAlertButton)).click();
        } catch(NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.findElement(By.xpath(searchField)).sendKeys("Париж");
        driver.findElement(By.xpath(searchValue)).click();
        driver.findElement(By.xpath(String.format(startDatePath,startDay))).click();
        driver.findElement(By.xpath(String.format(endDatePath,endDay))).click();
        driver.findElement(By.xpath(occupancy)).click();
        driver.findElement(By.xpath(moreAdults)).click();
        driver.findElement(By.xpath(moreAdults)).click();
        driver.findElement(By.xpath(moreRooms)).click();
        driver.findElement(By.xpath(confirmOccupancy)).click();
        driver.findElement(By.xpath(searchVariants)).click();

        try {
            driver.findElement(By.xpath(closeAlertButton)).click();
        } catch(NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(hotelsScoreCheckbox)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.xpath(sortingDropdown)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(lowToHighSorting)).click();
        assertEquals("Score of the first sorted hotel is wrong", "Scored 7.4", driver.findElement(By.xpath(rate)).getText());
        driver.close();
    }
}
