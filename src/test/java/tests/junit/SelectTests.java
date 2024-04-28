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
        selectMenuPage.selectColor("2");
        Assert.assertTrue("Selected color is not green", selectMenuPage.checkThatColorIsSelected("Green"));
    }

    @Test
    public void selectAudi() {
        selectMenuPage.openSelectMenuPage();
        selectMenuPage.selectCar("audi");
        Assert.assertTrue("Audi is not selected", selectMenuPage.checkThatCarIsSelected("Audi"));
    }
}
