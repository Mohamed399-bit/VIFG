package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.ExistInitiativesPage;

public class OpenInitiativeTest extends TestBase{

    ExistInitiativesPage existInitiativesObject;
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open Exist Initiative ")
    @Feature("Open Exist Initiative")
    @Epic("Exist Initiative")
    public void OpenExistInitiative() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        //existInitiativesObject.clickOnCompletedInitiatives();
        //existInitiativesObject.clickOnEditInitiativeNumber(existInitiativesObject.UICNumber);
        existInitiativesObject.clickOnEditInitiativeNumber("1-16-095-1781");
        System.out.println(existInitiativesObject.initiativeNameTxt);

    }
}
