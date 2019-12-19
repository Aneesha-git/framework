package com.learnselenium.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadWriteExcel {

	public String filelocation;
	public FileInputStream fis = null;
//	public FileOutputStream fos = null;
	private XSSFWorkbook wb = null;
	private XSSFSheet sheet = null;
	// private Cell cell = null;
	Cell cell = null;
	File src = new File("D:\\TestData\\TestData1.xlsx");

	public void excel_Utilities() throws IOException {

	}

	@Test
	public void readExcel() throws IOException {
		int colNo = 0;
		String data = null;
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int noCols = sheet.getRow(0).getLastCellNum();
		System.out.println("no o f columns" + noCols);

		int rowNum = retrieveNoOfRows("test");
		for (int i = 0; i < rowNum; i++) {
			sheet = wb.getSheetAt(0);
			for (int j = 0; j < noCols; j++) {
				data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data);
				System.out.print(" ");
				colNo = j;
			}

			if (data.equals("UserName") || data.equals("password"))
				continue;
		cell=
				sheet.getRow(i).createCell(2);
		cell.setCellValue("passed");

			FileOutputStream fos = new FileOutputStream(src);
			wb.write(fos);
			System.out.println();
		}
		wb.close();
	}

	// To retrieve No Of Rows from .xls file's sheets.
	public int retrieveNoOfRows(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1) {
			return 0;
		} else
			sheet = wb.getSheetAt(sheetIndex);
		int rowCount = sheet.getLastRowNum() + 1;
		System.out.println("no  : " + rowCount);
		int rowNO = 0;
		for (int i = 0; i < rowCount; i++) {

			if (sheet.getRow(i) == null)
				continue;
			else

				rowNO++;

		}
		rowCount = rowNO;
		System.out.println("No of Rows" + rowCount);

		return rowCount;

	}

}
