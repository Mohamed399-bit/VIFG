package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavePopupPage extends PageBase {
    public SavePopupPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);

    }

    By saveBtn = By.xpath("//button[@type='submit']");

    public void clickOnSaveButton(){
        clickButton(saveBtn);
        waitUntilLoaderDisappear();
    }
}
