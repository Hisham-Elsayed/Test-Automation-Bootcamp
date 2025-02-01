package SessionThree;

import java.text.DecimalFormat;

public class IandD {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        num1++;                             //num1 = 6
        num1+=1;                            //num1 = 7
        num2--;                             //num2 = 9
        System.out.println(num1++);         //num1 = 7 (post increment)
        System.out.println(--num2);         //num2 = 8 (pre increment)

        double x = 5.569;
        System.out.println(new DecimalFormat("#.#").format(x));
        System.out.println(Math.round(x));
        System.out.println(Math.floor(x));
        System.out.println(Math.ceil(x));
    }
}
