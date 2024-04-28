package tests.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GooglePage;
import pages.W3SchoolPage;

public class GoogleStepDefs {
    private GooglePage googlePage = new GooglePage();
    private W3SchoolPage w3SchoolPage = new W3SchoolPage();

    @Given("I open W3School java page")
    public void openW3SchoolJavaPage() {
        w3SchoolPage.openW3SchoolJavaPage();
    }

    @When("I copy title value of the page")
    public void copyTitleOfJavaPage() {
        w3SchoolPage.copyTitleOfThePage();
    }

    @And("I open Google page")
    public void openGooglePage() {
        googlePage.openGoogle();
    }

    @And("I paste copied value on Google search field and trigger search")
    public void pasteAndSearchValue() {
        googlePage.insertAndSearchCopyPastedValue();
    }

    @Then("I see that all search results contain word {string}")
    public void checkThatResultsContainSearchValue(String searchValue) {
        Assert.assertTrue("Not all search results contain search value 'tutorial",
                googlePage.checkThatSearchWordPresentInAllSearchResults(searchValue));
    }
}
