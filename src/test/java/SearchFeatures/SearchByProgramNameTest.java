/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 22/05/2023 - Script created.
 */
package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.SetURL;

public class SearchByProgramNameTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    VRPProgramListPage vrpProgramListObject;

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Valid Program Name")
    @Feature("Search By Program Name")
    @Epic("Search")
    public void searchByProgramName() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.getDataForFirstInitiative();

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();

        searchObject = new SearchPage(driver);
        searchObject.clickOnVRPProgramList();

        vrpProgramListObject = new VRPProgramListPage(driver);
        vrpProgramListObject.selectProgramName(existInitiativesObject.programNameTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByProgramNameIsTrue(existInitiativesObject.programNameTxt);
        //searchObject.clickOnClearButton();
        SetURL.refreshPage();

        Thread.sleep(3000);
    }
}
