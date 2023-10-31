package Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.ExcelUtil;
import Utilities.ReadConfig;

public class DataDrivenTestCase extends BaseTest{

	@Test(dataProvider="TestData")
	public void loginDDTestcase(String user,String pwd) throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.emailenter(user);
		logger.info("user name provided");
		lp.passwordenter(pwd);
		logger.info("password provided");
		lp.loginbutton();
		
		if(isAlertpresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver,"loginDDTestcase");
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			HomePage homePage = new HomePage(driver);

			homePage.clicklogoutLink();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		}
	
	public boolean isAlertpresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	 @DataProvider(name = "TestData")
	 	public Object[][] dataProviderMethod() {
	 		Object[][] testObjArray=null;
	 		try {
	 		ReadConfig readconfig=new ReadConfig();
	 		String file=readconfig.getExcelpath();
	 		String sheetName=readconfig.getSheetname();
	 		
	 	
	 			testObjArray=ExcelUtil.getTableArray(file, sheetName);
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		return testObjArray;
	 	}

}
