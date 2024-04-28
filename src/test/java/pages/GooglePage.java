package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {
    private static final Logger LOGGER = LogManager.getLogger(GooglePage.class);
    WebDriver driver = Driver.getWebDriver();
    public static final String SEARCH_FIELD_XPATH = "//*[@name='q']";
    public static final String CHANGE_TO_ENGLISH_XPATH = "//a[text()='Change to English']";
    public static final String SEARCH_RESULTS_XPATH = "//div/h1[text()='Search Results']/../div/div";

    public void openGoogle() {

        driver.get("https://google.com");
        LOGGER.info("Google home page was opened");
    }

    public void insertAndSearchCopyPastedValue() {
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(Keys.LEFT_CONTROL, "v");
        LOGGER.info("Copied value was pasted to the search field");
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(Keys.ENTER);
        LOGGER.info("Search was triggered");
        driver.findElement(By.xpath(CHANGE_TO_ENGLISH_XPATH)).click();
    }

    public boolean checkThatSearchWordPresentInAllSearchResults(String searchWord) {
        List<WebElement> searchResults = driver.findElements(By.xpath(SEARCH_RESULTS_XPATH));
        String wordToCheck = searchWord;

        boolean allResultsContainWord = true;
        for (WebElement result : searchResults) {
            String resultText = result.getText().toLowerCase();
            if (!resultText.contains(wordToCheck)) {
                allResultsContainWord = false;
                break;
            }
        }
        LOGGER.info("Search results were checked for containing the word {}", searchWord);
        return allResultsContainWord;
    }

}
