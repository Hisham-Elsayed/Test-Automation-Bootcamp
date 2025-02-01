package SessionTwo;


public class Variables {
    public static void main(String[] args) {
        double numberOfTc = 100.5;
        boolean presentFlag = false;
        char firstChar = 'A';
        String name = "Hisham";
        System.out.printf("x = %.2f\n",numberOfTc);         //format method
        System.out.println(presentFlag);
        System.out.println(firstChar);
        System.out.println(name);

        System.out.println(name + " plays football");       //Concatenation method

        double number = 50.6;

        System.out.println("Number after casting -> "+ (int)number);

    }
}
