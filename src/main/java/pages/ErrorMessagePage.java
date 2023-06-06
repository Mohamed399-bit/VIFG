/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 04/06/2023 - Script created.
 */
package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ErrorMessagePage extends PageBase{
    public ErrorMessagePage(WebDriver driver) {
        super(driver);
    }
    By errorMessage = By.xpath("//div[@role='alert']");

    public void VerifyThatErrorMessageDisplay(String message){
           // برجاء ادخال جميع البيانات المطلوبة بشكل صحيح
        Assert.assertEquals(getTxt(errorMessage),message);
        System.out.println("Error Message is : " + getTxt(errorMessage));
    }
}
