package SessionThree.HandlingException;

public class Main {
    public static void main(String[] args) {

        int num1 = 60;
        int num2 = 0;
        System.out.println("Ahmed");
        try
        {
            //Code
            System.out.println(num1/num2);  //exception
        }catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Ashraf");
        }

    }
}
