package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	@FindBy(css="a[href*='sign_in']")
	WebElement login;
	
	By title=By.cssSelector("div[class='text-center'] h2");
	
	@FindBy(css="ul.nav.navbar-nav.navbar-right")
	WebElement MenuItems;
	
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public LoginPage getLogin()
	{
		login.click();
		LoginPage LP=new LoginPage(driver);
		return LP;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement MenuDisplay()
	{
		return MenuItems;
	}

}
