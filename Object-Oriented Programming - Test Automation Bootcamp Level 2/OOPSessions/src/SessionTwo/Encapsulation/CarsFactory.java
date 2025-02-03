package SessionTwo.Encapsulation;

public class CarsFactory {
    //Attributes
    //int counter;            //non-static (not shared between objects) >> counter++
    static int counter;

    private int speed;
    private String color;
    private String model;
    private boolean isManual;

    //Methods
    //Constructor >> Public - No return - The same name of class
    public CarsFactory()
    {

    }

    public CarsFactory(int speed)
    {
        this.speed = speed;
    }

    //Setter

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public void setSpeed(int speed)
    {
        if(speed < 0)
        {
            System.out.println("Invalid");
        }
        else
        {
            this.speed = speed;
        }
    }

    //Getter

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public boolean isManual() {
        return isManual;
    }

    public int getSpeed()
    {
        return speed;
    }

}
