package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Assertion {
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 2)
    public void hardAssertValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        boolean expected = driver.getCurrentUrl().equals("https://aa-practice-test-automation.vercel.app/Pages/main.html");
        Assert.assertTrue(expected,"Assert True that expected value is true");  //pass
    }

    @Ignore
    @Test(priority = 1)
    public void softAssertValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        softAssert = new SoftAssert();
        boolean expected = driver.getCurrentUrl().equals("https://aa-practice-test-automation.vercel.app/Pages/main.html");
        softAssert.assertTrue(expected,"Assert True that expected value is true");  //pass
        softAssert.assertEquals(driver.getCurrentUrl(),"www.google.com","Assert Equals that checks if 2 urls are equal"); //fail
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void inValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("amin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https//aa-practice-test-automation.vercel.app/Pages/main.html");
    }



    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
