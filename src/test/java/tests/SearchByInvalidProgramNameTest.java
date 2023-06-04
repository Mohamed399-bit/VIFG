package tests;

import org.testng.annotations.Test;
import pages.*;

public class SearchByInvalidProgramNameTest extends TestBase{

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
        loginObject.loginMethod("1856103492", "Test@123456");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");
        homeObject.clickOnSearchIcon();

        searchObject = new SearchPage(driver);
        searchObject.clickOnVRPProgramList();

        vrpProgramListObject = new VRPProgramListPage(driver);
        vrpProgramListObject.selectProgramName("ascdfsasds");
        searchObject.clickOnSearchButton();

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        Thread.sleep(2000);
    }
}
