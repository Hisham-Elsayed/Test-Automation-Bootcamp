import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Selenium {

    public static WebDriver driver = new EdgeDriver();

    public static void main(String[] args) {
       // openBrowser("https://the-internet.herokuapp.com/login");
        openBrowser("https://the-internet.herokuapp.com/tables");
        By element = By.xpath("//table[@id='table2'] /tbody /tr");
        List<WebElement> elements = driver.findElements(element);
        for(WebElement element1 :elements)
            System.out.println(element1.getText());

//        openBrowserUsingNavigation("https://www.google.com");
//        back();     //the internet
//        next();     //google
        manageWindow();

//        By usernameInput = By.id("username");
//        driver.findElement(usernameInput).click();
//        driver.findElement(usernameInput).sendKeys("");
//        driver.findElement(usernameInput).clear();
//        byToWebElement(usernameInput);



        //Using cssSelector
//        By usernameInput = By.cssSelector("#username");

        //Using XPath
       // By usernameInput = By.xpath("");

        //By Link Text
       // By usernameInput = By.linkText("Elemental Selenium");
    }

    public static WebElement byToWebElement(By locator)
    {
        return driver.findElement(locator);
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
//        Dimension dimension = new Dimension(430,932);
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
