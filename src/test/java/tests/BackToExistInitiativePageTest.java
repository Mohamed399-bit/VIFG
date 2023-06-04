package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import utilities.Helper;

public class BackToExistInitiativePageTest extends TestBase{

    InitiativeDetailsPage initiativeDetailsObject;
    initiativeFundingStatusFiledPage initiativeFundingStatusFiledObject;
    InitiativeClassificationPage initiativeClassificationObject;
    InitiativeAchievedSavingsPage initiativeAchievedSavingsObject;
    OwnerEntityPage ownerEntityObject;
    CalenderPage calenderObject;
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Back To Exist Initiative Page")
    @Feature("Back To Exist Initiative Page")
    @Epic("Uncompleted Initiative")
    public void BackToExistInitiativePage() throws InterruptedException {

        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.enterStrategicObjective(Helper.generateRandomName(300));
        initiativeDetailsObject.clickOnOwnerList();

        ownerEntityObject = new OwnerEntityPage(driver);
        ownerEntityObject.SelectEntity(2);

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

        initiativeDetailsObject.enterInitiativeDescription(Helper.generateRandomName(10000));
        initiativeDetailsObject.clickOnCalenderIcon();

        calenderObject = new CalenderPage(driver);
        calenderObject.selectMonthByIndex(5);
        calenderObject.selectYearByIndex("2022");
        calenderObject.selectDay("15");

        initiativeDetailsObject.enterInitiativeDurationPerMonth(Helper.generateRandomNumber(1));
        initiativeDetailsObject.clickOnBackButton();

    }
}
