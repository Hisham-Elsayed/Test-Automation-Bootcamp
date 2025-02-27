package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Utility {

    private static String SCREENSHOTS_PATH = "test-outputs/screenshots/";

    /**
     * Utility function for finding, clicking on elements after waiting to be clickable
     * @param driver
     * @param locator
     * @return empty string
     */
    public static void clickElement(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }


    /**
     * Utility function for sending data after waiting
     * @param driver
     * @param locator
     * @param text
     * @return empty string
     */
    public static void sendData(WebDriver driver, By locator, String text)
    {
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //TODO: Selecting from dropdown

    //TODO: Taking screenshots
    public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        File screenSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenDest = new File(SCREENSHOTS_PATH + screenshotName + ".png");
        FileUtils.copyFile(screenSrc,screenDest);
        Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenDest.getPath())));
    }

    //TODO: Converting 'by' to 'webelement'

    //TODO: Scrolling to element

    //TODO: General wait

    //TODO: Uploading files using ROBOT




}
