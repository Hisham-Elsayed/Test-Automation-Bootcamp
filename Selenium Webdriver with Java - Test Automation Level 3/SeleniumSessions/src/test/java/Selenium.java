import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Selenium {

    public static WebDriver driver = new EdgeDriver();

    public static String firstTab;
    public static String secondTab;

    public static void main(String[] args) throws IOException, URISyntaxException {
        /** Take action on elements **/
//        openBrowser("https://the-internet.herokuapp.com/login");
//        manageWindow();     //maximize
//        enterText("tomsmith","SuperSecretPassword!");
//        clearText();
//        clicking();
//        getTextFromField();

        /** Synchronization & Waiting Strategies **/
//        openBrowser("https://the-internet.herokuapp.com/dynamic_loading/2");
//        manageWindow();     //maximize
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));      //general
//        getHelloWorld();

        /** Handling Drop Downs **/
//          openBrowser("https://the-internet.herokuapp.com/dropdown");
//          manageWindow();     //maximize
//          handlingDropdown();

        /** Handling Checkboxes and Radio Button **/
//        openBrowser("https://the-internet.herokuapp.com/checkboxes");
//        manageWindow();     //maximize
//        handlingCheckboxes();
//
//        openBrowser("https://demo.guru99.com/test/radio.html");
//        manageWindow();     //maximize
//        handlingRadioButton();

         /** Information about Web Elements **/
//         openBrowser("file:///F:/index.html");
//         manageWindow();
//         checkboxIsSelected();
//         checkElementIsDisplayed();
//         checkElementIsEnabled();

         /** Actions **/
//        openBrowser("https://the-internet.herokuapp.com/context_menu");
//        openBrowser("https://the-internet.herokuapp.com/drag_and_drop");
//        openBrowser("https://the-internet.herokuapp.com/hovers");
//        manageWindow();
//        doubleClick();
//        rightClick();
//        dragAndDrop();
//        clickAndHold();
//        hover();

        /** Handling Windows **/
//        openBrowser("https://the-internet.herokuapp.com/windows");
//        manageWindow();
//        openNewTab();
//        Set<String> handles = openNewTab();
//
//        for(String h : handles)
//        {
//            if (!h.equals(firstTab))
//            {
//                secondTab = h;
//            }
//        }
//        System.out.println(firstTab);
//        System.out.println(secondTab);
//        System.out.println(driver.getCurrentUrl());
//        switchingTab(secondTab);
//        System.out.println(driver.getCurrentUrl());

        /** Frames **/
//        openBrowser("https://the-internet.herokuapp.com/nested_frames");
//        manageWindow();
//        //iFrame();
//        nestedFrame();

        /** Alerts **/
//        openBrowser("https://the-internet.herokuapp.com/javascript_alerts");
//        manageWindow();
//        acceptAlert();
//        dismissAlert();
//        prompt();

        /** Using Keys **/
//        openBrowser("https://the-internet.herokuapp.com/key_presses");
//        manageWindow();
//        keyUsingSendKeys();
//        keysUsingActions();

        /** Scrolling **/
//        openBrowser("file:///F:/index.html");
//        manageWindow();
//        scrollingUsingActions();

        /** Taking Screenshots **/
//        openBrowser("https://the-internet.herokuapp.com/login");
//        manageWindow();
//
//        try {
//            takingScreenshot("UsernameField");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        /** Upload Files **/
//        openBrowser("https://the-internet.herokuapp.com/upload");
//        manageWindow();
//        uploadUsingSendKeys("C:\\Hisham\\The New Tester Program\\Test Automation Bootcamp\\Selenium Webdriver with Java - Test Automation Level 3\\SeleniumSessions\\src\\main\\resources\\screenshot1.png");

        /** Browser Options **/
//        initializeDriver();
//        openBrowser("https://the-internet.herokuapp.com/upload");
//        manageWindow();
//        System.out.println(driver.getCurrentUrl());

        /** Checking Broken links and images **/
//        openBrowser("https://the-internet.herokuapp.com/");
        openBrowser("https://the-internet.herokuapp.com/broken_images");
        manageWindow();
//        List<WebElement> elements = driver.findElements(By.tagName("a"));
        List<WebElement> elements = driver.findElements(By.tagName("img"));
