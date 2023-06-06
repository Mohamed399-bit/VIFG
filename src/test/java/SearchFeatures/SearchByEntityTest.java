/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 23/05/2023 - Script created.
 */
package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.SetURL;

public class SearchByEntityTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    OwnerEntitySearchPage ownerEntitySearchObject;

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Valid Entity Name")
    @Feature("Search By Entity Name")
    @Epic("Search")
    public void SearchByEntity() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.getDataForFirstInitiative();

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();
        //homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.clickOnGovAgencyCodeList();

        ownerEntitySearchObject = new OwnerEntitySearchPage(driver);
        ownerEntitySearchObject.selectEntityName(existInitiativesObject.govOwnerTxt);
        searchObject.clickOnSearchButton2();

        existInitiativesObject.VerifyThatSearchByEntityNameIsTrue(existInitiativesObject.govOwnerTxt);
        searchObject.clickOnClearButton();

        SetURL.refreshPage();

        Thread.sleep(2000);
    }
}
