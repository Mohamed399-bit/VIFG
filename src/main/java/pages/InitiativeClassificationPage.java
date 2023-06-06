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

public class InitiativeClassificationPage extends PageBase{
    public InitiativeClassificationPage(WebDriver driver) {
        super(driver);
        jse =(JavascriptExecutor) driver;
    }

    By initiativeClassificationList = By.xpath("//ul[@role='listbox']");
    List<WebElement> initiativeClassificationItem = getElement(initiativeClassificationList).findElements(By.tagName("li"));

    public void SelectInitiativeClassification(int index){
        initiativeClassificationItem.get(index).click();
    }
}
