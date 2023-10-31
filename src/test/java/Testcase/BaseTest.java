package Testcase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utilities.ExcelUtil;
import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
    
	 @Parameters("browser")
     @BeforeClass
	public void setup(String br,ITestResult result)  {
			
			
			logger = LogManager.getLogger(BaseTest.class);
			
			if(br.equals("chrome"))
			{WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}else if(br.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if(br.equals("ie")){
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			driver.get(baseURL);
		}
    
		
	
    @AfterClass
	public void teardown() {
		driver.close();
		driver.quit();
		System.out.println("TearDown Successfully.");
	}
    public void captureScreen(WebDriver driver,String tname) throws IOException {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot taken");
    	
    }
}
