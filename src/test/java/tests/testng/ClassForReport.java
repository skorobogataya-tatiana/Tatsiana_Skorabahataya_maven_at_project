package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class ClassForReport {

    @Test(description = "157870")
    public void taniaTestOne() {
        Assert.assertTrue(1 > 0);
    }

    @Test(description = "157871")
    public void taniaTestTwo() {
        Assert.assertTrue(2 > 0);
    }

    @Test(description = "157872")
    public void taniaTestThree() {
        Assert.assertTrue(3 > 0);
    }

    @Test(description = "157874")
    public void taniaTestFour() {
        Assert.assertTrue(2 > 6);
    }
}
