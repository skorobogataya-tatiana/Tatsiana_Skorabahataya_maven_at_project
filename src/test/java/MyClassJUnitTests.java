import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyClassJUnitTests {

    @Test
    public void checkFalseTrueBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals("False-True brunch check returned wrong result", 45, myInitClass.getNumber(0, -5));
    }

    @Test
    public void checkFalseFalseBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals("False-False brunch check returned wrong result", -280, myInitClass.getNumber(-200, 10));
    }

    @Test
    public void checkTrueTrueBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals("True-True brunch check returned wrong result", 42, myInitClass.getNumber(-5, -5));
    }

    @Test
    public void checkTrueFalseBranch() {
        MyInitClass myInitClass = new MyInitClass();
        assertEquals("True-False brunch check returned wrong result", -20, myInitClass.getNumber(-60, 9));
    }
}
