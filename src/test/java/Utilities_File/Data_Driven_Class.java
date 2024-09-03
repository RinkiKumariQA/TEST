package Utilities_File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_Driven_Class {
	
  public static XSSFWorkbook wb;
  public static XSSFSheet ws;
  public static XSSFRow wr;
  public static XSSFCell wc;
  public static FileInputStream fn;
  
  public static String getCellvalue(String filename,String sheetname,int row,int cell) throws Exception
  {
	  fn=new FileInputStream(filename);
	  wb=new XSSFWorkbook(fn);
	  ws=wb.getSheet(sheetname);
	  wc=wb.getSheet(sheetname).getRow(row).getCell(cell);
	  wb.close();
	  return wc.getStringCellValue();
  }
	  public static int getRowCount(String filename,String sheetname) throws Exception
	  {
	        fn=new FileInputStream(filename);
	        wb=new XSSFWorkbook(fn);
	        ws=wb.getSheet(sheetname);
	        int totalRow=ws.getLastRowNum()+1;
	        wb.close();
	        return totalRow;
	  }
	  
	  public static int getColCunt(String filename,String sheetname) throws Exception
	  {
	 
		  fn=new FileInputStream(filename);
	        wb=new XSSFWorkbook(fn);
	        ws=wb.getSheet(sheetname);
	        int totalCol=ws.getRow(0).getLastCellNum();
	        wb.close();
	        return totalCol;
	  }
}