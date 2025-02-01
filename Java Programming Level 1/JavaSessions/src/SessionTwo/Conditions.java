package SessionTwo;

public class Conditions {
    public static void main(String[] args) {
        int num = 13;
        boolean isStudent = true;

        //If condition
        if (num >= 5 && num>10)
        {
            System.out.println("True");
        }
        else {
            System.out.println("Continue");
        }

        if (!isStudent)
        {
            System.out.println("Isn't Student");
        }
        else {
            System.out.println("Is Student");
        }

        //Switch case
        switch (num)
        {
            case 5:
                System.out.println("Number is 5");
                break;
            case 10:
                System.out.println("Number is 10");
                break;
            case 20:
                System.out.println("Number is 20");
                break;
            default:
                System.out.println("Number is not any of these numbers");

        }
    }
}