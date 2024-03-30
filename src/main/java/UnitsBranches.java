public class UnitsBranches {
    public static void main(String[] args) {
        MyInitClass myInitClass = new MyInitClass();

        //check branch true -> true
        int actual1 = myInitClass.getNumber(-6, 8);
        if (actual1 == 41) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }

        // check branch true -> false
        int actual2 = myInitClass.getNumber(-60, 9);
        if (actual2 == -20) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }

        // check branch false -> true
        int actual3 = myInitClass.getNumber(0, -5);
        if (actual3 == 45) {
            System.out.println("Test three passed");
        } else {
            System.out.println("Test three failed");
        }

        // check branch false -> false
        int actual4 = myInitClass.getNumber(-200, 10);
        if (actual4 == -280) {
            System.out.println("Test four passed");
        } else {
            System.out.println("Test four failed");
        }
    }
}
