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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InitiativeAchievedSavingsPage extends PageBase{
    public InitiativeAchievedSavingsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
        jse = (JavascriptExecutor) driver;
    }

    By initiativeAchievedSavingsTxt = By.id("initiativeAchievedSavings");

    public void enterInitiativeAchievedSavings(String value) throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(initiativeAchievedSavingsTxt));
        WebElement inputText = getElement(initiativeAchievedSavingsTxt).findElement(By.tagName("input"));
        //clickOnButtonUsingJavaScript(inputText);
        inputText.clear();
        Thread.sleep(1000);
        inputText.sendKeys(value);

    }

    public void clearInitiativeAchievedSavings() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(initiativeAchievedSavingsTxt));
        WebElement inputText = getElement(initiativeAchievedSavingsTxt).findElement(By.tagName("input"));
        //clickOnButtonUsingJavaScript(inputText);
        inputText.clear();
        Thread.sleep(1000);

    }
}
