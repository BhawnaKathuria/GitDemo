package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	public static Logger log= LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = initialization();
		
	}
	
	@Test(dataProvider="getdata")
	public void BasePageInitialization(String Username, String Password) throws IOException, InterruptedException 
	{
		
		driver.get(prop.getProperty("url"));
		//driver = initialization();
		//driver.get(prop.getProperty("url"));
		LandingPage LanP=new LandingPage(driver);
		Thread.sleep(1000);
		LoginPage LP = LanP.getLogin();
		Thread.sleep(1000);
		//LoginPage LP=new LoginPage(driver);
		log.info("Enter user Name");
		LP.Username().sendKeys(Username);
		log.info("Enter Password");
		LP.Password().sendKeys(Password);
		Thread.sleep(2000);
		LP.Login().click();
		ForgotPassword fp= LP.ForgotPasswd();
		fp.getEmail().sendKeys("abc@gmail.com");
		fp.getLink().click();
		log.info("Click on Login is done");
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="Restricted@gmail.com";
		data[0][1]="12345";
		
		data[1][0]="Nonrestricted@gmail.com";
		data[1][1]="test";
		
		return data;
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
