package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingCssHomePage {
    WebDriver driver = Driver.getWebDriver();

    public static int startDay = LocalDate.now().plusDays(3).getDayOfMonth();
    public static int endDay = LocalDate.now().plusDays(10).getDayOfMonth();
    public static final String SEARCH_FIELD_CSS = "input[name='ss']";
    public static final String CLOSE_ALERT_BUTTON_CSS = "button[aria-label='Dismiss sign-in info.'] > span > span";
    public static final String FIRST_AUTOCOMPLETE_SEARCH_VALUE_CSS = "#autocomplete-result-0 > div > div > div > div.a3332d346a.d2f04c9037";
    public static final String START_DATE_XPATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String END_DATE_XPATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String OCCUPANCY_CSS = "button[data-testid='occupancy-config']";
    public static final String ADD_ADULTS_CSS = "div[data-testid='occupancy-popup'] > div > div:first-child > div > button~button > span";
    public static final String ADD_ROOMS_CSS = "div[data-testid='occupancy-popup'] > div > div:nth-of-type(3) > div > button~button > span";
    public static final String CONFIRM_OCCUPANCY_CSS = "div[data-testid='occupancy-popup'] > button";
    public static final String SEARCH_OPTIONS_BUTTON_CSS = "button[type='submit']";
    public static final String SCORE_CHECKBOX_CSS = "div.df7e6ba27d > div:nth-of-type(1) > div:nth-of-type(3) > div[data-filters-group='review_score']  > div:nth-of-type(10) > label span:nth-of-type(2)";
    public static final String BUTTON_WITH_SELECTED_SCORE_CSS = "div.dcf496a7b9.bb2746aad9 > div:nth-of-type(1) > div > label > span > span > span > span";
    public static final String SORTING_DROPDOWN_CSS = "button[data-testid='sorters-dropdown-trigger']";
    public static final String HIGH_TO_LOW_SORTING_CSS = "ul.ad7c39949a > li:nth-child(3) > button > div span";
    public static final String LOW_TO_HIGH_SORTING_CSS = "ul.ad7c39949a > li:nth-child(6) > button > div span";
    public static final String HOTEL_RATE_CSS = ".d4924c9e74 > div:nth-of-type(3) > div > div:nth-of-type(2) > div > div > div ~ div > div > div > a >span > div .ac4a7896c7";
    public static final String OUT_OF_CALENDAR_CSS = "div[data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']";
    public static final String FIRST_HOTEL_IN_THE_LIST_CSS = ".df7e6ba27d > div:nth-of-type(2) > div:nth-of-type(2) > div ~ div ~ div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) h3 a";
    public static final String CALENDAR_CSS = "div[data-testid='searchbox-datepicker-calendar']";
    public static final String SIDEBAR_FILTERS_CSS = "div.b4b4b2787f > div[data-testid='filters-sidebar']";

    public void openBookingHomepage() {
        driver.get("https://booking.com");
        try {
            driver.findElement(By.cssSelector(CLOSE_ALERT_BUTTON_CSS)).click();
            new WebDriverWait(driver, Duration.ofSeconds(40))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_ALERT_BUTTON_CSS)))
                    .click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void selectCityViaAutoselectOption(String cityName) {

        driver.findElement(By.cssSelector(SEARCH_FIELD_CSS)).sendKeys(cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FIRST_AUTOCOMPLETE_SEARCH_VALUE_CSS)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void selectCityViaEnter(String cityName) {

        driver.findElement(By.cssSelector(SEARCH_FIELD_CSS)).sendKeys(cityName);
        driver.findElement(By.cssSelector(SEARCH_FIELD_CSS)).sendKeys(Keys.ENTER);
    }

    public void selectDates() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CALENDAR_CSS)));
        driver.findElement(By.xpath(String.format(START_DATE_XPATH, 26))).click();
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(END_DATE_XPATH, 27))))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void selectOccupancy(int numberOfAdultsToAdd, int numberOfRoomsToAdd) {
        driver.findElement(By.cssSelector(OCCUPANCY_CSS)).click();
        for (int i = 0; i < numberOfAdultsToAdd; i++) {
            driver.findElement(By.cssSelector(ADD_ADULTS_CSS)).click();
        }

        for (int j = 0; j < numberOfRoomsToAdd; j++) {
            driver.findElement(By.cssSelector(ADD_ROOMS_CSS)).click();
        }

        driver.findElement(By.cssSelector(CONFIRM_OCCUPANCY_CSS)).click();
    }

    public void searchOptions() {
        driver.findElement(By.cssSelector(SEARCH_OPTIONS_BUTTON_CSS)).click();
    }

    public void filterHotelsOnRate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SIDEBAR_FILTERS_CSS)));
        driver.findElement(By.cssSelector(SCORE_CHECKBOX_CSS)).click();
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BUTTON_WITH_SELECTED_SCORE_CSS)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void filterResultsFromLowToHighScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.cssSelector(SORTING_DROPDOWN_CSS)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(LOW_TO_HIGH_SORTING_CSS)).click();
    }

    public void filterResultsFromHighToLowScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.cssSelector(SORTING_DROPDOWN_CSS)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(HIGH_TO_LOW_SORTING_CSS)).click();
    }

    public boolean compareHotelRate(double expectedRate) {
        List<String> scoreText = new ArrayList<>(Arrays.asList(driver.findElement(By.cssSelector(HOTEL_RATE_CSS)).getText().split(" ")));
        double score = Double.parseDouble(scoreText.get(1));
        return score > expectedRate;
    }

    public void clickOutOfCalendarRegion() {
        driver.findElement(By.cssSelector(OUT_OF_CALENDAR_CSS)).click();
    }

    public void selectFirstHotelInTheList() {
        driver.findElement(By.cssSelector(FIRST_HOTEL_IN_THE_LIST_CSS)).click();
    }
}
