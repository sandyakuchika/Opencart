package testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseTest;

public class TC_002_LoginTest extends BaseTest {

	@Test(groups= {"regression"})
	public void test_login() {
		
		logger.info("TC_002_LoginTest Started");
		try {
		HomePage hp=  new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp=new LoginPage(driver);
		lp.setEmail("sandyakuchika@Gamil.com");
		lp.setPassword("Kuchika123#");
		lp.clickLoginButton();
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage=map.isMyAccountPageExists();
		Assert.assertEquals(targetpage, false);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("TC_002_LoginTest Started");
		
	}
}
