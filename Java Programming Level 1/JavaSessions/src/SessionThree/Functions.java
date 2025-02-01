package SessionThree;

public class Functions {
    public static void main(String[] args) {
        int num1 = 10,num2 = 5;

        int res = add(num1,num2);
        System.out.println(res);

        //calling
        Sum(20,30);

    }

    //declaration
    public static int add(int x,int y)
    {
        return x+y;
    }

    public static void Sum(int x ,int y)
    {
        System.out.println(x+y);
    }

}
