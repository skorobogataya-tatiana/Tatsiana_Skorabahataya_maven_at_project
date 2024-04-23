package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {
    WebDriver driver = Driver.getWebDriver();
    public static final String SEARCH_FIELD = "//*[@name='q']";
    public static final String CHANGE_TO_ENGLISH = "//a[text()='Change to English']";
    public static final String SEARCH_RESULTS = "//div/h1[text()='Search Results']/../div/div";

    public void openGoogle() {
        driver.get("https://google.com");
    }

    public void insertAndSearchCopyPastedValue() {
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(Keys.LEFT_CONTROL, "v");
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(CHANGE_TO_ENGLISH)).click();
    }

    public boolean checkThatSearchWordPresentInAllSearchResults(String searchWord) {
        List<WebElement> searchResults = driver.findElements(By.xpath(SEARCH_RESULTS));
        String wordToCheck = searchWord;

        boolean allResultsContainWord = true;
        for (WebElement result : searchResults) {
            String resultText = result.getText().toLowerCase();
            if (!resultText.contains(wordToCheck)) {
                allResultsContainWord = false;
                break;
            }
        }
        return allResultsContainWord;
    }

}
