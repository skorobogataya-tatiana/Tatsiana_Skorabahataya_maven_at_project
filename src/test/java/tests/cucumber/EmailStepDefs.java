package tests.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.trashmail.TrashMailHomePage;

public class EmailStepDefs {

    private TrashMailHomePage trashMailHomePage = new TrashMailHomePage();

    @Given("I open Trashmail homepage")
    public void openTrashmailHomepage() {
        trashMailHomePage.openTrashMail();
    }

    @When("I indicate {string} as real email")
    public void indicateValidEmail(String email) {
        trashMailHomePage.inputRealEmailValue(email);
    }

    @Then("I can request a fake email creation")
    public void requestFakeEmailCreation() {
        trashMailHomePage.requestToGenerateEmail();
    }
}
