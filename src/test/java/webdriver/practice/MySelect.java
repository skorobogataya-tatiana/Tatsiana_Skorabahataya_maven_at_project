package webdriver.practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MySelect {
    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void selectColor() {

        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu1 = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select1 = new Select(selectMenu1);
        select1.selectByValue("2");

        Assert.assertTrue("Green value is not selected", driver.findElement(By.xpath("//option[text()='Green']")).isSelected());
    }

    @Test
    public void selectCar() {
        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu2 = driver.findElement(By.xpath("//select[@id='cars']"));
        Select select2 = new Select(selectMenu2);
        select2.selectByValue("audi");

        Assert.assertTrue("Audi car is not selected", driver.findElement(By.xpath("//option[text()='Audi']")).isSelected());
    }

    @After
    public void closeWindows() {
        driver.quit();
    }
}
