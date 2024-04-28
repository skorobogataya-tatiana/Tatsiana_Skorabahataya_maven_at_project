package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage {
    private static final Logger LOGGER = LogManager.getLogger(SelectMenuPage.class);
    WebDriver driver = Driver.getWebDriver();
    public static final String OLD_SELECT_MENU_XPATH = "//select[@id='oldSelectMenu']";
    public static final String GREEN_COLOR_XPATH = "//option[text()='%s']";
    public static final String CARS_MENU_XPATH = "//select[@id='cars']";
    public static final String AUDI_XPATH = "//option[text()='%s']";

    public void openSelectMenuPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void selectColor(String colorNumber) {
        WebElement selectMenu1 = driver.findElement(By.xpath(OLD_SELECT_MENU_XPATH));
        Select select1 = new Select(selectMenu1);
        select1.selectByValue(colorNumber);
        LOGGER.info("Color with number {} was selected from the drop-down select list", colorNumber);
    }

    public boolean checkThatColorIsSelected(String color) {
        return driver.findElement(By.xpath(String.format(GREEN_COLOR_XPATH, color))).isSelected();
    }

    public void selectCar(String car) {
        WebElement selectMenu2 = driver.findElement(By.xpath(CARS_MENU_XPATH));
        Select select2 = new Select(selectMenu2);
        select2.selectByValue(car);
        LOGGER.info("{} car was selected from the select list", car);
    }

    public boolean checkThatCarIsSelected(String car) {

        return driver.findElement(By.xpath(String.format(AUDI_XPATH, car))).isSelected();
    }
}
