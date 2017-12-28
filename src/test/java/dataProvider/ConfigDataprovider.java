package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataprovider 
{
	Properties prop;

	public ConfigDataprovider()
	{
		File src=new File("./Configuration/config.properties");
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			try 
			{
				prop.load(fis);
			} 
			catch (IOException e) 
			{
				System.out.println("Error in properties "+e.getMessage());
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error in File "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String getApplicationUrl()
	{
		return prop.getProperty("url");
	}
	
	public String getChromePath()
	{
		return prop.getProperty("chromePath");
	}
	
	public String getFirefoxPath()
	{
		return prop.getProperty("fireFoxPath");
	}
	
	public String getIePath()
	{
		return prop.getProperty("iePath");
	}

}
