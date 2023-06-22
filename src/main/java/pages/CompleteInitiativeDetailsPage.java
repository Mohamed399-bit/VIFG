package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CompleteInitiativeDetailsPage extends PageBase{
    public CompleteInitiativeDetailsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 45);
    }

    By cardData = By.xpath("//div[@class ='card-content row']");
    List<WebElement> item = getElement(cardData).findElements(By.tagName("p"));
    WebElement initiativeNameTxt = item.get(0);
    WebElement initiativeStatusDataTxt = item.get(1);
    By cardBasicData = By.xpath("//initiative-basic-data");
    List<WebElement> basicDataItem = getElement(cardBasicData).findElements(By.tagName("h6"));
    WebElement UICTxt = basicDataItem.get(0);
    WebElement initiativeIdTxt = basicDataItem.get(1);
    WebElement programNameTxt = basicDataItem.get(2);
    By initiativeDescriptiveDataCard = By.xpath("//initiative-descriptive-data[@class='ng-star-inserted']");
    List<WebElement> dataItem = getElement(initiativeDescriptiveDataCard).findElements(By.xpath("//div[@class='row mb-4']"));
    WebElement strategicObjectiveTxt = dataItem.get(0).findElement(By.tagName("h6"));
    List<WebElement> entityData = dataItem.get(1).findElements(By.tagName("h6"));
    WebElement ownerEntityTxt = entityData.get(0);
    WebElement ownerIdTxt = entityData.get(1);
    List<WebElement> initiativeData = dataItem.get(2).findElements(By.tagName("h6"));
    WebElement initiativeFundingStatusTxt = initiativeData.get(0);
    WebElement initiativeClassificationTxt = initiativeData.get(1);
    WebElement approvedCostsTxt = initiativeData.get(2);
    By initiativeAchievedSavingsTxt = By.xpath("//*[@id=\"ncgr_id_7-table\"]/tfoot/tr/td[1]");
    By initiativeDescriptionCard = By.xpath("//initiative-description");
    WebElement initiativeDescriptionTxt = getElement(initiativeDescriptionCard).findElement(By.tagName("h6"));
    By initiativeDateCard = By.xpath("//initiative-dates");
    List<WebElement> initiativeDats = getElement(initiativeDateCard).findElements(By.tagName("h6"));
    WebElement startDateTxt = initiativeDats.get(0);
    WebElement durationTxt = initiativeDats.get(1);
    WebElement endDateTxt = initiativeDats.get(2);

    By backBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-outlined ncgr-button-gray-75 ncgr-button ncgr-component']");

    public void VerifyThatInitiativeNameIsDisplay(){
        waitUntilLoaderDisappear();
        Assert.assertNotEquals(initiativeNameTxt.getText(),"");
        System.out.println("Initiative Name is : " + initiativeNameTxt.getText());
    }

    public void VerifyThatInitiativeStatusDataIsDisplay(){
        waitUntilLoaderDisappear();
        Assert.assertNotEquals(initiativeStatusDataTxt.getText(),"");
        System.out.println("Initiative Status Data is : " + initiativeStatusDataTxt.getText());
    }
    public void VerifyThatUICIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(UICTxt.getText(),"");
        System.out.println("UIC is : " + UICTxt.getText());
    }

    public void VerifyThatInitiativeIdIsDisplay(){
        Assert.assertNotEquals(initiativeIdTxt.getText(),"");
        System.out.println("Initiative Id is : " + initiativeIdTxt.getText());
    }

    public void VerifyThatProgramNameIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(programNameTxt.getText(),"");
        System.out.println("Program Name is : " + programNameTxt.getText());
    }

    public void VerifyThatStrategicObjectiveIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(strategicObjectiveTxt.getText(),"");
        System.out.println("Strategic Objective is : " + strategicObjectiveTxt.getText());
    }

    public void VerifyThatOwnerEntityIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(ownerEntityTxt.getText(),"");
        System.out.println("Owner Entity is : " + ownerEntityTxt.getText());
    }

    public void VerifyThatOwnerIdIsDisplay(){
        Assert.assertNotEquals(ownerIdTxt.getText(),"");
        System.out.println("Owner Id is : " + ownerIdTxt.getText());
    }

    public void VerifyThatInitiativeFundingStatusIsDisplay(){
        Assert.assertNotEquals(initiativeFundingStatusTxt.getText(),"");
        System.out.println("Initiative Funding Status is : " + initiativeFundingStatusTxt.getText());
    }

    public void VerifyThatInitiativeClassificationIsDisplay(){
        Assert.assertNotEquals(initiativeClassificationTxt.getText(),"");
        System.out.println("Initiative Classification is : " + initiativeClassificationTxt.getText());
    }

    public void VerifyThatApprovedCostsIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(approvedCostsTxt.getText(),"");
        System.out.println("Approved Costs is : " + approvedCostsTxt.getText());
    }

    public void VerifyThatInitiativeAchievedSavingsIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(getTxt(initiativeAchievedSavingsTxt),"");
        System.out.println("Initiative Achieved Savings is : " + getTxt(initiativeAchievedSavingsTxt));
    }

    public void VerifyThatInitiativeDescriptionIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(initiativeDescriptionTxt.getText(),"");
        System.out.println("Initiative Description is : " + initiativeDescriptionTxt.getText());
    }

    public void VerifyThatStartDateIsDisplay() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Assert.assertNotEquals(startDateTxt.getText(),"");
        System.out.println("Start Date is : " + startDateTxt.getText());
    }

    public void VerifyThatDurationIsDisplay(){
        Assert.assertNotEquals(durationTxt.getText(),"");
        System.out.println("Duration is : " + durationTxt.getText());
    }

    public void VerifyThatEndDateIsDisplay(){
        Assert.assertNotEquals(endDateTxt.getText(),"");
        System.out.println("End Date is : " + endDateTxt.getText());
    }

    public void clickOnBackButton(){
        scrollToBottom();
        clickOnButtonUsingJavaScript(getElement(backBtn));
    }
}
