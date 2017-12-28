package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.out.println("driverpath"+DataProviderFactory.getConfigDataProvider().getChromePath());
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfigDataProvider().getChromePath());
			//System.setProperty("webdriver.chrome.driver","/home/manoj/Documents/Selenium/Drivers/chromedriver");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfigDataProvider().getFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfigDataProvider().getIePath());
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static WebDriver closeBrowser(WebDriver driver)
	{
		driver.quit();
		return driver;
		
	}
}
