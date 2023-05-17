package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VRPProgramListPage extends PageBase{
    public VRPProgramListPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }
    By programList = By.id("ncgr_id_2_list");
    List<WebElement> items = getElement(programList).findElements(By.tagName("li"));

    public void selectProgramName(String program){

        for (WebElement ele : items){
            if (ele.getText().equals(program)){
                clickOnButtonUsingJavaScript(ele);
                break;
            }
        }
    }
}
