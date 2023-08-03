package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewHomePage extends PageBase{
    public NewHomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
        jse = (JavascriptExecutor) driver;
    }

    By initiativeDiv = By.xpath("//div[@class='ncgr-card__body']");

    public void clickOnExistInitiative() throws InterruptedException {
        waitUntilLoaderDisappear();
        Thread.sleep(1500);
       // clickButton(initiativeDiv);
        clickOnButtonUsingJavaScript(getElement(initiativeDiv));
    }
}
