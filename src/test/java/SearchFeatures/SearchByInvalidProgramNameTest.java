/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 24/05/2023 - Script created.
 */
package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.Helper;
import utilities.SetURL;

public class SearchByInvalidProgramNameTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    VRPProgramListPage vrpProgramListObject;

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By InValid Program Name")
    @Feature("Search By Program Name")
    @Epic("Search")
    public void searchByInvalidProgramName() throws InterruptedException {

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();

        searchObject = new SearchPage(driver);
        searchObject.clickOnVRPProgramList();

        vrpProgramListObject = new VRPProgramListPage(driver);
       // vrpProgramListObject.selectProgramName("ascdfsasds");    //Test Env
        vrpProgramListObject.selectProgramName2(Helper.generateRandomNumber2(20,22));
        //vrpProgramListObject.selectProgramName("TEST");      // pre-prod Env
        searchObject.clickOnSearchButton();

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        SetURL.refreshPage();

        Thread.sleep(2000);
    }
}
