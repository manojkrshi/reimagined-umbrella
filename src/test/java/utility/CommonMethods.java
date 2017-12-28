package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonMethods 
{
		
	public static void getScreenshotOfPage(WebDriver driver, String methodName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			String destination="./Screenshots/"+methodName+"_"+System.currentTimeMillis()+".jpg";
			FileUtils.copyFile(srcFile, new File(destination));
		} 
		catch (IOException e1) {
			
			System.out.println("Error in taking screenshot"+e1.getMessage());
		}
	}
}
