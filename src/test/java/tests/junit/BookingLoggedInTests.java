package tests.junit;

import org.junit.Test;
import pages.booking.BookingHomePage;
import pages.booking.BookingSignInPage;

public class BookingLoggedInTests {
    BookingHomePage bookingHomePage = new BookingHomePage();
    BookingSignInPage bookingSignInPage = new BookingSignInPage();

    @Test
    public void addFavouriteHotelsInMadrid() {
        bookingHomePage.openBookingHomepage();
        bookingHomePage.SignIn();
        bookingSignInPage.enterEmailToLogin("skorobogataya.tatiana@gmail.com");
        bookingSignInPage.enterPassword("$Korona2018");
        bookingSignInPage.submitLogin();
        bookingSignInPage.switchToHumanConfirmationFrame();
        bookingSignInPage.pressAndHoldHumanConfirmationButton();
    }
}
