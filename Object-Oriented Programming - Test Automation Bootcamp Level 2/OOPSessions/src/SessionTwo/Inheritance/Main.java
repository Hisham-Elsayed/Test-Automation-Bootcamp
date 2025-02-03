package SessionTwo.Inheritance;

public class Main {
    public static void main(String[] args) {
        FixedEmployee ahmed = new FixedEmployee(1,"Ahmed");
        ahmed.printEmployeeInfo();

        HourlyEmployee mohamed = new HourlyEmployee();
        mohamed.id = 2;
        mohamed.name = "Mohamed";
        mohamed.printEmployeeInfo();
    }

}
