package pages.booking;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BookingHomePageLoggedIn {
    private static final Logger LOGGER = LogManager.getLogger(BookingHomePage.class);
    WebDriver driver = Driver.getWebDriver();

    private static final String HEADER_ELEMENTS_XPATH = "//nav[@data-testid='header-xpb']//li//span/div/span";

    public boolean checkHeaderElements() {
        List<String> supposedItemsOfHeader = new ArrayList<>();
        supposedItemsOfHeader.add("Stays");
        supposedItemsOfHeader.add("Flights");
        supposedItemsOfHeader.add("Car rentals");
        supposedItemsOfHeader.add("Attractions");
        supposedItemsOfHeader.add("Airport taxis");
        List<WebElement> headerItems = driver.findElements(By.xpath(HEADER_ELEMENTS_XPATH));
        boolean allHeaderItemsExist = true;

        for(String name : supposedItemsOfHeader) {
            boolean itemExists = false;
            for(WebElement headerElement : headerItems) {
                if (headerElement.getText().equals(name)) {
                    itemExists = true;
                    break;
                }
            }
            if(!itemExists) {
                allHeaderItemsExist = false;
                break;
            }
        }
        return allHeaderItemsExist;
    }
}
