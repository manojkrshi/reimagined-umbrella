package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class HomePage 
{
	WebDriver driver;
	 public HomePage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	
	@FindBy(xpath="//a[@title='Accounts']") WebElement accountLink;
	@FindBy(xpath="//a[text()='Lightning Experience']") WebElement LightningExperienceLink;
	
	
	public void clickOnAccountLink()
	{
		LightningExperienceLink.click();
			//accountLink.click();
			
	}
	
}
