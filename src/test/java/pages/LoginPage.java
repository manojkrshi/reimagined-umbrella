package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement userNameTextBox;
	@FindBy(xpath="//input[@name='pw']") WebElement passwordTextBox;
	@FindBy(xpath="//input[@name='Login']") WebElement LoginButton;
	@FindBy(xpath="//div[@class='bBottom']") WebElement navigationBar;
	
	
	public void loginToHomePage(String username, String password)
	{
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		LoginButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(navigationBar));
	}
	
	public String getHomepageTitle()
	{
		return driver.getTitle();
	}
}
