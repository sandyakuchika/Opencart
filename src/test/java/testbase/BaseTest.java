package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle resourceBundle;

	@BeforeClass(groups= {"sanity", "regression"})
	@Parameters("browser")
	public void setUp(String br) {
		logger = LogManager.getLogger(this.getClass());
//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		resourceBundle=ResourceBundle.getBundle("config");
		driver.get(resourceBundle.getString("appUrl"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"sanity", "regression"})
	public void tearDown() {
		driver.quit();
	}

	public String generateRandomString() {
		String randomString = RandomStringUtils.randomAlphabetic(9);
		return randomString;
	}

	public String generateRandomNumber() {
		String randomNum = RandomStringUtils.randomNumeric(3);
		return randomNum;
	}

	public String generateRandomAlphaNumeric() {
		String randomAlphaNum = RandomStringUtils.randomAlphanumeric(7);
		return randomAlphaNum;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	

}
