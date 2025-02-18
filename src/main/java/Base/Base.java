package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver driver;
    public static Properties prop;
    public JavascriptExecutor js;
    public static WebDriverWait wait;

    // To call different browsers
    public void invokeBrowser() {
        prop = new Properties();

        try {
            prop.load(new FileInputStream("src/main/java/Config/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // To Open Chrome Browser
        if (prop.getProperty("browserName").matches("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }


        // To maximize the Browser Window
        driver.manage().window().maximize();

        // Wait
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    // To open the Main Page URL
    public void openURL(String websiteURLKey) {
        driver.get(prop.getProperty(websiteURLKey));
    }

    // Draws a red border around the found element. Does not set it back anyhow.
    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        js.executeScript("arguments[0].setAttribute('style','background: ;border: 2px solid red;');", element);
        return element;
    }

    // To submit Data in Corporate Wellness Page
    public void submitData() throws InterruptedException {

        By button = By.id("button-style");

        WebElement submit = driver.findElement(button);
        submit.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // To print the Alerts
    public static void printAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert: " + alert.getText());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.accept();
    }

    // To close the Browser
    public void closeBrowser() {
        driver.quit();
    }
}