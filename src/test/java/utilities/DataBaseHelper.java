/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 10/05/2023 - Script created.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseHelper {

    public static String userName;
    public static String name;
    public static void getValuesFromDataBase ()
    {
        String dbURL = "jdbc:sqlserver://10.14.10.61\\ETIMINTG:50025;databaseName=NCGR_VIFG_Test;encrypt=true;trustServerCertificate=true";
        String user = "etites00";
        String pass = "Mt!sqN5W$Z";

        try (
                Connection connection =
                        DriverManager.getConnection(dbURL, user, pass))
        {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT top 1 UserName , Name  \n" +
                    "from NCGRUsers n\n" +
                    "order by IdmUserId;");
            while (resultSet.next()) {
                userName = resultSet.getString(1);
                name = resultSet.getString(2);
            }

        } catch (Exception ex) {
            System.out.println("Connection failure.");
            ex.printStackTrace();
        }
        System.out.println(userName);
        System.out.println(name);

    }
}
