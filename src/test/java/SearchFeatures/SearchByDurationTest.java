package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.SetURL;

public class SearchByDurationTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Duration")
    @Feature("Search")
    @Epic("Search")
    public void searchByDuration() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.getDataForFirstInitiative();

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.clickOnClearButton();
        searchObject.searchByDuration(existInitiativesObject.durationTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByDurationIsTrue(existInitiativesObject.durationTxt);
        Thread.sleep(2000);
        //searchObject.clickOnClearButton();
        SetURL.refreshPage();

        Thread.sleep(3000);
    }
}
