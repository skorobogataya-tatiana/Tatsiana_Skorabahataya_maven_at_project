package tests.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingHomePage;
import pages.booking.BookingHomePageLoggedIn;
import pages.booking.BookingSignInPage;

public class BookingLoggedInTests {
    BookingHomePage bookingHomePage = new BookingHomePage();
    BookingSignInPage bookingSignInPage = new BookingSignInPage();
    BookingHomePageLoggedIn bookingHomePageLoggedIn = new BookingHomePageLoggedIn();

    @Test
    public void addFavouriteHotelsInMadrid() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.signIn();
        bookingSignInPage.enterEmailToLogin("skorobogataya.tatiana@gmail.com");
        bookingSignInPage.enterPassword("$Korona2018");
        bookingSignInPage.submitLogin();
        bookingSignInPage.switchToHumanConfirmationFrame();
        //bookingSignInPage.pressAndHoldHumanConfirmationButton();
        //bookingSignInPage.closeGeniusPopup();
        bookingHomePage.switchToDefaultFrame();
        bookingHomePage.selectCityViaEnter("Madrid");
        bookingHomePage.selectDates(30, 35);
        bookingHomePage.searchOptions();
        bookingHomePage.likeFirstAndLastHotelInTheList();
        bookingHomePage.returnColorValue();
    }

    @Test
    public void checkHeaderElementsForLoggedInUser() throws InterruptedException {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.signIn();
        bookingSignInPage.enterEmailToLogin("skorobogataya.tatiana@gmail.com");
        bookingSignInPage.enterPassword("$Korona2018");
        bookingSignInPage.submitLogin();
        bookingHomePage.switchToDefaultFrame();
        Thread.sleep(3000);
        Assert.assertTrue("Not all items of the header exist", bookingHomePageLoggedIn.checkHeaderElements());
    }
}
