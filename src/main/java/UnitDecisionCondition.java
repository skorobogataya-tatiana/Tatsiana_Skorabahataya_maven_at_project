public class UnitDecisionCondition {
    public static void main(String[] args) {
        MyInitClass myInitClass = new MyInitClass();

        //condition one false (false + true), condition 2 true (true + true)
        int actual1 = myInitClass.getNumber(0, -5);
        if (actual1 == 45) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }

        //condition one false (true + false), condition 2 false (false + false)
        int actual2 = myInitClass.getNumber(-200, 10);
        if (actual2 == -280) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }

        //condition one true
        int actual3 = myInitClass.getNumber(-5, -5);
        if (actual3 == 42) {
            System.out.println("Test three passed");
        } else {
            System.out.println("Test three failed");
        }
    }
}
