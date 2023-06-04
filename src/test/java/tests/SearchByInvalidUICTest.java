package tests;

import org.testng.annotations.Test;
import pages.*;
import utilities.Helper;

public class SearchByInvalidUICTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    VRPProgramListPage vrpProgramListObject;

    @Test(priority = 2)
    public void searchByUIC() throws InterruptedException {
        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod("1856103492", "Test@123456");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");

        searchObject = new SearchPage(driver);
        searchObject.searchByUIC(Helper.generateRandomNumber(9));

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        Thread.sleep(2000);
    }
}
