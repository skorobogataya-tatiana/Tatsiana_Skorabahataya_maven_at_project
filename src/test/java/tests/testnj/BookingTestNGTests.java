package tests.testnj;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.booking.BookingCSSHotelPage;
import pages.booking.BookingCssHomePage;
import pages.booking.BookingHomePage;
import pages.booking.BookingHotelPage;
import utils.MyUtils;

public class BookingTestNGTests {
    private BookingHomePage bookingHomePage = new BookingHomePage();
    private BookingCssHomePage bookingCssHomePage = new BookingCssHomePage();
    private BookingHotelPage bookingHotelPage = new BookingHotelPage();
    private BookingCSSHotelPage bookingCssHotelPage = new BookingCSSHotelPage();

    @Test
    public void searchForHotelInParis() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("Париж");
        bookingHomePage.selectDates();
        bookingHomePage.selectOccupancy(2, 1);
        bookingHomePage.searchOptions();
        bookingHomePage.filterHotelsOnRate();
        bookingHomePage.filterResultsFromLowToHighScore();
        Assert.assertTrue(bookingHomePage.compareHotelRate(6.0), "Rate of the hotel is lowwer than 6.0");
    }

    @Test
    public void searchForHotelInParisCSS() {
        bookingCssHomePage.openBookingHomepage();
        bookingCssHomePage.selectCityViaEnter("Париж");
        bookingCssHomePage.selectDates();
        bookingCssHomePage.selectOccupancy(2, 1);
        bookingCssHomePage.searchOptions();
        bookingCssHomePage.filterHotelsOnRate();
        bookingCssHomePage.filterResultsFromLowToHighScore();
        Assert.assertTrue(bookingCssHomePage.compareHotelRate(6.0), "Rate of the hotel is lowwer than 6.0");
    }

    @Test
    public void searchForHotelInLondon() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("London");
        bookingHomePage.scrollToTenthHotel();
        bookingHomePage.changeHotelCardColors();
        MyUtils.makeScreenshot();
    }

    @Test
    public void checkCurrencyButtonTooltip() {
        bookingHomePage.openBookingHomepage();
        Assert.assertTrue(bookingHomePage.checkCurrencyTooltip(), "Tooltip of currency button is not 'Select your currency'");
    }

    @Test
    public void checkLanguagesButtonTooltip() {
        bookingHomePage.openBookingHomepage();
        Assert.assertTrue(bookingHomePage.checkLanguagesTooltip(), "Tooltip of languages button is not 'Select your language'");
    }

    @Test
    public void searchForTopHotelInPrague() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("Прага");
        bookingHomePage.clickOutOfCalendarRegion();
        bookingHomePage.filterResultsFromHighToLowScore();
        bookingHomePage.selectFirstHotelInTheList();
        MyUtils.switchToTheLastBrowserTab();
        Assert.assertTrue(bookingHotelPage.checkScoreOfTheHotel(8.0), "Rate of the hotel is less than 8");
    }

    @Test
    public void searchForTopHotelInPragueCSS() {
        bookingCssHomePage.openBookingHomepage();
        bookingCssHomePage.selectCityViaEnter("Прага");
        bookingCssHomePage.clickOutOfCalendarRegion();
        bookingCssHomePage.filterResultsFromHighToLowScore();
        bookingCssHomePage.selectFirstHotelInTheList();
        MyUtils.switchToTheLastBrowserTab();
        Assert.assertTrue(bookingCssHotelPage.checkScoreOfTheHotel(8.0), "Rate of the hotel is less than 8");
    }
}
