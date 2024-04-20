package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;

public class BookingCssHomePage {
    WebDriver driver = Driver.getWebDriver();

    public static int startDay = LocalDate.now().plusDays(3).getDayOfMonth();
    public static int endDay = LocalDate.now().plusDays(10).getDayOfMonth();
    public static final String SEARCH_FIELD = "input[name='ss']";
    public static final String CLOSE_ALERT_BUTTON = "button[aria-label='Dismiss sign-in info.'] > span > span";
    public static final String FIRST_AUTOCOMPLETE_SEARCH_VALUE = "#autocomplete-result-0 > div > div > div > div.a3332d346a.d2f04c9037";
    public static final String START_DATE_PATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String END_DATE_PATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String OCCUPANCY = "button[data-testid='occupancy-config']";
    public static final String ADD_ADULTS = "div[data-testid='occupancy-popup'] > div > div:first-child > div > button~button > span";
    public static final String ADD_ROOMS = "div[data-testid='occupancy-popup'] > div > div:nth-of-type(3) > div > button~button > span";
    public static final String CONFIRM_OCCUPANCY = "div[data-testid='occupancy-popup'] > button";
    public static final String SEARCH_OPTIONS_BUTTON = "button[type='submit']";
    public static final String SCORE_CHECKBOX = "div.df7e6ba27d > div:nth-of-type(1) > div:nth-of-type(3) > div[data-filters-group='review_score']  > div:nth-of-type(10) > label span:nth-of-type(2)";
    public static final String BUTTON_WITH_SELECTED_SCORE = "div.dcf496a7b9.bb2746aad9 > div:nth-of-type(1) > div > label > span > span > span > span";
    public static final String SORTING_DROPDOWN = "button[data-testid='sorters-dropdown-trigger']";
    public static final String HIGH_TO_LOW_SORTING = "ul.ad7c39949a > li:nth-child(3) > button > div span";
    public static final String LOW_TO_HIGH_SORTING = "ul.ad7c39949a > li:nth-child(6) > button > div span";
    public static final String HOTEL_RATE = ".d4924c9e74 > div:nth-of-type(3) > div > div:nth-of-type(2) > div > div > div ~ div > div > div > a >span > div .ac4a7896c7";
    public static final String LOADING_INDICATOR = "div[data-testid='loader-container']";
    public static final String OUT_OF_CALENDAR = "div[data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']";
    public static final String FIRST_HOTEL_IN_THE_LIST = ".df7e6ba27d > div:nth-of-type(2) > div:nth-of-type(2) > div ~ div ~ div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) h3 a";

    public void openBookingHomepage() {
        driver.get("https://booking.com");
        try {
            /*driver.findElement(By.xpath(CLOSE_ALERT_BUTTON)).click();*/
            new WebDriverWait(driver, Duration.ofSeconds(40))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_ALERT_BUTTON)))
                    .click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void selectCityViaAutoselectOption(String city) {

        driver.findElement(By.cssSelector(SEARCH_FIELD)).sendKeys(city);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FIRST_AUTOCOMPLETE_SEARCH_VALUE)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void selectCityViaEnter(String city) {

        driver.findElement(By.cssSelector(SEARCH_FIELD)).sendKeys(city);
        driver.findElement(By.cssSelector(SEARCH_FIELD)).sendKeys(Keys.ENTER);
    }

    public void selectDates() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(START_DATE_PATH, startDay))))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(END_DATE_PATH, endDay))))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void selectOccupancy(int numberOfAdultsToAdd, int numberOfRoomsToAdd) {
        driver.findElement(By.cssSelector(OCCUPANCY)).click();
        for (int i = 0; i < numberOfAdultsToAdd; i++) {
            driver.findElement(By.cssSelector(ADD_ADULTS)).click();
        }

        for (int j = 0; j < numberOfRoomsToAdd; j++) {
            driver.findElement(By.cssSelector(ADD_ROOMS)).click();
        }

        driver.findElement(By.cssSelector(CONFIRM_OCCUPANCY)).click();
    }

    public void searchOptions() {
        driver.findElement(By.cssSelector(SEARCH_OPTIONS_BUTTON)).click();
    }

    public void filterHotelsOnRate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SCORE_CHECKBOX)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BUTTON_WITH_SELECTED_SCORE)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(LOADING_INDICATOR))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void filterResultsFromLowToHighScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.cssSelector(SORTING_DROPDOWN)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(LOW_TO_HIGH_SORTING)).click();
    }

    public void filterResultsFromHighToLowScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.cssSelector(SORTING_DROPDOWN)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(HIGH_TO_LOW_SORTING)).click();
    }

    public boolean compareHotelRate(double expectedRate) {
        String[] scoreText = driver.findElement(By.cssSelector(HOTEL_RATE)).getText().split(" ");
        double score = Double.parseDouble(scoreText[1]);
        return score > expectedRate;
    }

    public void clickOutOfCalendarRegion() {
        driver.findElement(By.cssSelector(OUT_OF_CALENDAR)).click();
    }

    public void selectFirstHotelInTheList() {
        driver.findElement(By.cssSelector(FIRST_HOTEL_IN_THE_LIST)).click();
    }
}
