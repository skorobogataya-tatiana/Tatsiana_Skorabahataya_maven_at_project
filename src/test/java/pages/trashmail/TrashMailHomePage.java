package pages.trashmail;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;

public class TrashMailHomePage {
    private static final Logger LOGGER = LogManager.getLogger(GooglePage.class);
    public static final String USERNAME_INPUT_XPATH = "//input[@placeholder='Username']";
    public static final String PASSWORD_INPUT_XPATH = "//input[@placeholder='Password']";
    public static final String LOGIN_BUTTON_XPATH = "";
    public static final String INPUT_REAL_EMAIL_XPATH = "//input[@id='fe-forward']";
    public static final String REQUEST_FAKE_EMAIL_BUTTON_XPATH = "//button[@id = 'fe-submit']";
    WebDriver driver = Driver.getWebDriver();


    public void openTrashMail() {
        driver.get("https://trashmail.com/");
        LOGGER.info("Trashmail homepage is opened.");
    }

    public void inputRealEmailValue(String email) {
        driver.findElement(By.xpath(INPUT_REAL_EMAIL_XPATH)).clear();
        driver.findElement(By.xpath(INPUT_REAL_EMAIL_XPATH)).sendKeys(email);
        LOGGER.info("Valid email is inputted to the email field.");
    }

    public void requestToGenerateEmail() {
        driver.findElement(By.xpath(REQUEST_FAKE_EMAIL_BUTTON_XPATH)).click();
        LOGGER.info("Fake trashmail email is requested");
    }


}
