package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="user_email")
	WebElement Userid;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(css="input[value='Log In']")
	WebElement Login;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	WebElement FgotPass;
	
	public WebElement Username()
	{
		return Userid;
	}
	
	public WebElement Password()
	{
		return Password;
	}
	public WebElement Login()
	{
		return Login;
	}
	public ForgotPassword ForgotPasswd()
	{
		 FgotPass.click();
		 return new ForgotPassword();
	}
}
