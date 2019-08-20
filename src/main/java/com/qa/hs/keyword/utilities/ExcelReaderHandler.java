package com.qa.hs.keyword.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;

//import io.qameta.allure.Step;
//import com.qa.hs.keyword.base.Step;

/**
 * @Name: Selenium Hybrid Framework
 * @author Akash Rastogi
 * @Date : 13-Aug-2019
 */

public class ExcelReaderHandler {

public static Workbook book;
public static Sheet sheet;


public ExcelReaderHandler(String xlpath) {
	
	FileInputStream file = null;
	try {
		file = new FileInputStream(xlpath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

//@Step("get the row count for the scenario excelSheet : {0}")
	public int getRowCount(String sheetName) {
		sheet = book.getSheet(sheetName);
		int intRowCount = sheet.getLastRowNum();
		return intRowCount;
	}	
	
//@Step("get the specific cell data from the scenario excelSheet: {0} for row: {1} and col: {2}")
    public String getCellData(String sheetName, int rowNum, int colNum){
    	sheet = book.getSheet(sheetName);
    	String strValue = sheet.getRow(rowNum).getCell(colNum).toString().trim();
    	return strValue;
	
    }
}
