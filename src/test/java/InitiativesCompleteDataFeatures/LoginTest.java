package InitiativesCompleteDataFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LunchPage;
import tests.TestBase;

public class LoginTest extends TestBase {

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login To Web")
    @Feature("Login Epic")
    @Epic("Login Epic")
    public void LoginAsCompleteUser(){

        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod("1856103492","Test@12345");

        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");

    }
}
