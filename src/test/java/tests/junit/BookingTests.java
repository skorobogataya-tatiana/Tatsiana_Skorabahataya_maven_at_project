package tests.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingHomePage;
import pages.booking.BookingHotelPage;
import utils.MyUtils;

public class BookingTests {
    private BookingHomePage bookingHomePage = new BookingHomePage();
    private BookingHotelPage bookingHotelPage = new BookingHotelPage();
    @Test
    public void searchForHotelInParis() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.selectCityViaEnter("Париж");
        bookingHomePage.selectDates();
        bookingHomePage.selectOccupancy(2, 1);
        bookingHomePage.searchOptions();
        bookingHomePage.filterHotelsOnRate();
        bookingHomePage.filterResultsFromLowToHighScore();
        Assert.assertTrue("Rate of the hotel is lowwer than 6.0", bookingHomePage.compareHotelRate(6.0));
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
        MyUtils.switchToTheLastBrowserTab();
        Assert.assertTrue("Rate of the hotel is less than 8", bookingHotelPage.checkScoreOfTheHotel(8.0));
    }
}
