/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 10/05/2023 - Script created.
 */
package tests;

import org.testng.annotations.Test;
import utilities.DataBaseHelper;

public class testDataBase {

    @Test
    public void getData(){
        DataBaseHelper.getValuesFromDataBase();
    }
}
