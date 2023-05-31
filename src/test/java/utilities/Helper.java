/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 08/05/2023 - Script created.
 */
package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    //Method to take screenshot the test case fail
    public static void captureScreenShot(WebDriver driver, String screenshotName) {
        Path dest = Paths.get("./Screenshots", screenshotName + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();

        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    //Method to generate random text.
    public static String generateRandomName(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public static String[] generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static String generateRandomWords2(int numberOfWords2)
    {
        String x[] = Helper.generateRandomWords(numberOfWords2);
        StringBuffer result = new StringBuffer();
        for (int i = 0 ; i <x.length;i++) {
            result.append( x[i] +" " );
        }
        return result.toString();
    }

    //Method to generate random Number.
    public static String generateRandomNumber(int length) {
        char[] chars = "123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    //Method to get Today date
    public static String getSystemDate() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        // Print the Date
        System.out.println(date1);
        return date1;
    }

    public static String getTodayName() {
        DateFormat dateFormat = new SimpleDateFormat("EEE");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        System.out.println(date1);
        return date1;
    }

    //Method to get Current day
    public static String getTodayDay() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        System.out.println(date1);
        return date1;
    }

    //Method to get Current Month
    public static String getCurrentMonth() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MMM");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        // Print the Date
        System.out.println(date1);
        return date1;
    }

    public static void print(String msg, Object... args) {
        try {
            java.io.PrintStream ps = new java.io.PrintStream(System.out, true, "UTF-8");
            ps.println(String.format(msg, args));
        } catch (UnsupportedEncodingException error) {
            System.err.println(error);
            System.exit(0);
        }
    }

    public static String getCurrentDayName() {

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String day = new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());
        System.out.println(new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()));
        return day;
    }

    public static int generateRandomNumber2(int min , int max){

        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

}
