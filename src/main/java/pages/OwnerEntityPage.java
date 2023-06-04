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

import java.util.List;

public class OwnerEntityPage extends PageBase{
    public OwnerEntityPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    By ownerEntityList = By.xpath("//ul[@role='listbox']");
    List<WebElement> ownerEntityItem = getElement(ownerEntityList).findElements(By.tagName("li"));
    public void SelectEntity(int index) throws InterruptedException {
        Thread.sleep(1500);
        //scrollToBottom2();
       // System.out.println("Size : " + ownerEntityItem.size());
        ownerEntityItem.get(index).click();
    }
}
