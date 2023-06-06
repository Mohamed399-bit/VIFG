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

public class SearchByUICTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Valid UIC")
    @Feature("Search By UIC")
    @Epic("Search")
    public void searchByUIC() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.getDataForFirstInitiative();

        searchObject = new SearchPage(driver);
        searchObject.searchByUIC(existInitiativesObject.UICNumber);

        existInitiativesObject.VerifyThatSearchByUICIsTrue(existInitiativesObject.UICNumber);
        //searchObject.clickOnClearButton();
        SetURL.refreshPage();

        Thread.sleep(3000);
    }
}
