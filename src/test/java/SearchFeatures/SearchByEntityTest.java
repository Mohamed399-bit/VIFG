package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;

public class SearchByEntityTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    OwnerEntitySearchPage ownerEntitySearchObject;

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Entity Name")
    @Feature("Search")
    @Epic("Search")
    public void SearchByEntity() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.getDataForFirstInitiative();

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();
        //homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        searchObject.clickOnGovAgencyCodeList();

        ownerEntitySearchObject = new OwnerEntitySearchPage(driver);
        ownerEntitySearchObject.selectEntityName(existInitiativesObject.govOwnerTxt);
        searchObject.clickOnSearchButton2();

        existInitiativesObject.VerifyThatSearchByEntityNameIsTrue(existInitiativesObject.govOwnerTxt);
        searchObject.clickOnClearButton();

        Thread.sleep(3000);
    }
}
