public class UnitDecisions {
    public static void main(String[] args) {

        MyInitClass myInitClass = new MyInitClass();

        //decision point 1 true, decision point 2 true
        int actual1 = myInitClass.getNumber(-6, 8);
        if (actual1 == 41) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }

        //decision point 1 false, decision point 2 true
        int actual2 = myInitClass.getNumber(6, 29);
        if (actual2 == 88) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }

        //decision point one true, decision point 2 false
        int actual3 = myInitClass.getNumber(-60, 9);
        if (actual3 == -20) {
            System.out.println("Test three passed");
        } else {
            System.out.println("Test three failed");
        }

        //decision point one false, decision point 2 false
        int actual4 = myInitClass.getNumber(-200, 10);
        if (actual4 == -280) {
            System.out.println("Test four passed");
        } else {
            System.out.println("Test four failed");
        }
    }
}
