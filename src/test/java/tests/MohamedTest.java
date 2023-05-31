/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 08/05/2023 - Script created.
 */

package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import utilities.Helper;

public class MohamedTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    ExistInitiativesPage  existInitiativesObject;
    InitiativeDetailsPage initiativeDetailsObject;
    initiativeFundingStatusFiledPage initiativeFundingStatusFiledObject;
    InitiativeClassificationPage initiativeClassificationObject;
    InitiativeAchievedSavingsPage initiativeAchievedSavingsObject;
    OwnerEntityPage ownerEntityObject;
    CalenderPage calenderObject;

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login To Web")
    @Feature("Login Epic")
    @Epic("Login Epic")
    public void testMohamed() throws InterruptedException {

        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod("1856103492","Test@123456");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");
       //homeObject.clickOnExistInitiatives();

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        //existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.clickOnEditInitiativeNumber(existInitiativesObject.UICNumber);
        System.out.println(existInitiativesObject.initiativeNameTxt);

        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.enterStrategicObjective(Helper.generateRandomName(300));
        initiativeDetailsObject.clickOnOwnerList();

        ownerEntityObject = new OwnerEntityPage(driver);
        ownerEntityObject.SelectEntity(2);

        initiativeDetailsObject.clickOnInitiativeFundingStatus();

        initiativeFundingStatusFiledObject = new initiativeFundingStatusFiledPage(driver);
        initiativeFundingStatusFiledObject.SelectInitiativeFundingStatus();

        initiativeDetailsObject.clickOnInitiativeClassification();

        initiativeClassificationObject = new InitiativeClassificationPage(driver);
        initiativeClassificationObject.SelectInitiativeClassification();

        initiativeDetailsObject.enterApprovedCosts(Helper.generateRandomNumber(5)+"000");
        initiativeDetailsObject.clickOnEditIcon();

        Thread.sleep(6000);
        initiativeAchievedSavingsObject = new InitiativeAchievedSavingsPage(driver);
        initiativeAchievedSavingsObject.enterInitiativeAchievedSavings(Helper.generateRandomNumber(3)+"000");

        initiativeDetailsObject.enterInitiativeDescription(Helper.generateRandomName(4000));
        initiativeDetailsObject.clickOnCalenderIcon();

        calenderObject = new CalenderPage(driver);
        calenderObject.selectMonthByIndex(5);
        calenderObject.selectYearByIndex("2022");
        calenderObject.selectDay("15");

        initiativeDetailsObject.enterInitiativeDurationPerMonth(Helper.generateRandomNumber(1));
        //initiativeDetailsObject.clickOnCancelButton();
        initiativeDetailsObject.clickOnBackButton();

        Thread.sleep(10000);

    }
}
