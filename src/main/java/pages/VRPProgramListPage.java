/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 11/05/2023 - Script created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VRPProgramListPage extends PageBase {
    public VRPProgramListPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    By programList = By.xpath("//ul[@role='listbox']");
    List<WebElement> items = getElement(programList).findElements(By.tagName("li"));

    public void selectProgramName(String program) {

        System.out.println("Search for Program Name : " + program);
        for (WebElement ele : items) {
            if (ele.getText().equals(program)) {
                clickOnButtonUsingJavaScript(ele);
                break;
            }
        }
    }

    public void selectProgramName2(int programIndex) {
        System.out.println("Search for Program Name : " + items.get(programIndex).getText());
        clickOnButtonUsingJavaScript(items.get(programIndex));
    }

}