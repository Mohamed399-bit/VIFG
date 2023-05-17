package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageBase;

public class SavePopupPage extends PageBase {
    public SavePopupPage(WebDriver driver) {
        super(driver);
    }

    By saveBtn = By.xpath("//button[@class='ncgr-element ncgr-button ncgr-component ng-star-inserted']");

    public void clickOnSaveButton(){
        clickButton(saveBtn);
    }
}
