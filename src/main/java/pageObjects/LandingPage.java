package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {

	public WebDriver driver;
	
	By closemodel = By.xpath("//a[@id='a_close_id']");


	By singin_2 = By.xpath("/a[@id='show_loginpop']");
	By search = By.xpath("//input[@id='autocomplete']");
	By searchbtn = By.xpath("//a[normalize-space()='Search']");
	//a[normalize-space()='Search']
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public LoginPage getLogin() {


		//driver.findElement(closemodel).click();

		//driver.findElement(singin_2).click();
		LoginPage lp = new LoginPage(driver);
		return lp;

	}

	public search getseach() {


//		//driver.findElement(closemodel).click();
//		driver.findElement(signin).click();
//		//driver.findElement(singin_2).click();
		search s = new search(driver);
		return s;

	}


}
