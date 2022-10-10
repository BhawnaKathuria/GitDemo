package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class TitleValidation extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = initialization();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home Page");
	}
	
	@Test
	public void ValidationOftitleHomePage() throws IOException
	{
		LandingPage LanP=new LandingPage(driver);
		Assert.assertEquals(LanP.getTitle().getText(),"FEATURED COURSES88");
		log.info("Scuusessfully verification of message");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Driver instance will get closed");
	}

}
