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

public class InitiativeAchievedSavingsPage extends PageBase{
    public InitiativeAchievedSavingsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
        jse = (JavascriptExecutor) driver;
    }

    By initiativeAchievedSavingsTxt = By.id("initiativeAchievedSavings");

    public void enterInitiativeAchievedSavings(String value) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(initiativeAchievedSavingsTxt));
        WebElement inputText = getElement(initiativeAchievedSavingsTxt).findElement(By.tagName("input"));
        clickOnButtonUsingJavaScript(inputText);
        inputText.sendKeys(value);
    }
}