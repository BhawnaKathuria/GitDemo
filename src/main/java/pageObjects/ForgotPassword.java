package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword {
	
	@FindBy(id="user_email")
	WebElement EmailID;
	
	@FindBy(css="input[value='Send Me Instruction']")
	WebElement instructionLink;
	
	public WebElement getEmail()
	{
		return EmailID;
	}

	public WebElement getLink()
	{
		return instructionLink;
	}
}
