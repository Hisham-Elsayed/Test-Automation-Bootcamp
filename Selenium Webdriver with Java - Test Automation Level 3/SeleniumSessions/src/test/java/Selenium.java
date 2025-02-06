import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {

    public static WebDriver driver = new EdgeDriver();

    public static void main(String[] args) {
        openBrowser("https://the-internet.herokuapp.com/login");
//        openBrowserUsingNavigation("https://www.google.com");
//        back();     //the internet
//        next();     //google
        manageWindow();
        getCurrentUrlOfThePage();
        printTitleOfThePage();
       // getSourceCode();
        getWindowId();
        closeBrowser();
        quitBrowser();
    }

    //Get Method
    public static void openBrowser(String url)
    {
        driver.get(url);
    }

    //Navigation Methods
    public static void openBrowserUsingNavigation(String url)
    {
        driver.navigate().to(url);
    }
    public static void refreshPage()
    {
        driver.navigate().refresh();
    }
    public static void next()
    {
        driver.navigate().forward();
    }
    public static void back()
    {
        driver.navigate().back();
    }

    //Managing Methods
    public static void manageWindow()
    {
        Dimension dimension = new Dimension(430,932);
        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
//        driver.manage().window().minimize();
//        driver.manage().window().setSize(new Dimension(430,932));   //Set Dimension to iPhone 14 pro max
//        driver.manage().window().setPosition(new Point(250,50));
    }

    //Get Current URL
    public static void getCurrentUrlOfThePage()
    {
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    //Get Title
    public static void printTitleOfThePage()
    {
        String title = driver.getTitle();
        System.out.println(title);
    }

    //Get Page Source
    public static void getSourceCode()
    {
        String sourceCode = driver.getPageSource();
        System.out.println(sourceCode);
    }

    //Get Window Handle
    public static void getWindowId()
    {
        String handle1 = driver.getWindowHandle();
        System.out.println(handle1);
        driver.switchTo().newWindow(WindowType.TAB);
        String handle2 = driver.getWindowHandle();
        System.out.println(handle2);
    }

    //Close Current Tab
    public static void closeBrowser()
    {
        driver.close();
    }

    //Quit Browser
    public static void quitBrowser()
    {
        driver.quit();
    }
}
