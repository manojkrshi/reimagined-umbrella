package factory;

import dataProvider.ConfigDataprovider;
import dataProvider.ExcelDataprovider;

public class DataProviderFactory 
{
	public static ConfigDataprovider getConfigDataProvider()
	{
		ConfigDataprovider config=new ConfigDataprovider();
		return config;
		
	}
	
	public static ExcelDataprovider getExcelDataProvider()
	{
		ExcelDataprovider config=new ExcelDataprovider();
		return config;
		
	}
	
}
