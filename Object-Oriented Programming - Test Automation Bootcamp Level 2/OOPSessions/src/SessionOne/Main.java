package SessionOne;

public class Main {
    public static void main(String[] args) {
        Cars car1 = new Cars("BMW",100,"Black",false);
        System.out.println(car1);
//        car1.model = "BMW";
//        car1.speed = 100;
//        car1.color = "Black";
//        car1.isManual = false;
        car1.printInfo();

        Cars car2 = new Cars();
        System.out.println(car2);
        car2.model = "128";
        car2.speed = 40;
        car2.color = "White";
        car2.isManual = true;
        car2.printInfo();

        //Initial values: int >> 0       float >> 0.0       String/Char >> null
        Cars car3 = new Cars();
        car3.printInfo();

        Cars car4 = new Cars("Honda","Red");
        car4.printInfo();

        Cars.printNumberOfObjects();
    }
}
