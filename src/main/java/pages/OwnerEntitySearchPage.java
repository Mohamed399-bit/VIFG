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

public class OwnerEntitySearchPage extends PageBase{
    public OwnerEntitySearchPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    By programList = By.xpath("//ul[@class='ncgr-dropdown__items ng-tns-c68-1 ng-star-inserted']");
    List<WebElement> items = getElement(programList).findElements(By.tagName("li"));

    public void selectEntityName(String entity){

        for (WebElement ele : items){
            if (ele.getText().equals(entity)){
                clickOnButtonUsingJavaScript(ele);
                break;
            }
        }
    }
}