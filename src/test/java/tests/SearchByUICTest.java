package tests;

import org.testng.annotations.Test;
import pages.*;

public class SearchByUICTest extends TestBase{

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

        existInitiativesObject = new ExistInitiativesPage(driver);
        //existInitiativesObject.clickOnUnCompletedInitiatives();
        existInitiativesObject.getDataForFirstInitiative();

        searchObject = new SearchPage(driver);
        searchObject.searchByUIC(existInitiativesObject.UICNumber);

        existInitiativesObject.VerifyThatSearchByUICIsTrue(existInitiativesObject.UICNumber);

        Thread.sleep(4000);
    }
}
