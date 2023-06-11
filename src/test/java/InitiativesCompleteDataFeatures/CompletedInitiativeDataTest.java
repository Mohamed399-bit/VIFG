/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 24/05/2023 - Script created.
 */
package InitiativesCompleteDataFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.Helper;
import utilities.SetURL;


public class CompletedInitiativeDataTest extends TestBase {

    InitiativeDetailsPage initiativeDetailsObject;
    initiativeFundingStatusFiledPage initiativeFundingStatusFiledObject;
    InitiativeClassificationPage initiativeClassificationObject;
    InitiativeAchievedSavingsPage initiativeAchievedSavingsObject;
    OwnerEntityPage ownerEntityObject;
    CalenderPage calenderObject;
    SavePopupPage savePopupObject;
    ExistInitiativesPage existInitiativesObject;
    int randomNumMonth = Helper.generateRandomNumber2(0,11);
    int randomYear = Helper.generateRandomNumber2(2020,2023);
    int randomNumDay = Helper.generateRandomNumber2(1,30);
    int durationNumber = Helper.generateRandomNumber2(10,30);
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Complete Data For Uncompleted Initiative")
    @Feature("Complete Data For Uncompleted Initiative")
    @Epic("Uncompleted Initiative")
    public void CompleteDataForUncompletedInitiative() throws InterruptedException {

        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.enterStrategicObjective(Helper.generateRandomWords2(50));
        initiativeDetailsObject.clickOnOwnerList();

        ownerEntityObject = new OwnerEntityPage(driver);
        ownerEntityObject.SelectEntity(Helper.generateRandomNumber2(0,10));

        initiativeDetailsObject.clickOnInitiativeFundingStatus();

        initiativeFundingStatusFiledObject = new initiativeFundingStatusFiledPage(driver);
        initiativeFundingStatusFiledObject.SelectInitiativeFundingStatus(Helper.generateRandomNumber2(0,4));

        initiativeDetailsObject.clickOnInitiativeClassification();

        initiativeClassificationObject = new InitiativeClassificationPage(driver);
        initiativeClassificationObject.SelectInitiativeClassification(Helper.generateRandomNumber2(0,1));

        initiativeDetailsObject.enterApprovedCosts(Helper.generateRandomNumber(5)+"000");
        initiativeDetailsObject.clickOnEditIcon();

        initiativeAchievedSavingsObject = new InitiativeAchievedSavingsPage(driver);
        initiativeAchievedSavingsObject.enterInitiativeAchievedSavings(Helper.generateRandomNumber(3)+"000");

        initiativeDetailsObject.enterInitiativeDescription(Helper.generateRandomWords2(400));
        initiativeDetailsObject.clickOnCalenderIcon();

        calenderObject = new CalenderPage(driver);
        calenderObject.selectMonthByIndex(randomNumMonth);
        calenderObject.selectYearByIndex(Integer.toString(randomYear));
        calenderObject.selectDay(Integer.toString(randomNumDay));

        initiativeDetailsObject.enterInitiativeDurationPerMonth(Integer.toString(durationNumber));
        initiativeDetailsObject.clickOnSaveButton();

        savePopupObject = new SavePopupPage(driver);
        savePopupObject.clickOnSaveButton();
        Thread.sleep(4000);
        SetURL.refreshPage();
        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.scrollUp();
        existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.VerifyThatInitiativeDataCompletedIsAddToCompletedTab(OpenInitiativeTest.UICNumber);
        Thread.sleep(2000);

    }
}
