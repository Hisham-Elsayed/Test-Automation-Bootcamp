package SessionThree;

public class NestedIf {
    public static void main(String[] args) {
        String name = "ahmed";
        int grade = 100;

//        if(name.equalsIgnoreCase("Ahmed") && grade == 100)
//        {
//            System.out.println("Fail");
//        }
        if(name.equalsIgnoreCase("Ahmed"))
        {
            if(grade > 100)
            {
                System.out.println("Passed");
            }
        }
    }
}
