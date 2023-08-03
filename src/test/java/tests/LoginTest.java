package tests;

import data.LoginExcelReader;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LunchPage;
import pages.NewHomePage;
import utilities.ExtentReports.ExtentTestManager;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginTest extends TestBase{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    NewHomePage newHomeObject;

    @Test(priority = 1 , dataProvider = "ExcelData")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login To Web")
    @Feature("Login Epic")
    @Epic("Login Epic")
    public void LoginAsCompleteUser(String userName ,String password) throws InterruptedException {

        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod(userName,password);

        newHomeObject = new NewHomePage(driver);
        newHomeObject.clickOnExistInitiative();
        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");

    }
    @DataProvider(name = "ExcelData")
    public Object[][] LoginTestData() throws IOException {
        LoginExcelReader ER = new LoginExcelReader();
        return ER.getExcelData();
    }
}
