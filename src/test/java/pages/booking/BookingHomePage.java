package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingHomePage {
    WebDriver driver = Driver.getWebDriver();
    public static final String SEARCH_FIELD_XPATH = "//input[@name='ss']";
    public static final String CLOSE_ALERT_BUTTON_XPATH = "//button[@aria-label='Dismiss sign-in info.']/span";
    public static final String FIRST_AUTOCOMPLETE_SEARCH_VALUE = "//ul[@role='group']/li[1]";
    public static final String CLEAR_SEARCH_VALUE_ICON_XPATH = "//div[@data-testid='destination-container']//span[@data-testid='input-clear']";
    public static final String START_DATE_XPATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String END_DATE_XPATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String OCCUPANCY_XPATH = "//button[@data-testid='occupancy-config']";
    public static final String ADD_ADULTS_XPATH = "//input[@id='group_adults']/parent::div//button[2]";
    public static final String ADD_ROOMS_XPATH = "//input[@id='no_rooms']/parent::div//button[2]";
    public static final String CONFIRM_OCCUPANCY_XPATH = "//button/span[text()='Done']";
    public static final String SEARCH_OPTIONS_BUTTON_XPATH = "//button/span[text()='Search']";
    public static final String SCORE_CHECKBOX_XPATH = "//div[text()='Pleasant: 6+']";
    public static final String BUTTON_WITH_SELECTED_SCORE_XPATH = "//div[@class='a1d43fa1ac']/div/label/span";
    public static final String SORTING_DROPDOWN_XPATH = "//button[@data-testid='sorters-dropdown-trigger']";
    public static final String HIGH_TO_LOW_SORTING_XPATH = "//span[text()='Property rating (high to low)']";
    public static final String LOW_TO_HIGH_SORTING_XPATH = "//span[text()='Property rating (low to high)']";
    public static final String HOTEL_RATE_XPATH = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div";
    public static final String HOTEL_TEN_XPATH = "//div[@data-testid='property-card'][10]";
    public static final String CURRENCY_BUTTON_XPATH = "//button[@data-testid='header-currency-picker-trigger']/span";
    public static final String CURRENCY_TOOLTIP_XPATH = "//div[text()='Select your currency']";
    public static final String LANGUAGES_BUTTON_XPATH = "//button[@data-testid='header-language-picker-trigger']/span";
    public static final String LANGUAGES_TOOLTIP_XPATH = "//div[text()='Select your language']";
    public static final String OUT_OF_CALENDAR_XPATH = "//div[@data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']";
    public static final String FIRST_HOTEL_IN_THE_LIST_XPATH = "//div[@data-testid='property-card'][1]//a[@data-testid='title-link']";

    public static final String CALENDAR_XPATH = "//div[@data-testid='searchbox-datepicker-calendar']";
    public static final String SIDEBAR_FILTERS_XPATH = "//div[@class='b4b4b2787f']/div[@data-testid='filters-sidebar']";

    public void openBookingHomepage() {
        driver.get("https://booking.com");
        try {
            driver.findElement(By.xpath(CLOSE_ALERT_BUTTON_XPATH)).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void selectCityViaAutoselectOption(String cityName) {

        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_AUTOCOMPLETE_SEARCH_VALUE)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void selectCityViaEnter(String cityName) {
        try {
            driver.findElement(By.xpath(CLEAR_SEARCH_VALUE_ICON_XPATH)).click();
        } catch(NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(cityName);
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(Keys.ENTER);
    }

    public void selectDates(int startDay, int endDay)  {

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CALENDAR_XPATH)));
        driver.findElement(By.xpath(String.format(START_DATE_XPATH, startDay))).click();
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(END_DATE_XPATH, endDay))))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void selectOccupancy(int numberOfAdultsToAdd, int numberOfRoomsToAdd) {
        driver.findElement(By.xpath(OCCUPANCY_XPATH)).click();
        for (int i = 0; i < numberOfAdultsToAdd; i++) {
            driver.findElement(By.xpath(ADD_ADULTS_XPATH)).click();
        }

        for (int j = 0; j < numberOfRoomsToAdd; j++) {
            driver.findElement(By.xpath(ADD_ROOMS_XPATH)).click();
        }

        driver.findElement(By.xpath(CONFIRM_OCCUPANCY_XPATH)).click();
    }

    public void searchOptions() {
        driver.findElement(By.xpath(SEARCH_OPTIONS_BUTTON_XPATH)).click();
   }

    public void filterHotelsOnRate() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SIDEBAR_FILTERS_XPATH)));
        driver.findElement(By.xpath(SCORE_CHECKBOX_XPATH)).click();
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_WITH_SELECTED_SCORE_XPATH)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void filterResultsFromLowToHighScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.xpath(SORTING_DROPDOWN_XPATH)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(LOW_TO_HIGH_SORTING_XPATH)).click();
    }

    public void filterResultsFromHighToLowScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.xpath(SORTING_DROPDOWN_XPATH)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(HIGH_TO_LOW_SORTING_XPATH)).click();
    }

    public boolean compareHotelRate(double expectedRate) {
        List<String> scoreText = new ArrayList<>(Arrays.asList(driver.findElement(By.xpath(HOTEL_RATE_XPATH)).getText().split(" ")));
        double score = Double.parseDouble(scoreText.get(1));
        return score > expectedRate;
    }

    public void scrollToTenthHotel() {
        WebElement tenHotel = driver.findElement(By.xpath(HOTEL_TEN_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenHotel);
    }

    public void changeHotelCardColors() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", driver.findElement(By.xpath(HOTEL_TEN_XPATH)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", driver.findElement(By.xpath(HOTEL_TEN_XPATH)));
    }

    public boolean checkCurrencyTooltip() {
        WebElement currencyButton = driver.findElement(By.xpath(CURRENCY_BUTTON_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyButton);
        actions.perform();
        return driver.findElement(By.xpath(CURRENCY_TOOLTIP_XPATH)).getText()
                .equals("Select your currency");
    }

    public boolean checkLanguagesTooltip() {
        WebElement languagesButton = driver.findElement(By.xpath(LANGUAGES_BUTTON_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(languagesButton);
        actions.perform();
        return driver.findElement(By.xpath(LANGUAGES_TOOLTIP_XPATH)).getText()
                .equals("Select your language");
    }

    public void clickOutOfCalendarRegion() {
        driver.findElement(By.xpath(OUT_OF_CALENDAR_XPATH)).click();
    }

    public void selectFirstHotelInTheList() {
        driver.findElement(By.xpath(FIRST_HOTEL_IN_THE_LIST_XPATH)).click();
    }

}
