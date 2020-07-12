package co.uk.motors.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserManager extends  DriverManager
{
    //ist browser we need is chrome. to open chrome:
    private WebDriver initChrome()
    {
        // we set up the chromeDriver:
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
        //so, anytime the method WebDriver is called, it will flash ChromeDriver
    }

    //for headless-chromedriver
    private WebDriver initHeadlessChrome()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "-headless");
        return new ChromeDriver(options);
    }

    //to open firefox:
    private WebDriver initFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
        //the method WebDriver is called, it will flash firefoxDriver
    }
    //for headless firefox:
    private WebDriver initHeadlessFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-gpu", "-headless");
        return new FirefoxDriver(options);
    }
    //to work with any of these 4 browsers:
    public void launchBrowser(String browser)
    {
        switch(browser)
        {
            case "Chrome":
                driver = initChrome();
                break;
            case "HeadlessChrome":
                driver = initHeadlessChrome();
                break;
            case "Firefox":
                driver = initFirefox();
                break;
            case "HeadlessFirefox":
                driver = initHeadlessFirefox();
                break;
            default:
                driver = initHeadlessChrome();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    //to close browser after test:
    public  void closeBrowser()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
