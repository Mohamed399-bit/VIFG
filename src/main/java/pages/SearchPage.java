/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 10/05/2023 - Script created.
 */
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        wait =new WebDriverWait(driver, 45);
    }

    public static By govAgencyCodeList = By.xpath("//ncgr-dropdown[@formcontrolname='govAgencyCode']");
    By initiativeIdTxt = By.xpath("//input[@formcontrolname='initiativeId']");
    By durationTxt = By.xpath("//input[@class='ncgr-inputtext ncgr-component ncgr-element ncgr-inputnumber__input']");
    By VRPProgramList = By.xpath("//ncgr-dropdown[@formcontrolname='vrpCode']");
    By UICTxt = By.xpath("//input[@formcontrolname='initiativeUIC']");
    By searchBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button ncgr-component']");
    By clearBtn= By.xpath("//ncgr-button[@styleclass='ncgr-button-danger ncgr-button-outlined']");
    By searchIcon = By.xpath("//i[@class='ncgri ncgri-search']");
    By search = By.xpath("//span[@class='ncgr-input-icon-left']");
    By name = By.xpath("//h5[@class='mb-3 font-weight-bold']");
    By header = By.xpath("//*[@id=\"ncgr_id_3-table\"]/thead/tr/th[7]");
    public void clickOnGovAgencyCodeList(){
        List<WebElement> x = getElement(govAgencyCodeList).findElements(By.tagName("div"));
        WebElement arrow = x.get(x.size()-1);
        clickOnButtonUsingJavaScript(arrow);
    }
    public void searchByInitiativeId(String id){
        System.out.println("Search for Initiative id : " + id);
        setTextWebElement(initiativeIdTxt,id);
    }
    public void searchByDuration(String numberOfMonths){
        waitUntilLoaderDisappear();
        System.out.println("Search Number of months : " + numberOfMonths);
        setTextWebElement(durationTxt,numberOfMonths);
    }

    public void clickOnVRPProgramList(){
        List<WebElement> x = getElement(VRPProgramList).findElements(By.tagName("div"));
        WebElement arrow = x.get(x.size()-1);
        clickOnButtonUsingJavaScript(arrow);
        scrollToBottom2();
    }

    public void searchByUIC(String UIC) throws InterruptedException {
        Thread.sleep(1900);
        waitUntilLoaderDisappear();
        System.out.println("Search for UIC : " + UIC);
        clickOnButtonUsingJavaScript(getElement(UICTxt));
        setTextWebElement(UICTxt,UIC);
        clickButton(header);
        Thread.sleep(1000);
        clickButton(searchIcon);
        //getElement(UICTxt).sendKeys(Keys.ENTER);
    }

    public void clearUICFiled() throws InterruptedException {
        clearTextWbElement(UICTxt);
        clickOnButtonUsingJavaScript(getElement(search));
        Thread.sleep(1500);
       clickButton(searchIcon);
    }

    public void clickOnSearchButton() throws InterruptedException {
        waitUntilLoaderDisappear();
        Thread.sleep(2000);
        clickButton(header);
        clickOnButtonUsingJavaScript(getElement(searchBtn));
        scrollToBottom();
    }

    public void clickOnSearchButton2() throws InterruptedException {
        waitUntilLoaderDisappear();
        Thread.sleep(2000);
        clickButton(name);
        clickOnButtonUsingJavaScript(getElement(searchBtn));
        scrollToBottom();
    }

    public void clickOnClearButton(){
        scrollToUp();
        clickOnButtonUsingJavaScript(getElement(clearBtn));
    }
}
