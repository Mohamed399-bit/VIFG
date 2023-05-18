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

import java.util.List;

public class InitiativeDetailsPage extends PageBase{
    public InitiativeDetailsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 30);
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
    public void enterStrategicObjective(String Objective)  {
        waitUntilLoaderDisappear();
        scrollUntilElement2(strategicObjectiveTxt);
        clickOnButtonUsingJavaScript(getElement(strategicObjectiveTxt));
        setTextWebElement(strategicObjectiveTxt,Objective);
    }
    public void clickOnOwnerList() throws InterruptedException {
        Thread.sleep(2000);
        waitUntilLoaderDisappear();
        scrollToBottom();
        WebElement arrow = getElement(ownerEntityFiled).findElement(
                By.xpath("//div[@aria-label='dropdown trigger']"));
        clickOnButtonUsingJavaScript(arrow);
        Thread.sleep(2500);

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
        scrollToBottom();
        setTextWebElement(approvedInitiativeDescriptionTxt,Description);
    }

    public void clickOnCalenderIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(calendarBtn));
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

}
