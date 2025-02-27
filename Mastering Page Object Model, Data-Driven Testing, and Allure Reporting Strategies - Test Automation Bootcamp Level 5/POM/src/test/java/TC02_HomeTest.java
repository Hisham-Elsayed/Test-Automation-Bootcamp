import Pages.P01_LoginPage;
import Utilities.DataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC02_HomeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setupDriver() throws IOException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtil.getPropertyValue("enviroments","LOGIN_URL"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void logoutTC() throws IOException {
        new P01_LoginPage(driver).enterUsername(DataUtil.getJsonData("validLoginData","username"))
            .enterPassword(DataUtil.getJsonData("validLoginData","password"))
            .clickOnLoginButton()
                        .clickOnLogoutButton();
        Assert.assertNotEquals(driver.getCurrentUrl(),DataUtil.getPropertyValue("enviroments","HOME_URL"));
    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }

}
