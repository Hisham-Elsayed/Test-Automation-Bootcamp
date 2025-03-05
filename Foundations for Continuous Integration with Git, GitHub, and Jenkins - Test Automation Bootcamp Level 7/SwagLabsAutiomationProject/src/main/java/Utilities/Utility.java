package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utility {

    private static String SCREENSHOTS_PATH = "test-outputs/Screenshots/";

    /**
     * Utility function for finding, clicking on elements after waiting to be clickable
     *
     * @param driver
     * @param locator
     * @return empty string
     */
    public static void clickElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }


    /**
     * Utility function for sending data after waiting
     *
     * @param driver
     * @param locator
     * @param text
     * @return empty string
     */
    public static void sendData(WebDriver driver, By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }

    //TODO: Taking screenshots
    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            File screenSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "-" + getTimeStamp() + ".png");
            FileUtils.copyFile(screenSrc, screenshotFile);
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }

    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        generalWait(driver).until(ExpectedConditions.alertIsPresent());
        return driver.findElement(locator).getText();
    }

    //TODO: Selecting from dropdown
    public static void selectingFromDropDown(WebDriver driver, By locator, String option) {
        new Select(findWebElement(driver, locator)).selectByVisibleText(option);
    }

    //TODO: Converting 'by' to 'webelement'
    public static WebElement findWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }


    //TODO: Scrolling to element
    public static void scrolling(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView();", findWebElement(driver, locator));
    }

    //TODO: General wait
    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static int generateRandomNumber(int upperBound) {
        return new Random().nextInt(upperBound) + 1;
    }

    public static Set<Integer> generateUniqueNumber(int numberOfProductsNeeded, int totalNumberOfProducts) {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < numberOfProductsNeeded) {
            int randomNumber = generateRandomNumber(totalNumberOfProducts);
            generatedNumbers.add(randomNumber);
        }
        return generatedNumbers;
    }

    public static boolean verifyURL(WebDriver driver, String expectedURL) {
        try {
            generalWait(driver).until(ExpectedConditions.urlToBe(expectedURL));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //TODO: Uploading files using ROBOT


}
