package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SelectMenuPage;
import tests.BaseTestNG;

public class SelectTestNGTests extends BaseTestNG {
    private SelectMenuPage selectMenuPage = new SelectMenuPage();

    @Test
    public void selectGreenColor() {
        selectMenuPage.selectColor("2");
        Assert.assertTrue(selectMenuPage.checkThatColorIsSelected("Green"), "Selected color is not green");
    }

    @Test
    public void selectAudi() {
        selectMenuPage.selectCar("audi");
        Assert.assertTrue(selectMenuPage.checkThatCarIsSelected("Audi"), "Audi is not selected");
    }
}
