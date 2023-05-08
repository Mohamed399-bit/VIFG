/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 08/05/2023 - Script created.
 */

package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LunchPage;

public class MohamedTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;

    @Test
    public void testMohamed() throws InterruptedException {

        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod("1591802390","P@ssw0rd");

        Thread.sleep(7000);

    }
}
