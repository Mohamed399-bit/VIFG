package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.SetURL;

public class SearchByUICTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By UIC")
    @Feature("Search")
    @Epic("Search")
    public void searchByUIC() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.getDataForFirstInitiative();

        searchObject = new SearchPage(driver);
        searchObject.searchByUIC(existInitiativesObject.UICNumber);

        existInitiativesObject.VerifyThatSearchByUICIsTrue(existInitiativesObject.UICNumber);
        //searchObject.clearUICFiled();
        SetURL.refreshPage();

        Thread.sleep(3000);
    }
}
