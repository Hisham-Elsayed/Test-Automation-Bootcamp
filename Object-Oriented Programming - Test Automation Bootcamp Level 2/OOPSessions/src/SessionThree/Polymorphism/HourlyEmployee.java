package SessionThree.Polymorphism;

public class HourlyEmployee extends Person {

     private double hourlyRate;
     private int hours;

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public void calculateSalary() {
        System.out.println("Net Salary: " + hours *hourlyRate);
    }
}
