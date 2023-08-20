package testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegistrationPage;
import testbase.BaseTest;

public class TC_001_AccountRegistrationTest extends BaseTest {

	@Test(groups= {"sanity"})
	void test_Account_Registration() throws InterruptedException {
		logger.info("Account Registration Started");
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName("Ravi");
		rp.setLastName("Ravi");
		rp.setEmail(generateRandomString() + "@gmail.com");
		rp.setPassword(generateRandomAlphaNumeric());
		rp.setPrivacyPolicy();
		rp.clickContinue();
		logger.info("Account Registration ended sucessfully");
	}

	

}
