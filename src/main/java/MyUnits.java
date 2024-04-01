public class MyUnits {
    public static void main(String[] args) {
        MyInitClass myInitClass = new MyInitClass();

        //operators: operator 2 from condition 1; operator from condition 2
        //decisions: decision point 1 false, decision point 2 true
        //conditions: point 1 - false/true, point 2 - true/true
        //conditions and decisions: condition one false (false + true), condition 2 true (true + true)
        //branches: false -> true
        int actual1 = myInitClass.getNumber(0, -5);
        if (actual1 == 45) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }

        // decisions: decision point 2 false
        //conditions: point one - true/false, point 2 - false/false
        //conditions and decisions: condition one false (true + false), condition 2 false (false + false)
        //branches: false -> false
        int actual2 = myInitClass.getNumber(-200, 10);
        if (actual2 == -280) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }

        //operators: operator 1 from condition 1
        //decisions: decision point 1 true
        //conditions and decisions: condition one true
        //branches: true -> true
        int actual3 = myInitClass.getNumber(-5, -5);
        if (actual3 == 42) {
            System.out.println("Test three passed");
        } else {
            System.out.println("Test three failed");
        }

        //branches: true -> false
        int actual4 = myInitClass.getNumber(-60, 9);
        if (actual4 == -20) {
            System.out.println("Test four passed");
        } else {
            System.out.println("Test four failed");
        }
    }
}
