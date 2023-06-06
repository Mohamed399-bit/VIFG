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
import utilities.Helper;
import utilities.SetURL;

public class SearchByInvalidEntityTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    OwnerEntitySearchPage ownerEntitySearchObject;

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By InValid Invalid Entity")
    @Feature("Search By Entity Name")
    @Epic("Search")
    public void SearchByInvalidEntity() throws InterruptedException {

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.clickOnGovAgencyCodeList();

        ownerEntitySearchObject = new OwnerEntitySearchPage(driver);
        ownerEntitySearchObject.selectEntityName2(Helper.generateRandomNumber2(70,120));
        searchObject.clickOnSearchButton();

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        SetURL.refreshPage();

        Thread.sleep(2000);
    }
}
