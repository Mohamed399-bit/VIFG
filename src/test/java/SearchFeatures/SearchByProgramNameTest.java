package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;

public class SearchByProgramNameTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    VRPProgramListPage vrpProgramListObject;

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Program Name")
    @Feature("Search")
    @Epic("Search")
    public void searchByProgramName() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.getDataForFirstInitiative();

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();

        searchObject = new SearchPage(driver);
        searchObject.clickOnVRPProgramList();

        vrpProgramListObject = new VRPProgramListPage(driver);
        vrpProgramListObject.selectProgramName(existInitiativesObject.programNameTxt);
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByProgramNameIsTrue(existInitiativesObject.programNameTxt);

        Thread.sleep(3000);
    }
}
