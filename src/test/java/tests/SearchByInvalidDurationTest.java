package tests;

import org.testng.annotations.Test;
import pages.*;
import utilities.Helper;

public class SearchByInvalidDurationTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;

    @Test(priority = 2)
    public void searchByProgramName() throws InterruptedException {
        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod("1856103492", "Test@123456");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();

        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.searchByDuration(Helper.generateRandomNumber(4));
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        Thread.sleep(2000);
    }
}
