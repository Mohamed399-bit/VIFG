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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LunchPage extends PageBase{
    public LunchPage(WebDriver driver) {
        super(driver);
    }

    By comDiv = By.cssSelector("div.row.border-bottom.pb-5.justify-content-center");
    List <WebElement> divs = getElement(comDiv).findElements(By.tagName("div"));

    public void clickOnGovernmentEntity(){
        divs.get(0).click();
    }
}
