package tests;

import org.testng.annotations.Test;
import pages.*;

public class SearchByEntityTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    OwnerEntitySearchPage ownerEntitySearchObject;

    @Test(priority = 1)
    public void SearchByEntity() throws InterruptedException {
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
        searchObject.clickOnGovAgencyCodeList();

        ownerEntitySearchObject = new OwnerEntitySearchPage(driver);
        ownerEntitySearchObject.selectEntityName(existInitiativesObject.govOwnerTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByEntityNameIsTrue(existInitiativesObject.govOwnerTxt);
        Thread.sleep(2000);
        searchObject.clickOnClearButton();


        Thread.sleep(8000);
    }
}
