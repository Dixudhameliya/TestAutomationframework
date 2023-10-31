package Testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(CustomListener.class)
public class TestWithPOM  extends BaseTest {
	
	@Test
	public void LoginTest() throws IOException {
		
		driver.get(baseURL);
    	logger.info("URL is Opened");
		LoginPage login=new LoginPage(driver);
		login.emailenter(username);
		logger.info("Entered Username");
		login.passwordenter(password);
		logger.info("Entered Password");
		login.loginbutton();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test pass");
		}else {
			captureScreen(driver,"LoginTest");
			Assert.assertFalse(false);
			logger.info("Login test fail");
		}
		
		
		
	}
		

	}


