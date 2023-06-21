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

public class SearchByInvalidInitiativeIDTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By InValid Initiative ID")
    @Feature("Search By Initiative Id")
    @Epic("Search")
    public void SearchByInvalidInitiativeID() throws InterruptedException {

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.searchByInitiativeId(Helper.generateRandomNumber(7));
        searchObject.clickOnSearchButton();

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        SetURL.refreshPage();

        Thread.sleep(3000);
    }
}
