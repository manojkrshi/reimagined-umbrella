package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import factory.DataProviderFactory;

public class ExcelDataprovider 
{
	XSSFWorkbook wb;
	
	public ExcelDataprovider()
	{
		File src = new File("./ApplicationTestData/AppData.xlsx");
		
		try 
		{
				FileInputStream fis= new FileInputStream(src);
				try 
				{
					wb=new XSSFWorkbook(fis);
				} 
				catch (IOException e) 
				{
					System.out.println("Exception occured is "+e.getMessage());
					e.printStackTrace();
				}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Exception occured is "+e.getMessage());
			e.printStackTrace();
		} 
		
	}
	
	public String getData(int sheetIndex, int row, int cols)
	{
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(cols).getStringCellValue();
		return data;
		
	}
	
	public String getData(String sheetName, int row, int cols)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(cols).getStringCellValue();
		return data;
		
	}
	
	public String getUsername(String sheetName)
	{
		return DataProviderFactory.getExcelDataProvider().getData(sheetName, 0, 0);
	}
	
	public String getPassword(String sheetName)
	{
		return DataProviderFactory.getExcelDataProvider().getData(sheetName, 0, 1);
	}
}
