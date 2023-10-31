package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

		
		By Usernamelocator=By.name("uid");
		By passwordlocator=By.name("password");
		By loginlocator=By.name("btnLogin");
		
		
		WebDriver driver;
		WebElement username;
		WebElement password;
		WebElement login;
		
		
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			this.username=driver.findElement(Usernamelocator);
			this.password=driver.findElement(passwordlocator);
			this.login=driver.findElement(loginlocator);
			
		}
		public void emailenter(String user) {
			username.sendKeys(user);
		}
		public void passwordenter(String pass) {
			password.sendKeys(pass);
		}
		public void loginbutton() {
			login.click();
		}
		

	}


