package SessionThree;

public class Loops {
    public static void main(String[] args) {
        //To print from 0 to 5 (using for loop)
        for (int i = 0; i <= 5; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("\n");
        int j = 10;
        //To print from 10 to 15 (using while loop)
        while (j <= 15) {
            System.out.println("j = " + j);
            j++;
        }

        /*
        To print:

         *
         **
         ***
         ****
         *****

         */
        for (int k = 0; k <= 5; k++) {
            for (int m = 1; m <= k; m++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        //To print from 6 to 10 (using do while loop)
        int num = 6;
        do {
            System.out.println(num);
            num++;
        }
        while (num <= 10);
    }
}
