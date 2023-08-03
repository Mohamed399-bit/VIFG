/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 08/05/2023 - Script created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public JavascriptExecutor jse;
    public Actions actions;
    public WebDriverWait wait;
    public static WebDriver driver;

    //Super constructor
    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemFromListByText(By ele , String text){
        Select ele2 = new Select(driver.findElement(ele));
        ele2.selectByVisibleText(text);
    }

    public void selectItemFromListByIndex(By ele , int index){
        Select ele2 = new Select(driver.findElement(ele));
        ele2.selectByIndex(index);
    }

    protected static void clickButton(By button) {
        driver.findElement(button).click();
    }

    protected static String getTxt(By ele) {
        return driver.findElement(ele).getText();
    }

    protected static WebElement getElement(By ele) {
        return driver.findElement(ele);
    }

    protected static void setTextWebElement(By textElement, String value) {
        driver.findElement(textElement).sendKeys(value);
    }

    protected static void clearTextWbElement(By textElement){
        driver.findElement(textElement).clear();
    }

    public void setTextWebElementByJS(By textElement ,String value){
        jse.executeScript("arguments[0].setAttribute('value','"+value+"')", textElement);
    }

    protected static void clearField(By button) {
        driver.findElement(button).clear();
    }

    public void convertElementEditable(String elementName) {
        jse.executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
    }

    protected void scrollToBottom() {
        jse.executeScript("scrollBy(0,600)");
    }

    protected void scrollToUp() {
        jse.executeScript("scrollBy(0,-650)");
    }
    protected void scrollToBottom2() {
        jse.executeScript("scrollBy(0,250)");
    }

    protected void scrollToBottom3() {
        jse.executeScript("scrollBy(0,100)");
    }
    protected void scrollUntilElement1(By element) throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView(true);", getElement(element));
        Thread.sleep(1000);
    }

    protected void scrollUntilElement2(By element) {
        actions.moveToElement(getElement(element));
        actions.build();
        actions.perform();
    }

    public void clickOnButtonUsingJavaScript(WebElement ele) {
        jse.executeScript("arguments[0].click();", ele);
    }

    public void click(WebElement ele) {
        jse.executeScript("arguments[0].click();", ele);
    }

    public void clickOnButtonUsingAction(WebElement ele){
        actions.moveToElement(ele).
                click().
                perform();
    }

    public void waitUntilLoaderDisappear(){
        wait.until(ExpectedConditions.invisibilityOfAllElements(
                driver.findElement(By.xpath("//section[@class='loading-container']"))));
    }

    public void waitUntilLoaderOfTableDisappear(){
        wait.until(ExpectedConditions.invisibilityOfAllElements(
                driver.findElement(By.xpath("//i[@class='ncgr-table__loading-icon ncgri ncgri-spin ncgri-spinner']"))));
    }


    //you can add below more methods for different types of inputs like checkboxes or dropdown lists and so on
}


