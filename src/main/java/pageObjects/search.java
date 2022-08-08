package pageObjects;

import org.testng.AssertJUnit;
import org.testng.Reporter;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class search {

	
	public WebDriver driver;
	
	By searchfield=By.xpath("//input[@id='autocomplete']");
	By searchbtn=By.xpath("//a[normalize-space()='Search']");
	By searchresultcount=By.xpath("//i[@id='instdcnt']");
	By firstsearchresult=By.xpath("(//div[@class='column col3 search_blocks'])[1]");
	By firstProductName=By.xpath("//h1[@itemprop='name']");
	By firstProductPrice= By.xpath("//span[@class='f_price']");
	
	public search(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


//	public void searchkeyword(String searchkey1)
////	{
////		driver.findElement(searchfield).sendKeys(searchkey1);
////	}
	

	
	public void searchbtn() throws InterruptedException
	{
		driver.findElement(searchbtn).click();
		Thread.sleep(5000);
		
	}


	public void searchkeyword(String data) {
		// TODO Auto-generated method stub
		driver.findElement(searchfield).sendKeys(data);
	}

	public void searchresultclick() throws InterruptedException {
		// TODO Auto-generated method stub
		
	   String Count_result = driver.findElement(searchresultcount).getText();
	   int number = Integer.parseInt(Count_result);
	   if(number<0)
	   {
		   Reporter.log(number+" Here is the search result count");
	   }
	   else
	   {
		   Reporter.log(" Incoorect Log");
	   }
	   Thread.sleep(5000);
	   driver.findElement(firstsearchresult).click();
	   
	   Thread.sleep(5000);
	   Set<String> windows1 = driver.getWindowHandles(); 
		System.out.println(windows1); 
		for (String window : windows1) 
		{ 
		driver.switchTo().window(window); 
		}
		  String title = driver.getTitle();
		  System.out.println(title);
	   String first_ProductName = driver.findElement(firstProductName).getText();
	   Reporter.log(first_ProductName+" Here is the search product name");
	   System.out.println(first_ProductName);
	   String first_ProductPrice = driver.findElement(firstProductPrice).getText();
	   Reporter.log(first_ProductPrice+" Here is the search product name");
	   System.out.println(first_ProductPrice);
	}
	
}
