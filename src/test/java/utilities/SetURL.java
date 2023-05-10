/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 08/05/2023 - Script created.
 */

package utilities;

import tests.TestBase;

public class SetURL extends TestBase {

    public static String VIFGUrlTest = "http://10.14.9.35:4250/";
    public static void lunchVIFG() {
        driver.navigate().to(VIFGUrlTest);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

}
