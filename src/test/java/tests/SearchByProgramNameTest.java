package tests;

import org.testng.annotations.Test;
import pages.*;

public class SearchByProgramNameTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    VRPProgramListPage vrpProgramListObject;

    @Test(priority = 1)
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

        searchObject = new SearchPage(driver);
        searchObject.clickOnVRPProgramList();

        vrpProgramListObject = new VRPProgramListPage(driver);
        vrpProgramListObject.selectProgramName(existInitiativesObject.programNameTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByProgramNameIsTrue(existInitiativesObject.programNameTxt);
        Thread.sleep(2000);
        searchObject.clickOnClearButton();
        homeObject.clickOnProfile();

        Thread.sleep(8000);
    }
}
