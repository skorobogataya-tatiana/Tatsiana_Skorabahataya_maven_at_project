package tests.cucumber;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.booking.BookingHomePage;

import java.time.LocalDate;
import java.util.Arrays;

public class BookingStepDefs {
    BookingHomePage bookingHomePage = new BookingHomePage();

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
}
