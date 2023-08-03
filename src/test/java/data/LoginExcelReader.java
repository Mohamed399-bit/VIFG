/*
 * Copyright (c) buseet 2021.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden  28/10/2021  - Script created.
 */
package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tests.TestBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginExcelReader {

	static FileInputStream fis = null ;
	XSSFSheet sheet;
	public  FileInputStream getFileInputStream()
	{
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/LoginTestData.xlsx";
		File  srcFile  = new File(filePath);

		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test data file not found. terminating process!! : Check file path of TestData");
			System.exit(0);
		}
		return fis ; 
	}
	public Object [][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		if (TestBase.url.contains("http://10.14.9.35:4250/")){
			sheet = wb.getSheetAt(0);
		}else if (TestBase.url.contains("https://vrpinitiativespp.etimad.sa/")){
		    sheet = wb.getSheetAt(1);
	}

		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 2 ;

		String [] [] arrayExcelData = new String [TotalNumberOfRows][TotalNumberOfCols];
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				System.out.println(row.getCell(j).toString());
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
