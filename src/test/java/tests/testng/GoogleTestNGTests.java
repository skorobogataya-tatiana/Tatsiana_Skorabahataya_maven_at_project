package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.W3SchoolPage;
import tests.BaseTestNG;

public class GoogleTestNGTests extends BaseTestNG {
    private GooglePage googlePage = new GooglePage();
    private W3SchoolPage w3SchoolPage = new W3SchoolPage();

    @Test
    public void searchForTitleFromW3InGoogle() {
        w3SchoolPage.openW3SchoolJavaPage();
        w3SchoolPage.copyTitleOfThePage();
        googlePage.openGoogle();
        googlePage.insertAndSearchCopyPastedValue();
        Assert.assertTrue(googlePage.checkThatSearchWordPresentInAllSearchResults("tutorial"),
                "Not all search results contain search value 'tutorial");
    }
}
