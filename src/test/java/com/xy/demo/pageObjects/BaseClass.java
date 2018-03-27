package com.xy.demo.pageObjects;


import com.xy.demo.step_Definitions.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xyShi on 3/20/18.
 */
public abstract class BaseClass {
    public static WebDriver driver;
    public static boolean bResult;

    public  BaseClass(WebDriver driver){
        BaseClass.driver = driver;
        BaseClass.bResult = true;
    }

    // isElemnent Present
    public static boolean isElementPresent(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    // switch tab
    public static void switchChromeTab() throws InterruptedException{
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        Hooks.logger.info("Switch to the new tab");

    }

    // Screenshot
    public static void screenshot(WebDriver driver){
        String screenpath = "./target/screenshots/";
        try {
            TakesScreenshot scrShot = ((TakesScreenshot)driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(screenpath + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(SrcFile,DestFile);
        }catch (IOException e) {
            e.printStackTrace();
        }
        Hooks.logger.info("Snapshot done");
    }
}
