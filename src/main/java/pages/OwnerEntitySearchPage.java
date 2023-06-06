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

    By programList = By.xpath("//ul[@role='listbox']");
    List<WebElement> items = getElement(programList).findElements(By.tagName("li"));

    public void selectEntityName(String entity){

        System.out.println("Search for entity Name : " + entity);
        for (WebElement ele : items){
            if (ele.getText().equals(entity)){
                clickOnButtonUsingJavaScript(ele);
                break;
            }
        }
    }

    public void selectEntityName2(int entity){
        clickOnButtonUsingJavaScript(items.get(entity));
        System.out.println("Search for entity Name : " + getTxt(SearchPage.govAgencyCodeList));
    }
}
