package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PreviousProceduresPage extends PageBase{
    public PreviousProceduresPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 45);
    }

    By previousTxt = By.xpath("//h4[@class='mb-4 pb-2']");

    public void verifyThatPreviousProceduresPageDisplay(String labelName) throws InterruptedException {
        waitUntilLoaderDisappear();
        scrollToBottom2();
        Thread.sleep(1500);
        Assert.assertEquals(getTxt(previousTxt), labelName);
        System.out.println("Previous Procedures label is : " + getTxt(previousTxt));
    }
}
