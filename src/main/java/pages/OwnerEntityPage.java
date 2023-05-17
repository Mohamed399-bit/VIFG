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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OwnerEntityPage extends PageBase{
    public OwnerEntityPage(WebDriver driver) {
        super(driver);
    }

    By ownerEntityList = By.id("ncgr_id_4_list");
    List<WebElement> ownerEntityItem = getElement(ownerEntityList).findElements(By.tagName("li"));
    public void SelectEntity() throws InterruptedException {
        Thread.sleep(3000);
        ownerEntityItem.get(5).click();
    }
}
