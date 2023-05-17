package tests;

import org.testng.annotations.Test;
import pages.*;

public class SearchByInitiativeIDTest extends TestBase{

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
        loginObject.loginMethod("1856103492", "Test@12345");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.getDataForFirstInitiative();

        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.searchByInitiativeId(existInitiativesObject.initiativeIdTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByInitiativeIdIsTrue(existInitiativesObject.initiativeIdTxt);

        Thread.sleep(8000);
    }
}
