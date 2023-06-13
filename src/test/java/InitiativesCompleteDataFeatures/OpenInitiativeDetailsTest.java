/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 20/05/2023 - Script created.
 */
package InitiativesCompleteDataFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.ExistInitiativesPage;
import pages.InitiativeDetailsPage;
import tests.TestBase;

public class OpenInitiativeTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    InitiativeDetailsPage initiativeDetailsObject;

    public static String UICNumber;
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open Exist Initiative ")
    @Feature("Open Exist Initiative")
    @Epic("Uncompleted Initiative")
    public void OpenExistInitiative() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        UICNumber = existInitiativesObject.UICNumber;
        existInitiativesObject.scrollDown();
        existInitiativesObject.clickOnEditInitiativeNumber(existInitiativesObject.UICNumber);
        System.out.println("Initiative Name : " + existInitiativesObject.initiativeNameTxt);

        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.VerifyFromInitiativeDetailsOpenTure(existInitiativesObject.UICNumber,
                existInitiativesObject.initiativeIdTxt,existInitiativesObject.programNameTxt);

        Thread.sleep(2000);

    }
}
