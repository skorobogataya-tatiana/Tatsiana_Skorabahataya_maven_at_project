import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MyClassTestNGTests {

    @Test
    public void checkFalseTrueBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals(myInitClass.getNumber(0, -5), 45, "False-True brunch check returned wrong result");
    }

    @Test
    public void checkFalseFalseBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals(myInitClass.getNumber(-200, 10), -280, "False-False brunch check returned wrong result");
    }

    @Test
    public void checkTrueTrueBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals(myInitClass.getNumber(-5, -5), 42, "True-True brunch check returned wrong result");
    }

    @Test
    public void checkTrueFalseBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals(myInitClass.getNumber(-60, 9), -20, "True-False brunch check returned wrong result");
    }
}
