package com.xy.demo.step_Definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by xyShi on 3/27/18.
 */
public class BaiduStepdefs {

    WebDriver driver;

    public void initializeDriver(){
        driver = new ChromeDriver();

    }

    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String url) throws Throwable {
        initializeDriver();
        driver.get(url);

    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String search) throws Throwable {
        WebElement keyword_input = driver.findElement(By.id("kw"));
        WebElement search_btn = driver.findElement(By.id("su"));
        keyword_input.sendKeys(search);
        search_btn.click();
    }

    @Then("^a browser title should contains \"([^\"]*)\"$")
    public void a_browser_title_should_contains(String arg1) throws Throwable {

    }

    private void closeDriver() {
        driver.quit();
    }
}
