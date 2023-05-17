package InitiativesCompleteDataFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.ExistInitiativesPage;
import tests.TestBase;

public class OpenInitiativeTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open Exist Initiative ")
    @Feature("Open Exist Initiative")
    @Epic("Uncompleted Initiative")
    public void OpenExistInitiative() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        existInitiativesObject.clickOnEditInitiativeNumber(existInitiativesObject.UICNumber);
        System.out.println(existInitiativesObject.initiativeNameTxt);

    }
}
