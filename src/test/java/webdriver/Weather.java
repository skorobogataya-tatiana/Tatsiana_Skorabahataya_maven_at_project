package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Weather {
    public static void main(String[] args) throws InterruptedException {
        String day = LocalDate.now().plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("погода минск weather");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]/div")).click();
        driver.findElement(By.xpath("//a[text()='Change to English']")).click();
        driver.findElement(By.xpath("//div[@id='wob_dp']/div[2]")).click();
        System.out.println(driver.findElement(By.xpath(String.format("//*[name()='text' and contains(@aria-label, 'Celsius %s 12:00')][2]", day)))
                .getAttribute("aria-label"));
    }
}
