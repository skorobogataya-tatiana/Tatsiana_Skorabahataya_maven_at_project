package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;

public class BookingHomePage extends BaseTest {
    WebDriver driver = Driver.getWebDriver();

    public static int startDay = LocalDate.now().plusDays(3).getDayOfMonth();
    public static int endDay = LocalDate.now().plusDays(10).getDayOfMonth();
    public static final String SEARCH_FIELD = "//input[@name='ss']";
    public static final String CLOSE_ALERT_BUTTON = "//button[@aria-label='Dismiss sign-in info.']/span";
    public static final String FIRST_AUTOCOMPLETE_SEARCH_VALUE = "//ul[@role='group']/li[1]";
    public static final String START_DATE_PATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String END_DATE_PATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    public static final String OCCUPANCY = "//button[@data-testid='occupancy-config']";
    public static final String ADD_ADULTS = "//input[@id='group_adults']/parent::div//button[2]";
    public static final String ADD_ROOMS = "//input[@id='no_rooms']/parent::div//button[2]";
    public static final String CONFIRM_OCCUPANCY = "//button/span[text()='Done']";
    public static final String SEARCH_OPTIONS_BUTTON = "//button/span[text()='Search']";
    public static final String SCORE_CHECKBOX = "//div[text()='Pleasant: 6+']";
    public static final String BUTTON_WITH_SELECTED_SCORE = "//div[@class='a1d43fa1ac']/div/label/span";
    public static final String SORTING_DROPDOWN = "//button[@data-testid='sorters-dropdown-trigger']";
    public static final String HIGH_TO_LOW_SORTING = "//span[text()='Property rating (high to low)']";
    public static final String LOW_TO_HIGH_SORTING = "//span[text()='Property rating (low to high)']";
    public static final String HOTEL_RATE = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div";
    public static final String LOADING_INDICATOR = "//div[@data-testid='skeleton-loader']";
    public static final String HOTEL_TEN = "//div[@data-testid='property-card'][10]";
    public static final String CURRENCY_BUTTON = "//button[@data-testid='header-currency-picker-trigger']/span";
    public static final String LANGUAGES_BUTTON = "//button[@data-testid='header-language-picker-trigger']/span";
    public static final String OUT_OF_CALENDAR = "//div[@data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']";
    public static final String FIRST_HOTEL_IN_THE_LIST = "//div[@data-testid='property-card'][1]//a[@data-testid='title-link']";

    public void openBookingHomepage() {
        driver.get("https://booking.com");
        try {
            /*driver.findElement(By.xpath(CLOSE_ALERT_BUTTON)).click();*/
            new WebDriverWait(driver, Duration.ofSeconds(40))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_ALERT_BUTTON)))
                    .click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void selectCityViaAutoselectOption(String city) {

        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(city);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_AUTOCOMPLETE_SEARCH_VALUE)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void selectCityViaEnter(String city) {

        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(city);
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(Keys.ENTER);
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
        driver.findElement(By.xpath(OCCUPANCY)).click();
        for (int i = 0; i < numberOfAdultsToAdd; i++) {
            driver.findElement(By.xpath(ADD_ADULTS)).click();
        }

        for (int j = 0; j < numberOfRoomsToAdd; j++) {
            driver.findElement(By.xpath(ADD_ROOMS)).click();
        }

        driver.findElement(By.xpath(CONFIRM_OCCUPANCY)).click();
    }

    public void searchOptions() {
        driver.findElement(By.xpath(SEARCH_OPTIONS_BUTTON)).click();
   }

    public void filterHotelsOnRate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SCORE_CHECKBOX)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_WITH_SELECTED_SCORE)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(LOADING_INDICATOR))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void filterResultsFromLowToHighScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.xpath(SORTING_DROPDOWN)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(LOW_TO_HIGH_SORTING)).click();
    }

    public void filterResultsFromHighToLowScore() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement sorting = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(drv -> drv.findElement(By.xpath(SORTING_DROPDOWN)));
        sorting.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(HIGH_TO_LOW_SORTING)).click();
    }

    public boolean compareHotelRate(double expectedRate) {
        String[] scoreText = driver.findElement(By.xpath(HOTEL_RATE)).getText().split(" ");
        double score = Double.parseDouble(scoreText[1]);
        return score > expectedRate;
    }

    public void scrollToTenthHotel() {
        WebElement tenHotel = driver.findElement(By.xpath(HOTEL_TEN));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenHotel);
    }

    public void changeHotelCardColors() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", driver.findElement(By.xpath(HOTEL_TEN)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", driver.findElement(By.xpath(HOTEL_TEN)));
    }

    public boolean checkCurrencyTooltip() {
        WebElement currencyButton = driver.findElement(By.xpath(CURRENCY_BUTTON));
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyButton);
        actions.perform();
        return driver.findElement(By.xpath("//div[text()='Select your language']")).getText()
                .equals("Select your currency");
    }

    public boolean checkLanguagesTooltip() {
        WebElement languagesButton = driver.findElement(By.xpath(LANGUAGES_BUTTON));
        Actions actions = new Actions(driver);
        actions.moveToElement(languagesButton);
        actions.perform();
        return driver.findElement(By.xpath("//div[text()='Select your language']")).getText()
                .equals("Select your language");
    }

    public void clickOutOfCalendarRegion() {
        driver.findElement(By.xpath(OUT_OF_CALENDAR)).click();
    }

    public void selectFirstHotelInTheList() {
        driver.findElement(By.xpath(FIRST_HOTEL_IN_THE_LIST)).click();
    }

}
