/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 14/05/2023 - Script created.
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

public class ExistInitiativesPage extends PageBase {
    public ExistInitiativesPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    By table = By.id("ncgr_id_3-table");
    By tabs = By.xpath("//ncgr-select-button[@optionvalue='id']");
    WebElement tabsGroup = getElement(tabs).findElement(By.xpath("//div[@role='group']"));
    List<WebElement> tabsInti = tabsGroup.findElements(By.tagName("div"));
    public String initiativeNameTxt;
    public String UICNumber;
    public String initiativeIdTxt;
    public String govOwnerTxt;
    public String programNameTxt;
    public String durationTxt;

    public void clickOnUnCompletedInitiatives() {
        waitUntilLoaderDisappear();
        tabsInti.get(0).click();
    }

    public void clickOnCompletedInitiatives() {
        wait.until(ExpectedConditions.invisibilityOf(tabsGroup));
        //clickButton(completedIntTab);
        tabsInti.get(1).click();
    }

    public void clickOnViewInitiativeNumber(String number) {
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        //System.out.println("trs size : " + trs.size());
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            //System.out.println("Tds size : " + tds.size());
            if (tds.get(1).getText().equals(number)) {
                //System.out.println("xxxx : " + tds.get(1).getText());
                WebElement lastColumn = tds.get(tds.size() - 1);
                WebElement eyeIcon = lastColumn.findElement(By.xpath("//button[@icon='ncgri ncgri-eye']"));
                //System.out.println("Web Element : " + eyeIcon);
                eyeIcon.click();
                break;
            }
        }
    }

    public void getDataForFirstInitiative() {
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            WebElement UIC = tds.get(1);
            WebElement initiativeId = tds.get(2);
            WebElement govOwner = tds.get(3);
            WebElement programName = tds.get(4);
            WebElement duration = tds.get(5);
            UICNumber = UIC.getText();
            initiativeIdTxt = initiativeId.getText();
            govOwnerTxt = govOwner.getText();
            programNameTxt = programName.getText();
            durationTxt = duration.getText();
            break;
        }
        //System.out.println(UICNumber);
    }

    public void clickOnEditInitiativeNumber(String number) {
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            if (tds.get(1).getText().equals(number)) {
                WebElement initiativeName = tds.get(0);
                initiativeNameTxt = initiativeName.getText();
                WebElement lastColumn = tds.get(6);
                WebElement x = lastColumn.findElement(By.tagName("div"));
                List<WebElement> y = x.findElements(By.tagName("button"));
                WebElement pencilIcon = y.get(1);
                //System.out.println("Web Element : " + eyeIcon);
                clickOnButtonUsingAction(pencilIcon);
            }
        }
    }

    public void VerifyThatSearchByProgramNameIsTrue(String programName) {
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            WebElement programNameTxt = tds.get(4);
            Assert.assertEquals(programNameTxt.getText(), programName);
            System.out.println("Program Name is : " + programNameTxt.getText());
            break;
        }
    }

    public void VerifyThatSearchByEntityNameIsTrue(String programName) {
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            WebElement govOwner = tds.get(3);
            Assert.assertEquals(govOwner.getText(), programName);
            System.out.println("Entity Name is : " + govOwner.getText());
            break;
        }
    }

    public void VerifyThatSearchByDurationIsTrue(String durationTxt) {
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            WebElement duration = tds.get(5);
            Assert.assertEquals(duration.getText(), durationTxt);
            System.out.println("Duration is : " + duration.getText());
            break;
        }

    }

    public void VerifyThatSearchByInitiativeIdIsTrue(String initiativeId) {
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            WebElement initiativeIdTxt = tds.get(2);
            Assert.assertEquals(initiativeIdTxt.getText(), initiativeId);
            System.out.println("Initiative Id is : " + initiativeIdTxt.getText());
            break;
        }
    }

    public void VerifyThatSearchByUICIsTrue(String UIC) {
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
        for (WebElement ele : trs) {
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            WebElement UICTxt = tds.get(1);
            Assert.assertEquals(UICTxt.getText(), UIC);
            System.out.println("UIC is : " + UICTxt.getText());
            break;
        }
    }
}

