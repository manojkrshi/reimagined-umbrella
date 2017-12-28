package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.LoginPage;

public class VerifyLoging 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=BrowserFactory.getBrowser("chrome"); 
		driver.get(DataProviderFactory.getConfigDataProvider().getApplicationUrl());
	}
	
	@Test
	public void verifyLoginCredentials()
	{
		
		LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		String username=DataProviderFactory.getExcelDataProvider().getData("UserCredentials", 0, 0);
		String password=DataProviderFactory.getExcelDataProvider().getData("UserCredentials", 0, 1);
		lp.loginToHomePage(username, password);
		System.out.println("End");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
