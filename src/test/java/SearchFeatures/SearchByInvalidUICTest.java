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

public class SearchByInvalidUICTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;


    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Invalid UIC")
    @Feature("Search By UIC")
    @Epic("Search")
    public void searchByInvalidUIC() throws InterruptedException {

        searchObject = new SearchPage(driver);
        searchObject.searchByUIC(Helper.generateRandomNumber(9));

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        SetURL.refreshPage();

        Thread.sleep(2000);
    }
}
