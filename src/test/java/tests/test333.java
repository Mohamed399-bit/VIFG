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

        int randomNum = ThreadLocalRandom.current().nextInt(0, 4 + 1);
        System.out.println(randomNum);

    }
}
