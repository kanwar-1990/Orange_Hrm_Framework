package com.PrangeHrm.qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private static final String WorkBookName = "./src/main/java/com/OrangeHrm/qa/TestData/Orange_Hrm_testData.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getexcelTestData(String Sheetname) {
		Object data[][]=null;

		try {
			FileInputStream ip = new FileInputStream(WorkBookName);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(Sheetname);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
