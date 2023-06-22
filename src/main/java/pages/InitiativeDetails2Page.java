package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InitiativeDetails2Page extends PageBase{
    public InitiativeDetails2Page(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 45);
    }

    By completeDataBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-info ncgr-button ncgr-component']");
    By tabsDiv = By.xpath("//ul[@class='ncgr-tabview__nav']");

    By backBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-outlined ncgr-button-gray-75 ncgr-button ncgr-component']");

    List<WebElement> tabs = getElement(tabsDiv).findElements(By.tagName("li"));

    public void clickOnCompleteData() throws InterruptedException {
        waitUntilLoaderDisappear();
        Thread.sleep(1500);
        scrollToBottom();
        Thread.sleep(1500);
        scrollToBottom();
        Thread.sleep(1500);
        scrollToBottom();
        Thread.sleep(1500);
        clickButton(completeDataBtn);
    }

    public void clickOnPreviousActions(){
        waitUntilLoaderDisappear();
        scrollToBottom3();
        clickOnButtonUsingJavaScript(tabs.get(1).findElement(By.tagName("a")));
        scrollToBottom();
    }

    public void clickOnBackButton(){
        scrollToBottom();
        clickOnButtonUsingJavaScript(getElement(backBtn));
    }
}
