package InitiativesCompleteDataFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.CompleteInitiativeDetailsPage;
import pages.ExistInitiativesPage;
import tests.TestBase;
import utilities.SetURL;

public class DisplayCompletedInitiativeDataTest extends TestBase {
    ExistInitiativesPage existInitiativesObject;
    CompleteInitiativeDetailsPage completeInitiativeDetailsObject;
    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Display Completed Initiative Data")
    @Feature("Complete Data For Uncompleted Initiative")
    @Epic("Uncompleted Initiative")
    public void DisplayCompletedInitiativeData() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        existInitiativesObject.scrollDown();
        existInitiativesObject.clickOnViewInitiativeNumber(existInitiativesObject.UICNumber);

        Thread.sleep(2000);

        completeInitiativeDetailsObject = new CompleteInitiativeDetailsPage(driver);
        completeInitiativeDetailsObject.VerifyThatInitiativeNameIsDisplay();
        completeInitiativeDetailsObject.VerifyThatInitiativeStatusDataIsDisplay();
        completeInitiativeDetailsObject.VerifyThatUICIsDisplay();
        completeInitiativeDetailsObject.VerifyThatInitiativeIdIsDisplay();
        completeInitiativeDetailsObject.VerifyThatProgramNameIsDisplay();
        completeInitiativeDetailsObject.VerifyThatStrategicObjectiveIsDisplay();
        completeInitiativeDetailsObject.VerifyThatOwnerEntityIsDisplay();
        completeInitiativeDetailsObject.VerifyThatOwnerIdIsDisplay();
        completeInitiativeDetailsObject.VerifyThatInitiativeFundingStatusIsDisplay();
        completeInitiativeDetailsObject.VerifyThatInitiativeClassificationIsDisplay();
        completeInitiativeDetailsObject.VerifyThatApprovedCostsIsDisplay();
        completeInitiativeDetailsObject.VerifyThatInitiativeAchievedSavingsIsDisplay();
        completeInitiativeDetailsObject.VerifyThatInitiativeDescriptionIsDisplay();
        completeInitiativeDetailsObject.VerifyThatStartDateIsDisplay();
        completeInitiativeDetailsObject.VerifyThatDurationIsDisplay();
        completeInitiativeDetailsObject.VerifyThatEndDateIsDisplay();
        completeInitiativeDetailsObject.clickOnBackButton();

        Thread.sleep(1500);
        SetURL.refreshPage();

        Thread.sleep(2000);

    }
}
