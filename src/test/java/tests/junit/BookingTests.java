package tests.junit;

import driver.Driver;
import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingCSSHotelPage;
import pages.booking.BookingCssHomePage;
import pages.booking.BookingHomePage;
import pages.booking.BookingHotelPage;
import tests.BaseTest;

import java.time.LocalDate;

public class BookingTests extends BaseTest {
    private BookingHomePage bookingHomePage = new BookingHomePage();
    private BookingCssHomePage bookingCssHomePage = new BookingCssHomePage();
    private BookingHotelPage bookingHotelPage = new BookingHotelPage();
    private BookingCSSHotelPage bookingCssHotelPage = new BookingCSSHotelPage();
    @Test
    public void searchForHotelInParis() {
        int startDay = LocalDate.now().plusDays(2).getDayOfMonth();
        int endDay = LocalDate.now().plusDays(4).getDayOfMonth();
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("Париж");
        bookingHomePage.selectDates(startDay, endDay);
        bookingHomePage.selectOccupancy(2, 1);
        bookingHomePage.searchOptions();
        bookingHomePage.filterHotelsOnRate();
        bookingHomePage.filterResultsFromLowToHighScore();
        Assert.assertTrue("Rate of the hotel is lower than 6.0", bookingHomePage.compareHotelRate(6.0));
    }

    @Test
    public void searchForHotelInParisCSS() {
        int startDay = LocalDate.now().plusDays(2).getDayOfMonth();
        int endDay = LocalDate.now().plusDays(4).getDayOfMonth();
        bookingCssHomePage.openBookingHomepage();
        bookingCssHomePage.selectCityViaEnter("Париж");
        bookingCssHomePage.selectDates(startDay, endDay);
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
       Assert.assertTrue("Tooltip of currency button is not 'Select your currency'", bookingHomePage.checkCurrencyTooltip());
    }

    @Test
    public void checkLanguagesButtonTooltip() {
        bookingHomePage.openBookingHomepage();
        Assert.assertTrue("Tooltip of languages button is not 'Select your language'", bookingHomePage.checkLanguagesTooltip());
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
