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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public JavascriptExecutor jse;
    public Actions actions;
    public WebDriverWait wait;
    public static WebDriver driver;

    //Super constructor
   /* public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }*/
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

//    protected static void clickButton2(WebElement button) {
//        button.click();
//    }

    protected static void clickButton(By button) {
        driver.findElement(button).click();
    }

    protected static String getTxt(By ele) {
        return driver.findElement(ele).getText();
    }

    protected static WebElement getElement(By ele) {
        return driver.findElement(ele);
    }

//    protected static void setTextWebElement2(WebElement textElement, String value) {
//        textElement.sendKeys(value);
//
//    }

    protected static void setTextWebElement(By textElement, String value) {
        driver.findElement(textElement).sendKeys(value);

    }

    protected static void clearField(By button) {
        driver.findElement(button).clear();
    }

    public void convertElementEditable(String elementName) {
        jse.executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
    }

    protected void scrollToBottom() {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0,500)");
    }

    public void clickOnButtonUsingJavaScript(WebElement ele) {
        jse.executeScript("arguments[0].click();", ele);
    }

    public void click(WebElement ele) {
        jse.executeScript("arguments[0].click();", ele);
    }


    //you can add below more methods for different types of inputs like checkboxes or dropdown lists and so on
}


