/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 15/05/2023 - Script created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalenderPage extends PageBase{
    public CalenderPage(WebDriver driver) {
        super(driver);
    }
    By monthList = By.xpath("//select[@title='Select month']");
    By yearList = By.xpath("//select[@title='Select year']");
    By calenderBody = By.xpath("//ncgr-datepicker-month[@role='grid']");

    public void selectMonthByIndex(int month){
        selectItemFromListByIndex(monthList,month);
    }

    public void selectYearByIndex(String year){
        selectItemFromListByText(yearList,year);
    }

    public void selectDay(String day){

        List<WebElement> rows = getElement(calenderBody).findElements
                (By.xpath("//div[@class='ncgr-dp-week ng-star-inserted']"));
        for(WebElement row : rows){
            List<WebElement> cols = row.findElements(By.tagName("div"));
//            System.out.println(cols.size());
            for(WebElement col : cols){
                if (col.getText().equals(day)){
                    col.click();
                    return;
                }
            }
        }
    }
}
