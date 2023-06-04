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
    SavePopupPage savePopupObject;
    ErrorMessagePage errorMessageObject;

    int randomNumMonth = Helper.generateRandomNumber2(0,11);
    int randomYear = Helper.generateRandomNumber2(2020,2023);
    int randomNumDay = Helper.generateRandomNumber2(1,30);
    int durationNumber = Helper.generateRandomNumber2(10,30);

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
        existInitiativesObject.scrollDown();
        //existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.clickOnEditInitiativeNumber(existInitiativesObject.UICNumber);
        System.out.println(existInitiativesObject.initiativeNameTxt);


        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.enterStrategicObjective(Helper.generateRandomWords2(50));
        initiativeDetailsObject.clickOnOwnerList();

        ownerEntityObject = new OwnerEntityPage(driver);
        ownerEntityObject.SelectEntity(Helper.generateRandomNumber2(0,50));

        initiativeDetailsObject.clickOnInitiativeFundingStatus();

        initiativeFundingStatusFiledObject = new initiativeFundingStatusFiledPage(driver);
        initiativeFundingStatusFiledObject.SelectInitiativeFundingStatus(Helper.generateRandomNumber2(0,3));

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

//        initiativeDetailsObject.enterInitiativeDurationPerMonth(Integer.toString(durationNumber));
        initiativeDetailsObject.clickOnSaveButton();

        savePopupObject = new SavePopupPage(driver);
        savePopupObject.clickOnSaveButton();

        errorMessageObject = new ErrorMessagePage(driver);
        errorMessageObject.VerifyThatErrorMessageDisplay("برجاء ادخال جميع البيانات المطلوبة بشكل صحيح");

        Thread.sleep(10000);

    }
}
