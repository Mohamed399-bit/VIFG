package tests;

import org.testng.annotations.Test;
import utilities.DataBaseHelper;

public class testDataBase {

    @Test
    public void getData(){
        DataBaseHelper.getValuesFromDataBase();
    }
}
