package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.CommonMethods;

public class CreateNewAccount 
{
	WebDriver driver;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	
	@BeforeMethod
	public void setUp()
	{
		htmlReporter=new ExtentHtmlReporter("./Reports/BasicReport.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setReportName("Regression Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setDocumentTitle("Techflix Reporting System");
		extent.setSystemInfo("OperatingSystem", System.getProperty("os.name").toLowerCase());
		extent.setSystemInfo("Java Version", System.getProperty("java.version").toLowerCase());
		
		driver=BrowserFactory.getBrowser("chrome"); 
		driver.get(DataProviderFactory.getConfigDataProvider().getApplicationUrl());
		test=extent.createTest("SetUp=Open browser");
		test.log(Status.PASS, "Application is up and running");
	}
	
	@Test
	public void verifyLoginCredentials()
	{
		test=extent.createTest("TC1=Verify credentials");
		test.log(Status.PASS, "Application is up and running");
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		String username=DataProviderFactory.getExcelDataProvider().getUsername("UserCredentials");
		String password=DataProviderFactory.getExcelDataProvider().getPassword("UserCredentials");
		lp.loginToHomePage(username, password);
		
		test.log(Status.INFO, "Sucessfully logiggedin to homepage");
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.clickOnAccountLink();
		test.log(Status.INFO, "clicked on login link");
		System.out.println("Account End");
	}
	
	@Test
	public void faileTest()
	{
		test=extent.createTest("TC2=Failed");
		
		Assert.assertEquals("a", "b");
		test.log(Status.ERROR, "Error");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		extent.flush();
		if(result.getStatus()==ITestResult.FAILURE)
		{
			CommonMethods.getScreenshotOfPage(driver, result.getName());
			test.log(Status.FAIL, "Result is failed due to following reason");
			test.log(Status.FAIL, result.getThrowable());
			
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			
			test.log(Status.FAIL, "Result is passes due to following reason");
			test.log(Status.FAIL, result.getThrowable());
			
		}
		//driver.quit();
	}
}
