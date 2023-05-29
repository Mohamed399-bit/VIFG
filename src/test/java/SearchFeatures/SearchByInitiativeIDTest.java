package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.SetURL;

public class SearchByInitiativeIDTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Initiative Id")
    @Feature("Search")
    @Epic("Search")
    public void searchByInitiativeId() throws InterruptedException {


        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.getDataForFirstInitiative();

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();
        //homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.searchByInitiativeId(existInitiativesObject.initiativeIdTxt);
        searchObject.clickOnSearchButton2();

        existInitiativesObject.VerifyThatSearchByInitiativeIdIsTrue(existInitiativesObject.initiativeIdTxt);
        SetURL.refreshPage();

        Thread.sleep(5000);
    }
}
