package tests.cucumber;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.booking.BookingHomePage;
import pages.booking.BookingHotelPage;

import java.time.LocalDate;

public class BookingStepDefs {
    BookingHomePage bookingHomePage = new BookingHomePage();
    BookingHotelPage bookingHotelPage = new BookingHotelPage();

    @Given("I open booking homepage")
    public void openBookingHomepage() {
        bookingHomePage.openBookingHomepage();
    }

    @When("I input and submit {string} city name in search field")
    public void selectCityViaEnter(String cityName) {
        bookingHomePage.selectCityViaEnter("Париж");
    }

    @And("I select startDate in {int} days and endDate in {int} days")
    public void selectDates(Integer startDay, Integer endDay) {
        int dateOfStart = LocalDate.now().plusDays(startDay).getDayOfMonth();
        int dateOfEnd = LocalDate.now().plusDays(endDay).getDayOfMonth();
        bookingHomePage.selectDates(dateOfStart, dateOfEnd);
    }

    @And("I add {int} more adults and {int} more rooms in occupancy")
    public void selectOccupancy(Integer adultsToAdd, Integer roomsToAdd) {
        bookingHomePage.selectOccupancy(adultsToAdd, roomsToAdd);
    }

    @And("I trigger searching of options")
    public void searchOptions() {
        bookingHomePage.searchOptions();
    }

    @And("I filter the results on rate 6+")
    public void filterHotelsResultsFromRate6() {
        bookingHomePage.filterHotelsOnRate();
    }

    @And("I sort results from lowest rate to highest")
    public void sortHotelsFromLowToHighRate() {
        bookingHomePage.filterResultsFromLowToHighScore();
    }

    @Then("I see that the rate of the first hotel in the list is not lower than {double}")
    public void compareHotelRate(double expectedRate) {
        Assert.assertTrue("Rate of the hotel is lower than 6.0", bookingHomePage.compareHotelRate(expectedRate));
    }

    @And("I scroll to tenth hotel in search results")
    public void scrollToTenthHotelInSearchResults() {
        bookingHomePage.scrollToTenthHotel();
    }

    @And("I change background and font color of the hotel card")
    public void changeBackgroundAndFontColorOfHotelCard() {
        bookingHomePage.changeHotelCardColors();
    }

    @Then("I can make a screenshot of hotel card")
    public void makeScreenshot() {
        Driver.makeScreenshot();
    }

    @And("I click out of calendar component")
    public void clickOutOfCalendar() {
        bookingHomePage.clickOutOfCalendarRegion();
    }

    @And("I sort results from highest to lowest")
    public void sortHotelsFromHighestToLowestRate() {
        bookingHomePage.filterResultsFromHighToLowScore();
    }

    @And("I open first hotel in the search list")
    public void openFirstHotelInSearchList() {
        bookingHomePage.selectFirstHotelInTheList();
        Driver.switchToTheLastBrowserTab();
    }

    @Then("I see that rate of the opened hotel is bigger than {double}")
    public void checkRateOfTheHotel(Double expectedRate) {
        Assert.assertTrue("Rate of the hotel is less than 8", bookingHotelPage.checkScoreOfTheHotel(expectedRate));
    }
}
