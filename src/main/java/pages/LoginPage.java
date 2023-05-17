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

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By userNameTxt = By.id("Username");
    By passwordTxt = By.id("Password");
    By loginBtn = By.cssSelector("button.btn.btn-secondary-orange.btn-lg.text-white");

    public void loginMethod(String userName , String password){
        setTextWebElement(userNameTxt,userName);
        setTextWebElement(passwordTxt,password);
        clickButton(loginBtn);
    }
}
