/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 15/05/2023 - Script created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class InitiativeDetailsPage extends PageBase{
    public InitiativeDetailsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 50);
    }

    By strategicObjectiveTxt = By.id("strategicObjectiveName");
    By ownerEntityFiled = By.xpath("//ncgr-dropdown[@optionvalue='agencyCode']");
    By initiativeClassificationFiled = By.xpath("//ncgr-dropdown[@formcontrolname='initiativeClassificationInImplementationPlan']");
    By initiativeFundingStatusFiled = By.xpath("//ncgr-dropdown[@formcontrolname='initiativeFundingStatusId']");
    By approvedCostsTxt = By.id("approvedCosts");
    By editIcon = By.xpath("//button[@icon='ncgri ncgri-pencil']");
    By approvedInitiativeDescriptionTxt = By.id("approvedInitiativeDescription");
    By calendarBtn = By.xpath("//button[@class='ncgr-datepicker-icon-button icon-filled-calendar']");
    By initiativeDurationPerMonthTxt = By.id("initiativeDurationPerMonth");
    By cancelBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-danger ncgr-button ncgr-component']");
    By saveBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-primary ncgr-button ncgr-component']");
    By backBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-outlined ncgr-button-gray-75 ncgr-button ncgr-component']");
    By UICTxt = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[1]/div/div/div/div/div[1]/div/p");
    By initiativeIdTxt = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[1]/div/div/div/div/div[2]/div/p");
    By programNameTxt = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[1]/div/div/div/div/div[3]/div/p");

    By loaderTable = By.xpath("//i[@class='ncgr-table__loading-icon ncgri ncgri-spin ncgri-spinner']");
    By labelName = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[4]/div/div/div/h3");

    public void enterStrategicObjective(String Objective)  {
        waitUntilLoaderDisappear();
        scrollUntilElement2(strategicObjectiveTxt);
        clickOnButtonUsingJavaScript(getElement(strategicObjectiveTxt));
        setTextWebElement(strategicObjectiveTxt,Objective);
        scrollToBottom();
    }
    public void clickOnOwnerList() throws InterruptedException {
        waitUntilLoaderDisappear();
        scrollToBottom();
        WebElement arrow = getElement(ownerEntityFiled).findElement(
                By.xpath("//div[@aria-label='dropdown trigger']"));
        clickOnButtonUsingJavaScript(arrow);
        scrollToBottom();
        Thread.sleep(1500);

    }
    public void clickOnInitiativeClassification(){
        List<WebElement> x = getElement(initiativeClassificationFiled).findElements(By.tagName("div"));
        WebElement arrow = x.get(x.size()-1);
        clickOnButtonUsingJavaScript(arrow);
    }
    public void clickOnInitiativeFundingStatus(){
        List<WebElement> y = getElement(initiativeFundingStatusFiled).findElements(By.tagName("div"));
        WebElement arrow2 = y.get(y.size()-1);
        clickOnButtonUsingJavaScript(arrow2);
    }
    public void enterApprovedCosts(String costNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(approvedCostsTxt));
        WebElement inputText = getElement(approvedCostsTxt).findElement(By.tagName("input"));
        clickOnButtonUsingJavaScript(inputText);
        inputText.sendKeys(costNumber);
    }

    public void clickOnEditIcon() throws InterruptedException {
        Thread.sleep(2000);
        scrollToBottom();
        wait.until(ExpectedConditions.elementToBeClickable(approvedCostsTxt));
        clickOnButtonUsingJavaScript(getElement(editIcon));
    }

    public void enterInitiativeDescription(String Description) throws InterruptedException {
        Thread.sleep(1000);
        scrollToBottom2();
        setTextWebElement(approvedInitiativeDescriptionTxt,Description);
        clickOnButtonUsingJavaScript(getElement(labelName));
        scrollToBottom();
    }

    public void clickOnCalenderIcon() throws InterruptedException {
        scrollToBottom();
        wait.until(ExpectedConditions.elementToBeClickable(calendarBtn));
        Thread.sleep(2000);
        clickButton(calendarBtn);
    }

    public void enterInitiativeDurationPerMonth(String numberOfMonths){
        WebElement durationTxt = getElement(initiativeDurationPerMonthTxt).findElement(By.tagName("input"));
        clickOnButtonUsingJavaScript(durationTxt);
        durationTxt.sendKeys(numberOfMonths);
    }

    public void clickOnSaveButton(){
        clickButton(saveBtn);
    }

    public void clickOnCancelButton(){
        clickButton(cancelBtn);
    }

    public void clickOnBackButton(){
        clickButton(backBtn);
    }

    public void VerifyFromInitiativeDetailsOpenTure(String UIC , String initiativeId, String IProgram){
        Assert.assertEquals(getTxt(UICTxt), UIC);
        System.out.println("UIC Is : " + getTxt(UICTxt));
        Assert.assertEquals(getTxt(initiativeIdTxt),initiativeId);
        System.out.println("Initiative Id : " + getTxt(initiativeIdTxt));
        Assert.assertEquals(getTxt(programNameTxt),IProgram);
        System.out.println("Initiative Program Name : " + getTxt(programNameTxt));
    }
}
