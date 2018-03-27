package com.xy.demo.step_Definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by xyShi on 3/20/18.
 */
public class Hooks {

    public static WebDriver driver;

    public static String browser = "chrome";
    public static String URL = "https://www.qunar.com/";

    public static Logger logger = Logger.getLogger("console");


    @Before
    public void BeforeSteps_openBrowser() {

        if (browser.equalsIgnoreCase("chrome")) {
            // open chrome browser
            System.out.println("start chrome browser...");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            //System.setProperty("webdriver.chrome.driver","./chromedriver"); //Set chromedriver path
            //driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            logger.info("This is info message: Open broswer successfully");
        }

        else if(browser.equalsIgnoreCase("firefox")){
            // open chrome browser

            System.out.println(" start FireFox driver");
            System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
            WebDriver driver = new FirefoxDriver();
            //driver = new FirefoxDriver();
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        else if(browser.equalsIgnoreCase("ie")){

            System.setProperty("webdriver.ie.driver", "files/IEDriverServer64.exe"); //Set IEDriver 路径
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句
            capabilities.setCapability("ignoreProtectedModeSettings",true);
            driver = new InternetExplorerDriver(capabilities);
        }

        else
        {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }

    }


    @After
    public void AfterSteps() {
        driver.quit();
    }


}
