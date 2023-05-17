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

public class initiativeFundingStatusFiledPage extends PageBase{
    public initiativeFundingStatusFiledPage(WebDriver driver) {
        super(driver);
        jse =(JavascriptExecutor) driver;
    }
    By initiativeFundingStatusList = By.id("ncgr_id_5_list");
    List<WebElement> initiativeFundingStatusItem = getElement(initiativeFundingStatusList).findElements(By.tagName("li"));

    public void SelectInitiativeFundingStatus(){

        initiativeFundingStatusItem.get(1).click();
    }
}
