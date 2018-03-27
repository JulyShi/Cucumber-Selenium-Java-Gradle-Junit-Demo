package com.xy.demo.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by xyShi on 3/20/18.
 */
public class QunarHomePage extends BaseClass {
    WebDriverWait wait;

    public QunarHomePage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 5);

    }

    /**
     * Find Web Elements
     */
    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[1]/a")
    public WebElement planeTicket_tab;

    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[2]/a")
    public WebElement hotelTicket_tab;

    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[3]/a")
    public WebElement trainTicket_tab;

    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[4]/a")
    public WebElement holiday_tab;

    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[5]/a")
    public WebElement tickets_tab;

    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[6]/a")
    public WebElement groupPurchase_tab;

    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[7]/a")
    public WebElement car_tab;

    @FindBy(xpath = ".//*[@id='js_nva_cgy']/li[8]/a")
    public WebElement freeTrip_tab;

    @FindBy(xpath = ".//*[@id='js_type_roundtrip']")
    public WebElement roundTrip_radiobutton;

    @FindBy(xpath = ".//*[contains(@id, 'js_freetrip')]/div[1]/div[1]/label[2]")
    public WebElement oneWay_radiobutton;

    @FindBy(xpath = ".//*[@id='js_freetrip_list']/div[1]/div[1]/div/div[1]/input")
    public WebElement startLocation_Table;

    @FindBy(xpath = ".//*[@id='js_freetrip_list']/div[2]/div[1]/div/div[1]/input")
    public WebElement endLocation_Table;

    @FindBy(xpath = ".//*[@id='freetripFromDate']")
    public WebElement FromDate;

    @FindBy(xpath = ".//*[@id='freetrip_adt_num']/input")
    public WebElement adt_num_Dropdown;

    @FindBy(xpath = "//*[@id='freetrip_adult_box']/div[2]/ul/li")
    public List<WebElement> adt_num_option;

    @FindBy(xpath = ".//*[@id='freetrip_chd_num']/input")
    public WebElement chd_num_Dropdown;

    @FindBy(xpath = ".//*[@id='freetrip_submit_btn']")
    public WebElement Search_btn;


    /**
     * KeyWords
     **/
    public void clickTab(String tab){
        if (tab.equalsIgnoreCase("飞机票") && (isElementPresent(planeTicket_tab))) {
            planeTicket_tab.click();

        } else if (tab.equalsIgnoreCase("酒店") && (isElementPresent(hotelTicket_tab))) {
            hotelTicket_tab.click();

        } else if (tab.equalsIgnoreCase("火车票") && (isElementPresent(trainTicket_tab))) {
            trainTicket_tab.click();

        } else if (tab.equalsIgnoreCase("度假") && (isElementPresent(holiday_tab))) {
            holiday_tab.click();

        } else if (tab.equalsIgnoreCase("门票") && (isElementPresent(tickets_tab))) {
            tickets_tab.click();

        } else if (tab.equalsIgnoreCase("团购") && (isElementPresent(groupPurchase_tab))) {
            groupPurchase_tab.click();

        } else if (tab.equalsIgnoreCase("车车") && (isElementPresent(car_tab))) {
            car_tab.click();

        } else if (tab.equalsIgnoreCase("自由行") && (isElementPresent(freeTrip_tab))) {
            freeTrip_tab.click();
        } else {
            planeTicket_tab.click();

        }


    }

    public QunarHomePage waitforFreeTripPage(){
        WebDriverWait wait = new WebDriverWait(this.driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(oneWay_radiobutton));
        return this;
    }

    public void clickTripeRadioButton(String radiobutton){
        if (radiobutton.equalsIgnoreCase("往返") && (isElementPresent(roundTrip_radiobutton))) {
            roundTrip_radiobutton.click();
        } else if (radiobutton.equalsIgnoreCase("单程") && (isElementPresent(oneWay_radiobutton))) {
            oneWay_radiobutton.click();
        }else{
            roundTrip_radiobutton.click();
        }
    }

    // set出发地
    public void inputStartLocation(String location){
        if (isElementPresent(startLocation_Table)){
            startLocation_Table.clear();
            startLocation_Table.sendKeys(location);
        }
    }

    // set目的地
    public void inputEndLocation(String location){
        if (isElementPresent(endLocation_Table)){
            endLocation_Table.clear();
            endLocation_Table.sendKeys(location);
        }
    }


    public void setFromDate(String fromdate){
        if(isElementPresent(FromDate)){
            //JavascriptExecutor js = (JavascriptExecutor) driver;
            //js.executeScript("arguements.removeAttribute(\"readonly\")", this.FromDate);
            FromDate.clear();
            FromDate.sendKeys(fromdate);
        }
    }

//    public void setAdtNumDropdown(int index){
//        if(isElementPresent(adt_num_Dropdown)){
//            adt_num_Dropdown.click();
//            adt_num_option.get(index).click();
//        }
//    }

    public void setAdtNumDropdown(String adtnum){
        if(isElementPresent(adt_num_Dropdown)){
            // Remove readonly attribute
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute(\"readonly\")", this.adt_num_Dropdown);
            adt_num_Dropdown.clear();
            adt_num_Dropdown.sendKeys(adtnum);
        }
    }



    //java - Remove readonly attributes in Selenium WebDriver
    public void setChdNumDropdown(String chdnum){
        if(isElementPresent(chd_num_Dropdown)){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('readonly')", this.chd_num_Dropdown);
            chd_num_Dropdown.clear();
            chd_num_Dropdown.click();
        }
    }

    public void getValueoflist(){
        for(int i=0; i<9; i++) {
            System.out.println("Adtup num option : " + adt_num_option.get(i).getAttribute("value"));
        }
    }



    /**
     * Methods
     **/
    public void Fn_FillinFreeTripPage() throws InterruptedException {
        waitforFreeTripPage();
       // Hooks.logger.info("Begin to fill in the page");
        Thread.sleep(3000);
        clickTripeRadioButton("单程");
        Thread.sleep(1000);
        setFromDate("2017-10-01");
        setAdtNumDropdown("1");
        //setAdtNumDropdown(2);
        //getValueoflist();
        setChdNumDropdown("1");
        Thread.sleep(1000);
        inputStartLocation("西安");
        inputEndLocation("三亚");
        Thread.sleep(1000);
        Search_btn.click();
    }

}