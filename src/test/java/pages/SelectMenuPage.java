package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage {
    WebDriver driver = Driver.getWebDriver();
    public static final String OLD_SELECT_MENU = "//select[@id='oldSelectMenu']";
    public static final String GREEN_COLOR = "//option[text()='Green']";
    public static final String CARS_MENU = "//select[@id='cars']";
    public static final String AUDI = "//option[text()='Audi']";

    public void openSelectMenuPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void selectGreenColor() {
        WebElement selectMenu1 = driver.findElement(By.xpath(OLD_SELECT_MENU));
        Select select1 = new Select(selectMenu1);
        select1.selectByValue("2");
    }

    public boolean checkThatGreenColorIsSelected() {
        return driver.findElement(By.xpath(GREEN_COLOR)).isSelected();
    }

    public void selectAudi() {
        WebElement selectMenu2 = driver.findElement(By.xpath(CARS_MENU));
        Select select2 = new Select(selectMenu2);
        select2.selectByValue("audi");
    }

    public boolean checkThatAudiIsSelected() {
        return driver.findElement(By.xpath(AUDI)).isSelected();
    }
}
