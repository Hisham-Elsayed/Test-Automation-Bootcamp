package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Dependencies {
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void registerTC()    //pass
    {
        System.out.println("Register TC");
        Assert.fail();
    }

    @Test(dependsOnMethods = "registerTC")
    public void loginTC()
    {
        System.out.println("Login TC");
    }

    @AfterClass
    public void quit()
    {
        driver.quit();
    }
}
