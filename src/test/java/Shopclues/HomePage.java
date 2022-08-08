package Shopclues;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.search;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.manage().window().maximize();

	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username,String text) throws InterruptedException 
	{

		//one is inheritance
       
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));

		LandingPage l=new LandingPage(driver);
		l.getLogin();
		LoginPage lp=l.getLogin(); //driver.findElement(By.css()
		   Thread.sleep(6000);
		lp.getEmail(Username);
		//lp.getEmail().sendKeys(Username);
	    lp.forgotPassword();

		Reporter.log("Wrong username has been entered :"+text);

		
		}
	
@Test(dataProvider="getsearch")
	
	public void basesearch(String searchkey1) throws InterruptedException 
	{

		//one is inheritance
       
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));

		LandingPage l=new LandingPage(driver);
		l.getseach();
		
		search sp=l.getseach();
		
    sp.searchkeyword(searchkey1);	
    sp.searchbtn();
    sp.searchresultclick();
		}


	@AfterTest
	public void teardown()
	{
		
		driver.quit();
	
		
	}

	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][2];
		//0th row
		data[0][0]="restricteduser1@qw.com";
		data[0][1]="Restrcited User";
		//1st row
		data[1][0]="restricteduser2@qw.com";
		data[1][1]= "restricted user";
		
		return data;
		
		
		
		
		
		
	}
	
	@DataProvider
	public Object[][] getsearch()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[4][1];
		//0th row
		data[0][0]="NIKE SHOES";
		//1st row
		data[1][0]="WATCH";
		data[2][0]="APPLE PHONE";
		data[3][0]="HEADPHONE";
	
		
		return data;
		
		
		
		
		
		
	}
}
