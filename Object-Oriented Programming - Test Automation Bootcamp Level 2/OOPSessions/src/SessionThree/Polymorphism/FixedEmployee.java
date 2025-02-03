package SessionThree.Polymorphism;

public class FixedEmployee extends Person implements SampleInterface ,TestInterface {

   private double salary;

    public FixedEmployee() {
    }

    public FixedEmployee(int id, String name) {
        super(id, name);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void calculateSalary()
    {
        System.out.println("Net Salary: " + salary);
    }

    @Override
    public void print() {

    }
}
