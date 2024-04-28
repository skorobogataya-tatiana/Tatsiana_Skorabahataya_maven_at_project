package tests.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SelectMenuPage;

public class SelectStepDefs {
    private SelectMenuPage selectMenuPage = new SelectMenuPage();

    @Given("I open Select Menu page")
    public void openSelectMenuPage() {
        selectMenuPage.openSelectMenuPage();
    }

    @When("I select Green color {string} from select dropdown")
    public void selectGreenColor(String colorNumber) {
        selectMenuPage.selectColor(colorNumber);
    }

    @Then("I see that {string} color is selected")
    public void checkThatColorIsSelected(String color) {
        selectMenuPage.checkThatColorIsSelected(color);
    }

    @When("I select {string} car from select list")
    public void selectCarFromTheList(String car) {
        selectMenuPage.selectCar(car);
    }

    @Then("I see that {string} car is selected")
    public void checkThatCarIsSelected(String car) {
        selectMenuPage.checkThatCarIsSelected(car);
    }
}
