package tests;

import org.testng.annotations.Test;
import pages.*;

public class SearchByDurationTest extends TestBase{

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
        existInitiativesObject.getDataForFirstInitiative();

        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.searchByDuration(existInitiativesObject.durationTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByDurationIsTrue(existInitiativesObject.durationTxt);
        Thread.sleep(2000);

        searchObject.clickOnClearButton();

        Thread.sleep(5000);
    }
}
