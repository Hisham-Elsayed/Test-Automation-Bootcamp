package SessionOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import Listeners.IInvokedMethod;

import java.time.Duration;


public class ParameterClass {
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private SoftAssert softAssert;


    @Parameters(value = "browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("edge") String browser)
    {
        switch (browser)
        {
//            case "edge":
//                driver = new EdgeDriver();
//                break;
            case "chrome":
                driverThreadLocal.set(new ChromeDriver());
                break;
            default:
                driverThreadLocal.set(new EdgeDriver());
                break;
        }

        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://aa-practice-test-automation.vercel.app/index.html");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Parameters(value = {"username","password"})
    @Test()
    public void validLoginTestCase(@Optional("admin") String username,@Optional("admin") String password)
    {
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username); //username
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password); //password
        driverThreadLocal.get().findElement(By.id("loginButton")).click(); //login
        boolean expected = driverThreadLocal.get().getCurrentUrl().equals("https://aa-practice-test-automation.vercel.app/Pages/main.html");
        Assert.assertTrue(expected,"Assert True that expected value is true");  //pass
    }

    @Parameters(value = {"username","password"})
    @Test()
    public void validLoginTestCase2(@Optional("admin") String username,@Optional("admin") String password)
    {
        LogUtility.logger.info("Test case Started");
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username); //username
        LogUtility.logger.info("username:admin is written");
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password); //password
        LogUtility.logger.info("password:admin is written");
        driverThreadLocal.get().findElement(By.id("loginButton")).click(); //login
        LogUtility.logger.info("login button is clicked");
        boolean expected = driverThreadLocal.get().getCurrentUrl().equals("https://aa-practice-test-automation.vercel.app/Pages/main.html");
        LogUtility.logger.warn("value: " + expected);
        Assert.assertTrue(expected,"Assert True that expected value is true");  //pass
    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
