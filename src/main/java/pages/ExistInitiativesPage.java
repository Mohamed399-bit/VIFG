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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ExistInitiativesPage extends PageBase {
    public ExistInitiativesPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    By table = By.id("ncgr_id_3-table");
    By tabs = By.xpath("//ncgr-select-button[@optionvalue='id']");
    By nextBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-paginator__next ncgr-paginator__element']");
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

    public void clickOnCompletedInitiatives() throws InterruptedException {
        waitUntilLoaderDisappear();
        tabsInti.get(1).click();
    }

    public void scrollUp() throws InterruptedException {
        scrollToUp();
        Thread.sleep(1000);
    }

    public void scrollDown() throws InterruptedException {
        scrollToBottom2();
        Thread.sleep(2000);
    }

    public void clickOnViewInitiativeNumber(String number) {
        System.out.println("UIC that will open : " + number);
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
                WebElement viewIcon = y.get(0);
                //System.out.println("Web Element : " + eyeIcon);
                clickOnButtonUsingAction(viewIcon);
                break;
            }
        }
    }

    public void getDataForFirstInitiative() {

        int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 2);
        waitUntilLoaderDisappear();
        WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
        List<WebElement> trs = tableBody.findElements(By.tagName("tr"));

            List<WebElement> tds = trs.get(randomNum).findElements(By.tagName("td"));
            WebElement UIC = tds.get(1);
            WebElement initiativeId = tds.get(2);
            WebElement govOwner = tds.get(3);
            WebElement programName = tds.get(4);
            WebElement duration = tds.get(5);
            UICNumber = UIC.getText();
            initiativeIdTxt = initiativeId.getText();
            govOwnerTxt = govOwner.getText();
            programNameTxt = programName.getText();
            String durationTxt2 = duration.getText();
            int value = Integer.parseInt(durationTxt2.replaceAll("[^0-9]", ""));
            durationTxt = Integer.toString(value);

    }

    public void clickOnEditInitiativeNumber(String number) {
        System.out.println("UIC that will open : " + number);
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
            Assert.assertEquals(duration.getText(), durationTxt+" شهر");
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

    boolean page = true;
    public void VerifyThatInitiativeDataCompletedIsAddToCompletedTab(String UIC)  {


        while (page) {
            waitUntilLoaderDisappear();
            scrollToBottom2();
            WebElement tableBody = getElement(table).findElement(By.tagName("tbody"));
            List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
            for (WebElement ele : trs) {
               // System.out.println("trs : " + trs.size());
                List<WebElement> tds = ele.findElements(By.tagName("td"));
                if (tds.get(1).getText().equals(UIC)) {
                    Assert.assertEquals(tds.get(1).getText(), UIC);
                    System.out.println("UIC Number is :" + UIC);
                    page = false;
                    return;
                }
            }
            clickOnButtonUsingJavaScript(getElement(nextBtn));
        }
    }

    public void VerifyThatMessageWhenSearchByInvalidData(String message) throws InterruptedException {
        Thread.sleep(3000);
        waitUntilLoaderDisappear();
        WebElement tBody = getElement(table).findElement(By.tagName("tbody"));
        Assert.assertEquals(tBody.getText(),message);
        System.out.println("Error Message is : " + tBody.getText());
    }
    }


