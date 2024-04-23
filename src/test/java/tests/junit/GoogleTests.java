package tests.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.GooglePage;
import pages.W3SchoolPage;
import tests.BaseTest;

public class GoogleTests extends BaseTest {
    private GooglePage googlePage = new GooglePage();
    private W3SchoolPage w3SchoolPage = new W3SchoolPage();

    @Test
    public void searchForTitleFromW3InGoogle() {
        w3SchoolPage.openW3SchoolJavaPage();
        w3SchoolPage.copyPasteTitleOfThePage();
        googlePage.openGoogle();
        googlePage.insertAndSearchCopyPastedValue();
        Assert.assertTrue("Not all search results contain search value 'tutorial",
                googlePage.checkThatSearchWordPresentInAllSearchResults("tutorial"));
    }
}
