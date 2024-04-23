package utils;

import driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;

public class MyUtils {
    static WebDriver driver = Driver.getWebDriver();
    public static void makeScreenshot() {
        byte[] asBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        try {
            Files.write(Paths.get("C:\\Users\\Tatsiana_Skorabahata\\Desktop\\automation\\JavaCourse\\hometasks\\hotels\\hotel.png"), asBytes);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void switchToTheLastBrowserTab() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
