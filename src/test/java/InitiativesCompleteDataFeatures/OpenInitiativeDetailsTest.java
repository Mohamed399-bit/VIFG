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
import pages.InitiativeDetails2Page;
import pages.InitiativeDetailsPage;
import tests.TestBase;

public class OpenInitiativeDetailsTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    InitiativeDetails2Page initiativeDetailsObject;
    InitiativeDetailsPage initiativeDetailsObject2;

    public static String UICNumber;
    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open Initiative Details And Click On Complete Data")
    @Feature("Open Exist Initiative")
    @Epic("Uncompleted Initiative")
    public void OpenExistInitiative() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        UICNumber = existInitiativesObject.UICNumber;
        existInitiativesObject.scrollDown();
        existInitiativesObject.clickOnViewInitiativeNumber(existInitiativesObject.UICNumber);

        initiativeDetailsObject = new InitiativeDetails2Page(driver);
        initiativeDetailsObject.clickOnCompleteData();

        initiativeDetailsObject2 = new InitiativeDetailsPage(driver);
        initiativeDetailsObject2.VerifyThatCompleteDataPageIsOpen("إكمال البيانات");

        Thread.sleep(2000);

    }
}
