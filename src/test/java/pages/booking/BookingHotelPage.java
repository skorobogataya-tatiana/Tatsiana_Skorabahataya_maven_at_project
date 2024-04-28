package pages.booking;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingHotelPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingHotelPage.class);
    WebDriver driver = Driver.getWebDriver();
    public static final String HOTEL_RATE_XPATH = "//div[@data-testid='review-score-component']/div[1]";

    public boolean checkScoreOfTheHotel(double expectedRate) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(HOTEL_RATE_XPATH)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String[] scoreInfo = driver.findElement(By.xpath(HOTEL_RATE_XPATH)).getText().split(" ");
        double hotelScore = Double.parseDouble(scoreInfo[1]);
        LOGGER.info("Rate of the hotel on hotel page was compared to the expected minimum rate of {}", expectedRate);
        return hotelScore >= expectedRate;
    }
}
