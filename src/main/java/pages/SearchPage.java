package pages;

import org.openqa.selenium.*;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    By govAgencyCodeList = By.xpath("//ncgr-dropdown[@formcontrolname='govAgencyCode']");
    By initiativeIdTxt = By.xpath("//input[@formcontrolname='initiativeId']");
    By durationTxt = By.xpath("//input[@class='ncgr-inputtext ncgr-component ncgr-element ncgr-inputnumber__input']");
    By VRPProgramList = By.xpath("//ncgr-dropdown[@formcontrolname='vrpCode']");
    By UICTxt = By.xpath("//input[@formcontrolname='initiativeUIC']");
    By searchBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button ncgr-component']");
    By clearBtn= By.xpath("//ncgr-button[@styleclass='ncgr-button-danger ncgr-button-outlined']");
    By searchIcon = By.xpath("//i[@class='ncgri ncgri-search']");
    By search = By.xpath("//span[@class='ncgr-input-icon-left']");
    public void clickOnGovAgencyCodeList(){
        List<WebElement> x = getElement(govAgencyCodeList).findElements(By.tagName("div"));
        WebElement arrow = x.get(x.size()-1);
        clickOnButtonUsingJavaScript(arrow);
    }
    public void searchByInitiativeId(String id){
        setTextWebElement(initiativeIdTxt,id);
    }
    public void searchByDuration(String numberOfMonths){
        setTextWebElement(durationTxt,numberOfMonths);
    }

    public void clickOnVRPProgramList(){
        List<WebElement> x = getElement(VRPProgramList).findElements(By.tagName("div"));
        WebElement arrow = x.get(x.size()-1);
        clickOnButtonUsingJavaScript(arrow);
        scrollToBottom2();
    }

    public void searchByUIC(String UIC){
        clickOnButtonUsingJavaScript(getElement(UICTxt));
        setTextWebElement(UICTxt,UIC);
        getElement(UICTxt).sendKeys(Keys.ENTER);
    }

    public void clearUICFiled() throws InterruptedException {
        clearTextWbElement(UICTxt);
        clickOnButtonUsingJavaScript(getElement(search));
        Thread.sleep(1500);
       clickButton(searchIcon);
    }

    public void clickOnSearchButton(){
        clickOnButtonUsingJavaScript(getElement(searchBtn));
    }

    public void clickOnClearButton(){
        clickOnButtonUsingJavaScript(getElement(clearBtn));
    }
}
