package pages.booking;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingHomePage {
    private static final Logger LOGGER = LogManager.getLogger(BookingHomePage.class);
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
    public static final String SIGN_IN_BUTTON_XPATH = "//span[text()='Sign in']";
    public static final String LIKE_BUTTON_XPATH = "//button[@data-testid='wishlist-button']";

    public void openBookingHomepage() {
        driver.get("https://booking.com");
        LOGGER.info("Booking home page is opened");
        try {
            driver.findElement(By.xpath(CLOSE_ALERT_BUTTON_XPATH)).click();
            LOGGER.info("Login info popup is closed");
        } catch (NoSuchElementException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
        }
    }

    public void SignIn() {
        driver.findElement(By.xpath(SIGN_IN_BUTTON_XPATH)).click();
        LOGGER.info("Sign in button was clicked");
    }

    public void selectCityViaAutoselectOption(String cityName) {

        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(cityName);
        LOGGER.info("City name {} was typed in search field", cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_AUTOCOMPLETE_SEARCH_VALUE)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LOGGER.info("City name {} was selected from the auto-select menu", cityName);
    }

    public void selectCityViaEnter(String cityName) {
        try {
            driver.findElement(By.xpath(CLEAR_SEARCH_VALUE_ICON_XPATH)).click();
            LOGGER.info("Clearing of search field is executed");
        } catch (NoSuchElementException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
        }

        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(cityName);
        LOGGER.info("City name {} was entered into the search field", cityName);
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(Keys.ENTER);
        LOGGER.info("Search of hotels in {} city was triggered via Enter keyboard button", cityName);
    }

    public void selectDates(int startDayInDays, int endDayInDays) {
        int startDate = LocalDate.now().plusDays(startDayInDays).getDayOfMonth();
        int endDate = LocalDate.now().plusDays(endDayInDays).getDayOfMonth();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CALENDAR_XPATH)));
        driver.findElement(By.xpath(String.format(START_DATE_XPATH, startDate))).click();
        LOGGER.info("Start date {} was selected", startDate);
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(END_DATE_XPATH, endDate))))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LOGGER.info("End date {} was selected", endDate);
    }

    public void selectOccupancy(int numberOfAdultsToAdd, int numberOfRoomsToAdd) {
        driver.findElement(By.xpath(OCCUPANCY_XPATH)).click();
        for (int i = 0; i < numberOfAdultsToAdd; i++) {
            driver.findElement(By.xpath(ADD_ADULTS_XPATH)).click();
        }
        LOGGER.info("{} more adults were added", numberOfAdultsToAdd);

        for (int j = 0; j < numberOfRoomsToAdd; j++) {
            driver.findElement(By.xpath(ADD_ROOMS_XPATH)).click();
        }
        LOGGER.info("{} more rooms were added", numberOfRoomsToAdd);

        driver.findElement(By.xpath(CONFIRM_OCCUPANCY_XPATH)).click();
        LOGGER.info("Occupancy was confirmed");
    }

    public void searchOptions() {

        driver.findElement(By.xpath(SEARCH_OPTIONS_BUTTON_XPATH)).click();
        LOGGER.info("Search of options with indicated number of visitors and required number of rooms was triggered.");
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
        LOGGER.info("Hotels in search results were filtered on score rate 6+");
    }

    public void filterResultsFromLowToHighScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.xpath(SORTING_DROPDOWN_XPATH)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(LOW_TO_HIGH_SORTING_XPATH)).click();
        LOGGER.info("Hotels in search results were sorted by score from lowest to highest");
    }

    public void filterResultsFromHighToLowScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.xpath(SORTING_DROPDOWN_XPATH)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(HIGH_TO_LOW_SORTING_XPATH)).click();
        LOGGER.info("Hotels in search results were sorted by score from highest to lowest");
    }

    public boolean compareHotelRate(double expectedRate) {
        List<String> scoreText = new ArrayList<>(Arrays.asList(driver.findElement(By.xpath(HOTEL_RATE_XPATH)).getText().split(" ")));
        double score = Double.parseDouble(scoreText.get(1));
        LOGGER.info("Score of the hotel was compared with the expected score of {}", expectedRate);
        return score > expectedRate;
    }

    public void scrollToTenthHotel() {
        WebElement tenHotel = driver.findElement(By.xpath(HOTEL_TEN_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenHotel);
        LOGGER.info("Page was scrolled to the tenth hotel in search results list");
    }

    public void changeHotelCardColors() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", driver.findElement(By.xpath(HOTEL_TEN_XPATH)));
        LOGGER.info("Color of background was changed to green");
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", driver.findElement(By.xpath(HOTEL_TEN_XPATH)));
        LOGGER.info("Color of font was changed to red");
    }

    public void hoverCurrencyButton() {
        WebElement currencyButton = driver.findElement(By.xpath(CURRENCY_BUTTON_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyButton);
        actions.perform();
        LOGGER.info("Currency button was hovered");
    }

    public boolean checkCurrencyTooltip(String currencyTooltipValue) {
        return driver.findElement(By.xpath(CURRENCY_TOOLTIP_XPATH)).getText().equals(currencyTooltipValue);
    }

    public void hoverLanguagesButton() {
        WebElement languagesButton = driver.findElement(By.xpath(LANGUAGES_BUTTON_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(languagesButton);
        actions.perform();
        LOGGER.info("Languages button was hovered");
    }

    public boolean checkLanguagesTooltip(String languagesTooltipValue) {
        return driver.findElement(By.xpath(LANGUAGES_TOOLTIP_XPATH)).getText().equals(languagesTooltipValue);
    }

    public void clickOutOfCalendarRegion() {

        driver.findElement(By.xpath(OUT_OF_CALENDAR_XPATH)).click();
        LOGGER.info("Clock out of calendar component was executed");
    }

    public void selectFirstHotelInTheList() {

        driver.findElement(By.xpath(FIRST_HOTEL_IN_THE_LIST_XPATH)).click();
        LOGGER.info("First hotel in the search results was selected");
    }

    public void signIn() {

        driver.findElement(By.xpath(SIGN_IN_BUTTON_XPATH)).click();
        LOGGER.info("Sign in to booking button was clicked");
    }

    public void likeFirstAndLastHotelInTheList() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElements(By.xpath(LIKE_BUTTON_XPATH)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        List<WebElement> likeButtons = driver.findElements(By.xpath(LIKE_BUTTON_XPATH));
        likeButtons.getFirst().click();
        LOGGER.info("First hotel in the list was liked");
        likeButtons.getLast().click();
        LOGGER.info("Last hotel in the list was liked");
    }

    public boolean checkThtFirstAndLastHotelsAreLiked() {
        List<WebElement> likeButtons = driver.findElements(By.xpath(LIKE_BUTTON_XPATH));
        return (likeButtons.getFirst().getCssValue("color") == "red" & likeButtons.getLast().getAttribute("color") == "red");
    }

    public void returnColorValue() {
        List<WebElement> likeButtons = driver.findElements(By.xpath(LIKE_BUTTON_XPATH));
        System.out.println(likeButtons.getFirst().getAttribute("color"));

    }

}
