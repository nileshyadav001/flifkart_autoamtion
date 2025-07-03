package com.eva.read;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.WebSocket;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Excel {
@Test
public void excelDataRead() throws IOException {
String path="C:\\Users\\niles\\OneDrive\\Desktop\\Sheet1.xlsx";

FileInputStream file=new FileInputStream(path);
XSSFWorkbook book=new XSSFWorkbook(file);
XSSFSheet sheet=book.getSheet("Sheet1");
int rowCount=sheet.getLastRowNum();
for(int i=1;i<=rowCount;i++) {
	XSSFRow row=sheet.getRow(i);
	String user=row.getCell(0).getStringCellValue();
	String pass=row.getCell(1).getStringCellValue();
	System.out.println(user+" "+pass);
}
}	
}

