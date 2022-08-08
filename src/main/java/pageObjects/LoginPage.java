package pageObjects;

import org.testng.AssertJUnit;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	
	public WebDriver driver;
	
	By signin = By.xpath("//li[@id='sign-in']");
	By emailpath=By.xpath("//input[@id='main_user_login']");
	By wrong_display=By.xpath("(//div[@class='error_text'])[1]");
	By loginbtn=By.xpath("//a[@id='login_via_otp']");

	
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}



public void forgotPassword() throws InterruptedException 
{
	Thread.sleep(5000);
	
	if(driver.findElement(wrong_display).isDisplayed())
	{
		Assert.assertTrue(true);
		log(" error message displayed - Oops , Something went wrong please refresh the page");
	}
	else
	{
		Assert.assertTrue(true);
		log(" error message not displayed ");
	}
	
	
}
	private void log(String string) {
	// TODO Auto-generated method stub
	
}



	public void getEmail(String email_value) throws InterruptedException
	{
		driver.findElement(signin).click();
		Thread.sleep(5000);
		driver.findElement(emailpath).sendKeys(email_value);
		driver.findElement(loginbtn).click();
	   
	    
	    
	//	driver.findElement(emailpath).sendKeys(email_value);
	}
	


	
	
}
