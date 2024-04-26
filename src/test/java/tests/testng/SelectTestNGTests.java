package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SelectMenuPage;
import tests.BaseTestNG;

public class SelectTestNGTests extends BaseTestNG {
    private SelectMenuPage selectMenuPage = new SelectMenuPage();

    @Test
    public void selectGreenColor() {
        selectMenuPage.selectGreenColor();
        Assert.assertTrue(selectMenuPage.checkThatGreenColorIsSelected(), "Selected color is not green");
    }

    @Test
    public void selectAudi() {
        selectMenuPage.selectAudi();
        Assert.assertTrue(selectMenuPage.checkThatAudiIsSelected(), "Audi is not selected");
    }
}
