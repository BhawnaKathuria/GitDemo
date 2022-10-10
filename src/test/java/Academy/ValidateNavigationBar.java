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
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base

{
	public static Logger log= LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = initialization();
		log.info("driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("Navigation to home page");
	}
	
	@Test
	public void VerifyNavigationBar() throws IOException
	{
		
		LandingPage LanP=new LandingPage(driver);
		org.testng.Assert.assertTrue(LanP.MenuDisplay().isDisplayed());
		log.info("Verification of Menu display");
	}
	
	@AfterTest
	public void Teardown()
	{
		driver.close();
	}

}
