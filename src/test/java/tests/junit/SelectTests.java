package tests.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.SelectMenuPage;
import tests.BaseTest;

public class SelectTests extends BaseTest {
    private SelectMenuPage selectMenuPage = new SelectMenuPage();

    @Test
    public void selectGreenColor() {
        selectMenuPage.openSelectMenuPage();
        selectMenuPage.selectGreenColor();
        Assert.assertTrue("Selected color is not green", selectMenuPage.checkThatGreenColorIsSelected());
    }

    @Test
    public void selectAudi() {
        selectMenuPage.openSelectMenuPage();
        selectMenuPage.selectAudi();
        Assert.assertTrue("Audi is not selected", selectMenuPage.checkThatAudiIsSelected());
    }
}
