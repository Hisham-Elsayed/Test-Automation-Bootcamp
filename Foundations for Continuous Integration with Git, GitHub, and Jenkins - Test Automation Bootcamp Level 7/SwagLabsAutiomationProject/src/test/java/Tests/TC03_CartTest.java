package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestListenerClass;
import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Pages.P03_CartPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;


@Listeners({IInvokedMethodListenerClass.class, ITestListenerClass.class})
public class TC03_CartTest {
    private final String USERNAME = DataUtils.getJsonData("validLogin", "username");

    private final String PASSWORD = DataUtils.getJsonData("validLogin", "password");


    public TC03_CartTest() throws FileNotFoundException {
    }


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "BROWSER"));
        LogsUtils.info("Edge driver is opened");
        getDriver().get(getPropertyValue("environment", "LOGIN_URL"));
        LogsUtils.info("Page is redirected to the URL");
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void comparingPricesTC() {
        String totalPrice = new P01_LoginPage(getDriver())
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnLoginButton()
                .addRandomProducts(2, 6)
                .getTotalPriceOfSelectedProducts();
        new P02_LandingPage(getDriver()).clickOnCartIcon();
        Assert.assertTrue(new P03_CartPage(getDriver()).comparingPrices(totalPrice));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
