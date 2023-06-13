package InitiativesCompleteDataFeatures;/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 20/05/2023 - Script created.
 */

import io.qameta.allure.*;
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.Test;
import pages.ExistInitiativesPage;
import pages.InitiativeDetails2Page;
import pages.PreviousProceduresPage;
import tests.TestBase;
import utilities.SetURL;

public class OpenPreviousProceduresTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    InitiativeDetails2Page initiativeDetailsObject;
    PreviousProceduresPage previousProceduresObject;

    public static String UICNumber;
    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open Previous Procedures ")
    @Feature("Open Exist Initiative")
    @Epic("Uncompleted Initiative")
    public void OpenPreviousProcedures() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        UICNumber = existInitiativesObject.UICNumber;
        existInitiativesObject.scrollDown();
        existInitiativesObject.clickOnViewInitiativeNumber(existInitiativesObject.UICNumber);

        initiativeDetailsObject = new InitiativeDetails2Page(driver);
        initiativeDetailsObject.clickOnPreviousActions();

        previousProceduresObject = new PreviousProceduresPage(driver);
        previousProceduresObject.verifyThatPreviousProceduresPageDisplay("الإجراءات السابقة");

        initiativeDetailsObject.clickOnBackButton();

        Thread.sleep(1500);
        SetURL.refreshPage();
        Thread.sleep(2000);

    }
}
