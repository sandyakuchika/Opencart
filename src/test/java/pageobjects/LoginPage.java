package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//*[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//*[@id='form-login']/button")
	WebElement loginButton;
	
	public void setEmail(String e)
	{
		email.sendKeys(e);
	}
	
	public void setPassword(String p)
	{
		password.sendKeys(p);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	

}
