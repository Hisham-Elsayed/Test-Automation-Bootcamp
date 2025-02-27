import Pages.P01_LoginPage;
import Utilities.DataUtil;
import Utilities.Utility;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC01_LoginTest {

    private WebDriver driver;

    String USERNAME = new Faker().name().username();



    @BeforeMethod
    public void setupDriver() throws IOException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtil.getPropertyValue("enviroments","LOGIN_URL"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Description("This test case verifies that user logged in successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Hisham")
    @Link(name = "Business Document", url = "https://www.google.com")
    @Issue("www.jira.com")
    @TmsLink("www.jira.com/zephyr/TC50")
    @Epic("Web Panel")
    @Feature("Login")
    @Story("Valid Login on Web")
    @Test
    public void validLoginTC() throws IOException {
        enterUsername();
        new P01_LoginPage(driver)
                .enterPassword(DataUtil.getJsonData("validLoginData","password"))
                                .clickOnLoginButton();

        Utility.takeScreenshot(driver,"validLoginTC");

        Assert.assertEquals(driver.getCurrentUrl(),DataUtil.getPropertyValue("enviroments","HOME_URL"));
    }

    @Step("Step 1")
    public void enterUsername() throws FileNotFoundException {
        new P01_LoginPage(driver).enterUsername(DataUtil.getJsonData("validLoginData","username"));
    }

    @Test
    public void invalidLoginTC() throws IOException {
        // Using Java Faker
        System.out.println(USERNAME);
        new P01_LoginPage(driver).enterUsername(USERNAME)
                .enterPassword(DataUtil.getJsonData("validLoginData","password"))
                .clickOnLoginButton();

        //Take Screenshot
        Utility.takeScreenshot(driver,"InvalidLoginTC");

        Assert.assertEquals(driver.getCurrentUrl(),DataUtil.getPropertyValue("enviroments","HOME_URL"));
    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }

}
