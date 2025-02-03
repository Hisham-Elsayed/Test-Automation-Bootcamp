package SessionOne;

public class Cars {
    //Attributes
    //int counter;            //non-static (not shared between objects) >> counter++
    static int counter;

    public int speed;
    String color;
    String model;
    boolean isManual;


    //Methods
    //Constructor >> Public - No return - The same name of class
    public Cars()               //input / parameter
    {
        //Body
        System.out.println("Empty Object Created");

        counter++;
    }

    public Cars(String model,int speed ,String color,boolean isManual)
    {
        //Body
        this.model = model;
        this.speed = speed;
        this.color = color;
        this.isManual = isManual;

        counter++;
    }

    public Cars(String model,String color)
    {
        //Body
        this.model = model;
        this.color = color;

        counter++;
    }

    public void printInfo()
    {
        System.out.println("Model: " + model + ", " + "Speed: " + speed + ", " + "Color: " + color + ", " + "Manual? " + isManual);
    }

    public static void printNumberOfObjects()
    {
        System.out.println("Number of objects: " + counter);
    }

}
