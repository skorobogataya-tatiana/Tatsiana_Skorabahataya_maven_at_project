public class UnitsOperators {
    public static void main(String[] args) {
        MyInitClass myInitClass = new MyInitClass();

        // check operator 1 from first condition
        int actual1 = myInitClass.getNumber(-60, 9);
        if (actual1 == -20) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }

        //check operator 2 from first condition
        int actual2 = myInitClass.getNumber(-200, 10);
        if (actual2 == -280) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }

        //check operator from second condition
        int actual3 = myInitClass.getNumber(-6, 8);
        if (actual3 == 41) {
            System.out.println("Test three passed");
        } else {
            System.out.println("Test three failed");
        }
    }
}
