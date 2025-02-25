package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Groups {
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(groups = {"regression","broken"})
    public void hardAssertValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        boolean expected = driver.getCurrentUrl().equals("https://aa-practice-test-automation.vercel.app/Pages/main.html");
        Assert.assertTrue(expected,"Assert True that expected value is true");  //pass
    }

    @Test(groups = {"smoke"})
    public void softAssertValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        softAssert = new SoftAssert();
        boolean expected = driver.getCurrentUrl().equals("https://aa-practice-test-automation.vercel.app/Pages/main.html");
        softAssert.assertTrue(expected,"Assert True that expected value is true");  //pass
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","broken"})
    public void inValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("amin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https//aa-practice-test-automation.vercel.app/Pages/main.html");
    }

    @Test(groups = {"regression"})
    public void inValidLoginTestCaseUsingInavlidUsername()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("hisham"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https//aa-practice-test-automation.vercel.app/Pages/main.html");
    }


    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        driver.quit();
    }
}
