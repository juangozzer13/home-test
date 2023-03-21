package StepsDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void tearsUp(){
        System.getProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://localhost:3100/login");
    }

    @After
    public void tearsDown(){
        driver.close();
        driver.quit();
    }

    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementWithText(WebElement element, String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
        wait.until(ExpectedConditions.textToBePresentInElement(element, title));
    }

    public static boolean driverGetAlertIsPresent(){
        try {
            return !driver.switchTo().alert().getText().isEmpty();
        }catch (NoAlertPresentException e){
            System.out.println("Alert didn't appears");
        }
        return false;
    }
    public static void driverAcceptAlert(){
        driver.switchTo().alert().accept();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
