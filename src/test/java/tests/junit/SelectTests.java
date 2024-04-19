package tests.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.SelectMenuPage;

public class SelectTests {
    private SelectMenuPage selectMenuPage = new SelectMenuPage();

    @Test
    public void selectGreenColor() {
        selectMenuPage.selectGreenColor();
        Assert.assertTrue("Selected color is not green", selectMenuPage.checkThatGreenColorIsSelected());
    }

    @Test
    public void selectAudi() {
        selectMenuPage.selectAudi();
        Assert.assertTrue("Audi is not selected", selectMenuPage.checkThatAudiIsSelected());
    }
}
