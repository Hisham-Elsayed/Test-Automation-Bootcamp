package SessionTwo.Inheritance;

public class Person {

     protected int id;
     protected String name;

    public Person() {
        System.out.println("Default Parent Class");
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printEmployeeInfo()
    {
        System.out.println(id + " " + name);
    }
}
