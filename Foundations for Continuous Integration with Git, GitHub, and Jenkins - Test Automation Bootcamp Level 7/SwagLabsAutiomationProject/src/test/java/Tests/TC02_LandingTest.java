package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestListenerClass;
import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
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
public class TC02_LandingTest {

    private final String USERNAME = DataUtils.getJsonData("validLogin", "username");

    private final String PASSWORD = DataUtils.getJsonData("validLogin", "password");


    public TC02_LandingTest() throws FileNotFoundException {
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
    public void checkingNumberOfSelectedProductsTC() {
        new P01_LoginPage(getDriver())
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnLoginButton()
                .addAllProductsToCart();
        Assert.assertTrue(new P02_LandingPage(getDriver()).comparingNumberOfSelectedProductsWithCart());
    }

    @Test
    public void addingRandomProductsToCartTC() {
        new P01_LoginPage(getDriver())
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnLoginButton()
                .addRandomProducts(3, 6);
        Assert.assertTrue(new P02_LandingPage(getDriver()).comparingNumberOfSelectedProductsWithCart());
    }

    @Test
    public void clickOnCartIcon() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnLoginButton()
                .clickOnCartIcon();
        Assert.assertTrue(Utility.verifyURL(getDriver(), DataUtils.getPropertyValue("environment", "CART_URL")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
