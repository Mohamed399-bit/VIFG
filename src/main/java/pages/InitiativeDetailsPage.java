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
        wait = new WebDriverWait(driver, 45);
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
    By labelName = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[5]/div/div/div/h5");
    By validationMessageInitiativeFundingStatus = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[3]/div/div/div/div[3]/div[1]/div/span");
    By validationMessageInitiativeClassification = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[3]/div/div/div/div[3]/div[2]/div/span");
    By validationMessageApprovedCosts = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[3]/div/div/div/div[3]/div[3]/div/div/div");
    By validationMessageInitiativeAchievedSavings = By.xpath("//*[@id=\"ncgr_id_8-table\"]/tfoot/tr/td[1]/span");
    By validationMessageInitiativeDescription = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[4]/div/div/div/div/div/div/span");
    By validationMessageStartDate = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[5]/div/div/div/div/div[1]/div/div/div");
    By validationMessageDuration = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[5]/div/div/div/div/div[2]/div/div/div");
    By durationLabel = By.xpath("//*[@id=\"ncgr-tabpanel-0\"]/form/ncgr-card[5]/div/div/div/div/div[2]/div/label");
    By headingSection = By.xpath("//div[@class='heading']");

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
        scrollToBottom3();
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
        clickButton(durationLabel);
        scrollToBottom();
    }

    public void clickOnSaveButton(){
        scrollToBottom();
        clickOnButtonUsingJavaScript(getElement(saveBtn));
    }

    public void clickOnCancelButton(){
        scrollToBottom();
        clickButton(cancelBtn);
    }

    public void clickOnBackButton(){
        scrollToBottom();
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

    public void waitUntilPageLoaded(){
        waitUntilLoaderDisappear();
    }

    public void VerifyFromInitiativeFundingStatusValidationMessage(String message){
        Assert.assertEquals(getTxt(validationMessageInitiativeFundingStatus),message);
        System.out.println("Validation message for Initiative Funding Status : " +  getTxt(validationMessageInitiativeFundingStatus));
    }

    public void VerifyFromInitiativeClassificationValidationMessage(String message){
        Assert.assertEquals(getTxt(validationMessageInitiativeClassification),message);
        System.out.println("Validation message for Initiative Classification : " +  getTxt(validationMessageInitiativeClassification));
    }

    public void VerifyFromApprovedCostsValidationMessage(String message){
        Assert.assertEquals(getTxt(validationMessageApprovedCosts),message);
        System.out.println("Validation message for Approved Costs : " +  getTxt(validationMessageApprovedCosts));
    }

    public void VerifyFromInitiativeAchievedSavingsValidationMessage(String message){
        Assert.assertEquals(getTxt(validationMessageInitiativeAchievedSavings),message);
        System.out.println("Validation message for Initiative Achieved Savings : " +  getTxt(validationMessageInitiativeAchievedSavings));
    }

    public void VerifyFromInitiativeDescriptionValidationMessage(String message){
        Assert.assertEquals(getTxt(validationMessageInitiativeDescription),message);
        System.out.println("Validation message for Initiative Description : " +  getTxt(validationMessageInitiativeDescription));
    }

    public void VerifyFromStartDateValidationMessage(String message){
        Assert.assertEquals(getTxt(validationMessageStartDate),message);
        System.out.println("Validation message for Start Date : " +  getTxt(validationMessageStartDate));
    }

    public void VerifyFromDurationValidationMessage(String message){
        Assert.assertEquals(getTxt(validationMessageDuration),message);
        System.out.println("Validation message for Duration : " +  getTxt(validationMessageDuration));
    }

    public void VerifyThatCompleteDataPageIsOpen(String headingName){
        waitUntilLoaderDisappear();
        Assert.assertEquals(getTxt(headingSection),headingName);
        System.out.println("Heading Section is : " + getTxt(headingSection));
    }
}
