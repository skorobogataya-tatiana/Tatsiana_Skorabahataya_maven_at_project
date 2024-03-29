public class UnitConditions {
    public static void main(String[] args) {
        MyInitClass myInitClass = new MyInitClass();

        //condition 1: (false + true), condition 2: (true + false)
        int actual1 = myInitClass.getNumber(10, -200);
        if (actual1 == -135) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }

        //condition 1: (true + false), condition 2: (false + true)
        int actual2 = myInitClass.getNumber(-10, 10);
        if (actual2 == 45) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }
    }
}
