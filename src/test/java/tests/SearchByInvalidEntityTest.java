package tests;

import org.testng.annotations.Test;
import pages.*;
import utilities.Helper;

public class SearchByInvalidEntityTest extends TestBase{

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
        loginObject.loginMethod("1856103492", "Test@123456");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");
        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.clickOnGovAgencyCodeList();

        ownerEntitySearchObject = new OwnerEntitySearchPage(driver);
        ownerEntitySearchObject.selectEntityName2(Helper.generateRandomNumber2(70,120));
        searchObject.clickOnSearchButton();

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.VerifyThatMessageWhenSearchByInvalidData("نأسف، لم يتم العثور على المبادرة نأمل المحاولة مرة اخرى");

        Thread.sleep(2000);
    }
}
