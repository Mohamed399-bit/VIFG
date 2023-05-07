package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LunchPage extends PageBase{
    public LunchPage(WebDriver driver) {
        super(driver);
    }

    By comDiv = By.cssSelector("div.row.border-bottom.pb-5.justify-content-center");
    List <WebElement> divs = getElement(comDiv).findElements(By.tagName("div"));

    public void clickOnGovernmentEntity(){
        divs.get(0).click();
    }
}
