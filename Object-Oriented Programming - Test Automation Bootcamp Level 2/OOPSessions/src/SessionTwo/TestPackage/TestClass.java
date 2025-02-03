package SessionTwo.TestPackage;

import SessionOne.Cars;
import SessionTwo.Inheritance.Person;

public class TestClass extends Person {
    public static void main(String[] args) {
       Cars car = new Cars();
       car.speed = 200;

       Cars car1 = new Cars("Toyota","Silver");
       car1.printInfo();

    }

    public void print()
    {
        System.out.println(name + id);
    }
}
