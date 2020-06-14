package org.iit.mmp.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {


	//variables created for excel workbook. These are global.
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;



	public static String generateRandom(int n,int range)
	{
		String str = "";
		for(int j = 0 ; j < 5;j++)
		{
			str = str+ 9;	 
		}
		System.out.println(str);

		return str+new Random().nextInt(range);
	}
	public static String getFutureDate(int days,String pattern)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);

		Date d = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(d);
		return date;
	}
	public static String getFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);

		Date d = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(d);
		return date;
	}

	public static String[][] readXls(String filePath)
	{
		String[][] str = new String[10][10];
		return str;
	}
	public static String[][] readXlsx(String filePath)
	{
		String[][] str = new String[10][10];
		return str;
	}





	//READING SPREADSHEET
	public static void ExcelUtils(String excelPath, String sheetName) {
		try {
			//creating a reference variable for workbook and sheet.
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Row count from excel sheet
	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getLastRowNum()+1;
			//rowCount= sheet.getPhysicalNumberOfRows();
			System.out.println("No of Rows: " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}

	// Total number of columns 
	public static int getcolCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("No of Columns: " + colCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}

	// Read cell data 
	public static String getCellDataString(int rowCount, int colCount) {
		String cellData = null;
		try {

			cellData = sheet.getRow(rowCount).getCell(colCount).getStringCellValue();
			//System.out.println("Using Excel util"+cellData);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

	//To get cell data number
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}








