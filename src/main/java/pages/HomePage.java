/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 10/05/2023 - Script created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
        jse = (JavascriptExecutor) driver;
    }
    By divUserName = By.cssSelector("div.d-flex.justify-content-between.align-items-center");
    By existIntLabel = By.xpath("//ncgr-menubar-sub[@class='ncgr-element']");
    By getExistIntLink = By.xpath("//a[@href='/initiatives']");
    By searchFiledIcon = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-text ncgr-button-raised ncgr-button ncgr-component ncgr-button-icon-only']");
    By profileIcon = By.xpath("//button[@class='bg-body border-0 profile-menu-button']");
    By logoutBtn = By.xpath("//button[@class='ncgr-element ncgr-button-outlined ncgr-button-secondary ncgr-button-sm mx-4 my-2 ncgr-button ncgr-component']");

    public void verifyThatUserLoggedIn(String name){
        Assert.assertTrue(getElement(divUserName).isDisplayed());
        Assert.assertEquals(getElement(existIntLabel).getText(),name);
        System.out.println("div is display : " + getElement(divUserName).isDisplayed());
        System.out.println(getElement(existIntLabel).getText());
    }

    public void clickOnExistInitiatives(){
        wait.until(ExpectedConditions.presenceOfElementLocated(getExistIntLink));
        clickButton(getExistIntLink);
    }

    public void clickOnSearchIcon() throws InterruptedException {
        Thread.sleep(2000);
        waitUntilLoaderDisappear();
        clickButton(searchFiledIcon);
    }

    public void scrollDown(){
        scrollToBottom2();
    }

    public void clickOnProfile(){
        clickButton(profileIcon);
        clickButton(logoutBtn);
    }

}
