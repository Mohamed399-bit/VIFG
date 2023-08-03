package tests;

import org.testng.annotations.Test;
import pages.ExistInitiativesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LunchPage;
import utilities.Helper;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class test333{

    LunchPage lunchObject;
    LoginPage loginObject;
    HomePage homeObject;
    ExistInitiativesPage  existInitiativesObject;


    @Test()
    public void clickdsdsd() throws InterruptedException {

//        int randomNum = ThreadLocalRandom.current().nextInt(2019, 2020 + 1);
//        System.out.println(randomNum);

        System.out.println(System.getProperty("user.dir")+ "\\src\\test\\java\\config\\config.properties");

    }
}
