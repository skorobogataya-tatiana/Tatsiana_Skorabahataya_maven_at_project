package tests.junit;

import driver.Driver;
import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingCSSHotelPage;
import pages.booking.BookingCssHomePage;
import pages.booking.BookingHomePage;
import pages.booking.BookingHotelPage;
import tests.BaseTest;

public class BookingTests extends BaseTest {
    private BookingHomePage bookingHomePage = new BookingHomePage();
    private BookingCssHomePage bookingCssHomePage = new BookingCssHomePage();
    private BookingHotelPage bookingHotelPage = new BookingHotelPage();
    private BookingCSSHotelPage bookingCssHotelPage = new BookingCSSHotelPage();

    @Test
    public void searchForHotelInParis() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("Париж");
        bookingHomePage.selectDates(2, 4);
        bookingHomePage.selectOccupancy(2, 1);
        bookingHomePage.searchOptions();
        bookingHomePage.filterHotelsOnRate();
        bookingHomePage.filterResultsFromLowToHighScore();
        Assert.assertTrue("Rate of the hotel is lower than 6.0", bookingHomePage.compareHotelRate(6.0));
    }

    @Test
    public void searchForHotelInParisCSS() {
        bookingCssHomePage.openBookingHomepage();
        bookingCssHomePage.selectCityViaEnter("Париж");
        bookingCssHomePage.selectDates(2, 4);
        bookingCssHomePage.selectOccupancy(2, 1);
        bookingCssHomePage.searchOptions();
        bookingCssHomePage.filterHotelsOnRate();
        bookingCssHomePage.filterResultsFromLowToHighScore();
        Assert.assertTrue("Rate of the hotel is lower than 6.0", bookingCssHomePage.compareHotelRate(6.0));
    }

    @Test
    public void searchForHotelInLondon() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("London");
        bookingHomePage.scrollToTenthHotel();
        bookingHomePage.changeHotelCardColors();
        Driver.makeScreenshot();
    }

    @Test
    public void checkCurrencyButtonTooltip() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.hoverCurrencyButton();
        Assert.assertTrue("Tooltip of currency button is not 'Select your currency'", bookingHomePage.checkCurrencyTooltip("Select your currency"));
    }

    @Test
    public void checkLanguagesButtonTooltip() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.hoverLanguagesButton();
        Assert.assertTrue("Tooltip of languages button is not 'Select your language'", bookingHomePage.checkLanguagesTooltip("Select your language"));
    }

    @Test
    public void searchForTopHotelInPrague() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("Прага");
        bookingHomePage.clickOutOfCalendarRegion();
        bookingHomePage.filterResultsFromHighToLowScore();
        bookingHomePage.selectFirstHotelInTheList();
        Driver.switchToTheLastBrowserTab();
        Assert.assertTrue("Rate of the hotel is less than 8", bookingHotelPage.checkScoreOfTheHotel(8.0));
    }

    @Test
    public void searchForTopHotelInPragueCSS() {
        bookingCssHomePage.openBookingHomepage();
        bookingCssHomePage.selectCityViaEnter("Прага");
        bookingCssHomePage.clickOutOfCalendarRegion();
        bookingCssHomePage.filterResultsFromHighToLowScore();
        bookingCssHomePage.selectFirstHotelInTheList();
        Driver.switchToTheLastBrowserTab();
        Assert.assertTrue("Rate of the hotel is less than 8", bookingCssHotelPage.checkScoreOfTheHotel(8.0));
    }
}
