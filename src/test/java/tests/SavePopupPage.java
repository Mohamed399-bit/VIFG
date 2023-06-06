package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBase;

import java.time.Duration;

public class SavePopupPage extends PageBase {
    public SavePopupPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);

    }

    By saveBtn = By.xpath("//button[@class='ncgr-element ncgr-button ncgr-component ng-star-inserted']");

    public void clickOnSaveButton(){
        clickButton(saveBtn);
        waitUntilLoaderDisappear();
    }
}