//        checkBroken(elements,"links");
//        checkBroken(elements,"photo");
        checkBrokenUsingRestAssured(elements,"photo");

    }

    public static void checkBrokenUsingRestAssured(List<WebElement> elements,String type) throws IOException, URISyntaxException {
        URL url;
        String attribute;

        if(type.equals("photo"))
            attribute = "src";
        else
            attribute = "href";

        for(WebElement element:elements)
        {
            url = new URI(element.getAttribute(attribute)).toURL();
            Response response = RestAssured.given().get(url);
            System.out.println(response.getStatusLine());
        }
    }

    public static void checkBroken(List<WebElement> elements,String type) throws IOException, URISyntaxException {
        URL url;
        String attribute;

        if(type.equals("photo"))
            attribute = "src";
        else
            attribute = "href";

        for(WebElement element:elements)
        {
            url = new URI(element.getAttribute(attribute)).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println(httpURLConnection.getResponseMessage() + " " + httpURLConnection.getResponseCode());
        }
    }

    public static void initializeDriver()
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");                    //Guest Mode
//        edgeOptions.addArguments("--headless");               //No UI
        edgeOptions.addArguments("--start-maximized");          //Start Browser Maximized
        driver = new EdgeDriver(edgeOptions);
    }

    public static void uploadUsingRobot(String path) throws AWTException {
        driver.findElement(By.id("chooseFileBtn")).click();
        StringSelection stringSelection = new StringSelection(path);        //CTRL + C
        Toolkit.getDefaultToolkit().getSystemSelection().setContents(stringSelection,null);
        Robot robot = new Robot();

        robot.delay(2000);

        // ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        // CTRL + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(2000);

        // ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void uploadUsingSendKeys(String path)
    {
        driver.findElement(By.id("file-upload")).sendKeys(path);
    }

    public static void takingScreenshot(String imageName) throws IOException {
        String path = "C:\\Hisham\\The New Tester Program\\Test Automation Bootcamp\\Selenium Webdriver with Java - Test Automation Level 3\\SeleniumSessions\\src\\main\\resources\\";
        File src = (byToWebElement(By.id("username"))).getScreenshotAs(OutputType.FILE);
        File target = new File(path + imageName +".png");
        FileUtils.copyFile(src,target);
    }

    public static void scrollingUsingActions()
    {
        new Actions(driver).scrollToElement(byToWebElement(By.id("scroll_text")))
                .perform();
        driver.findElement(By.id("scroll_text")).sendKeys("test");
    }

    public static void keysUsingActions()
    {
        By textField = By.id("target");
        //SHIFT + "hisham" -> HISHAM
        new Actions(driver).keyDown(byToWebElement(textField),Keys.SHIFT)
                .sendKeys(byToWebElement(textField),"hisham")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
    }

    public static void keyUsingSendKeys()
    {
        driver.findElement(By.id("target")).sendKeys(Keys.ARROW_DOWN);
    }

    public static void acceptAlert()
    {
        driver.findElement(By.cssSelector("[onclick = 'jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public static void dismissAlert()
    {
        driver.findElement(By.cssSelector("[onclick = 'jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
    }

    public static void prompt()
    {
        driver.findElement(By.cssSelector("[onclick = 'jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hisham");
        alert.accept();
    }

    public static void nestedFrame()
    {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();    //Top
        driver.switchTo().parentFrame();    //Window
        //OR
//        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),\"B\")]")).getText());
    }

    public static void iFrame()
    {
        By textArea = By.cssSelector("body#tinymce p");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(textArea).clear();
        driver.findElement(textArea).sendKeys(" Hisham");
        driver.switchTo().parentFrame();
    }

    public static void switchingTab(String handle)
    {
        driver.switchTo().window(handle);
    }

    public static Set<String> openNewTab()
    {
        By mewTabButton = By.cssSelector("a[href='/windows/new']");
        driver.findElement(mewTabButton).click();
        firstTab = driver.getWindowHandle();
        return driver.getWindowHandles();        //2
    }

    public static void hover()
    {
        By picture = By.xpath("(//img)[2]");
        new Actions(driver).moveToElement(byToWebElement(picture)).perform();
    }

    public static void clickAndHold()
    {
        By boxA = By.id("column-a");
        By boxB = By.id("column-b");

        /*
        1-Click and Hold
        2-Move to Element
        3-Releasing
         */
        new Actions(driver).clickAndHold(byToWebElement(boxB))
                .moveToElement(byToWebElement(boxA))
                .release()
                .build()
                .perform();
    }

    public static void dragAndDrop()
    {
        By boxA = By.id("column-a");
        By boxB = By.id("column-b");

        new Actions(driver).dragAndDrop(byToWebElement(boxA),byToWebElement(boxB)).perform();
    }

    public  static void rightClick()
    {
     By box = By.id("hot-spot");
     new Actions(driver).contextClick(byToWebElement(box)).perform();
    }

    public static void doubleClick()
    {
        By checkBoxButton = By.xpath("//button[text()='Show Checkboxes']");
        By ahlycheckBox = By.id("Ahly");
        driver.findElement(checkBoxButton).click();
        new Actions(driver).doubleClick(byToWebElement(ahlycheckBox)).perform();
    }
    public static void checkElementIsEnabled()
    {
        By email = By.id("inputEmail");
        System.out.println("Email field is enabled: " + driver.findElement(email).isEnabled());
    }
    public static void checkElementIsDisplayed()
    {
        By email = By.id("inputEmail");
        System.out.println("Email field is displayed: " + driver.findElement(email).isDisplayed());
    }

    public static void checkboxIsSelected()
    {
        By ahlyCheckbox = By.id("Ahly");
        By zamalekCheckbox = By.id("Zamalek");
        System.out.println("First checkbox is selected: " + driver.findElement(ahlyCheckbox).isSelected());     //true/false
        System.out.println("Second checkbox is selected: " + driver.findElement(zamalekCheckbox).isSelected()); //true/false
    }

    public static void handlingRadioButton()
    {
        By radio = By.id("vfb-7-1");
        driver.findElement(radio).click();
    }

    public static void handlingCheckboxes()
    {
        By checkbox = By.cssSelector("input[type = 'checkbox']:nth-of-type(1)");
        driver.findElement(checkbox).click();
    }

    public static void handlingDropdown()
    {
        By dropDown = By.cssSelector("select#dropdown");
        new Select(byToWebElement(dropDown)).selectByIndex(2);
    }

    public static void fluentWait(By locator)
    {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .withMessage(locator.toString() + "doesn't meet the criteria")
                .pollingEvery(Duration.ofMillis(1L))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void explicitWait(By locator)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(byToWebElement(locator)));
    }
    public static void getHelloWorld()
    {
        By startButton = By.tagName("button");
        By helloWorldMsg = By.xpath("//div [@id = 'finish'] //h4");
        driver.findElement(startButton).click();
        //explicitWait(helloWorldMsg);
        fluentWait(helloWorldMsg);
        String msg = driver.findElement(helloWorldMsg).getText();
        System.out.println(msg);
    }
    //Clear text
    public static void clearText()
    {
        By usernameLocator = By.id("username");
        driver.findElement(usernameLocator).clear();
    }

    //Get text
    public static String getTextFromField()
    {
        By flashMessage = By.cssSelector("div#flash");
        return driver.findElement(flashMessage).getText();
        //System.out.println(msg);
    }

    //Click
    public static void clicking()
    {
        By loginButton = By.className("radius");
        driver.findElement(loginButton).click();
    }

    //Send Keys
    public static void enterText(String username, String password)  //dynamic
    {
        By usernameLocator = By.id("username");
        By passwordlocator = By.id("password");
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordlocator).sendKeys(password);


    }

    public static WebElement byToWebElement(By locator)
    {
        return driver.findElement(locator);
    }

    //Get Method
    public static void openBrowser(String url)
    {
        driver.get(url);
    }

    //Navigation Methods
    public static void openBrowserUsingNavigation(String url)
    {
        driver.navigate().to(url);
    }
    public static void refreshPage()
    {
        driver.navigate().refresh();
    }
    public static void next()
    {
        driver.navigate().forward();
    }
    public static void back()
    {
        driver.navigate().back();
    }

    //Managing Methods
    public static void manageWindow()
    {
//        Dimension dimension = new Dimension(430,932);
          driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
//        driver.manage().window().minimize();
//        driver.manage().window().setSize(new Dimension(430,932));   //Set Dimension to iPhone 14 pro max
//        driver.manage().window().setPosition(new Point(250,50));
    }

    //Get Current URL
    public static void getCurrentUrlOfThePage()
    {
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    //Get Title
    public static void printTitleOfThePage()
    {
        String title = driver.getTitle();
        System.out.println(title);
    }

    //Get Page Source
    public static void getSourceCode()
    {
        String sourceCode = driver.getPageSource();
        System.out.println(sourceCode);
    }

    //Get Window Handle
    public static void getWindowId()
    {
        String handle1 = driver.getWindowHandle();
        System.out.println(handle1);
        driver.switchTo().newWindow(WindowType.TAB);
        String handle2 = driver.getWindowHandle();
        System.out.println(handle2);
    }

    //Close Current Tab
    public static void closeBrowser()
    {
        driver.close();
    }

    //Quit Browser
    public static void quitBrowser()
    {
        driver.quit();
    }
}
