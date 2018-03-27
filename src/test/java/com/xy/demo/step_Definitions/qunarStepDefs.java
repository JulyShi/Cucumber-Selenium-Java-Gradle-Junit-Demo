package com.xy.demo.step_Definitions;

import com.xy.demo.pageObjects.QunarHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by xyShi on 3/20/18.
 */
public class qunarStepDefs {

    private WebDriver driver;
    public static QunarHomePage qunarHomePage;

    public qunarStepDefs(){
        driver = Hooks.driver;
        qunarHomePage = PageFactory.initElements(driver, QunarHomePage.class);

    }

    @Given("^I open qunar website and validate the title$")
    public void i_open_qunar_website_and_validate_the_title() {

    }

    @When("^I click \"([^\"]*)\"$")
    public void i_click(String tab) {
        qunarHomePage.clickTab(tab);
    }

    @When("^I input the Free Trip search page$")
    public void i_input_the_Free_Trip_search_page() throws InterruptedException {
        qunarHomePage.Fn_FillinFreeTripPage();
    }

    @Then("^the search result displayed$")
    public void the_search_result_displayed() {
        System.out.println("Title: " + driver.getTitle());

    }

}
