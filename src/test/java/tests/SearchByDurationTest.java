package tests;

import org.testng.annotations.Test;
import pages.*;

public class SearchByDurationTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    VRPProgramListPage vrpProgramListObject;

    @Test(priority = 2)
    public void searchByProgramName() throws InterruptedException {
        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod("1856103492", "Test@12345");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.getDataForFirstInitiative();

        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.searchByDuration(existInitiativesObject.durationTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByDurationIsTrue(existInitiativesObject.durationTxt);

        Thread.sleep(8000);
    }
}
