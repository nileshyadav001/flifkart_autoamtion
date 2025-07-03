package com.eva.read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadToExcelData {
public static void main(String[] args) throws IOException {
	InputStream  fis=new FileInputStream(
			System.getProperty("user.dir")+"\\unite.xlsx");
	Workbook wbook=new XSSFWorkbook(fis);
	Sheet sheet=wbook.getSheet("Sheet1");
	//for(int i=0;i<sheet.getLastRowNum();i++) {
	Row rowObj=sheet.getRow(3);
	//System.out.print(i+" row data : ");
	//for(int j=0;j<rowObj.getLastCellNum();j++) {
		Cell cellObj=rowObj.getCell(0);
		String getRowCellData=cellObj.getStringCellValue();
		System.out.print(getRowCellData+" ");
	//}
	//System.out.println();
	//}
	
}
}
