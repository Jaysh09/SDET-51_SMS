package java.com.SMS.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	public String readExcelDAta(String sheetName, int rowNo, int CellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
		Sheet sh =wb.getSheet(sheetName);
		Row row = sh.getRow(rowNo);
		Cell cell = row.getCell(CellNo);
		String data = cell.toString();
		return data;
	}
	
  public int getrowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
  Workbook wb = WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
	Sheet sh =wb.getSheet(sheetName);
	int row = sh.getLastRowNum();
	return row;
}
  
  public void writeDataInExcelsheet(String sheetname, int rowno, int cellno , String value) throws EncryptedDocumentException, FileNotFoundException, IOException
  {
	  Workbook wb = WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
		Sheet sh =wb.getSheet(sheetname);
		Row row = sh.createRow(rowno);
		Cell cell = row.createCell(cellno);
		 cell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelPath);
		wb.write(fos);
		wb.close();
  }
  
  public HashMap<String, String> getMultipleDataFromExcel(String sheetname, int keyColumn, int valueColumn) throws EncryptedDocumentException, IOException 
  {
	  FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
	  
	  Workbook wb = WorkbookFactory.create(fis);
	  
	  Sheet sh = wb.getSheet(sheetname);
	  int count = sh.getLastRowNum();
	  HashMap<String,String>map = new HashMap<String,String>(); //emptydata
		
	  for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
	}
  
  public Object[][] getMultipleSetOfData(String sheetname) throws Throwable 
  {
	  FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sh = wb.getSheet(sheetname);
	  int LastRow = sh.getLastRowNum();
	  int LastCell = sh.getRow(0).getLastCellNum();
	  
	  Object[][] obj = new Object[LastRow+1][LastCell];
	  
	  for(int i=0; i<=LastRow; i++)
	  {
		  for(int j=0; j<LastCell; j++)
		  {
			  obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
		  }
	  }
	return obj;
	  
  }
	
	  
  }



