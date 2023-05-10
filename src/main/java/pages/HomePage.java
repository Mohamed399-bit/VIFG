package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By divUserName = By.cssSelector("div.d-flex.justify-content-between.align-items-center");
    By existIntLabel = By.xpath("//ncgr-menubar-sub[@class='ncgr-element']");

    public void verifyThatUserLoggedIn(String name){
        Assert.assertTrue(getElement(divUserName).isDisplayed());
        Assert.assertEquals(getElement(existIntLabel).getText(),name);
        System.out.println("div is display : " + getElement(divUserName).isDisplayed());
        System.out.println(getElement(existIntLabel).getText());
    }
}
