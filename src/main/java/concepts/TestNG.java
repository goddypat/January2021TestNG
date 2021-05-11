package concepts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestNG {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();

		// go to website
		driver.get("http://www.techfios.com/ibilling/?ng=login/");
		// maximize the window
		driver.manage().window().maximize();
		// delete the cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() throws InterruptedException {
	//Element Lib
	  WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
	  WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
	  WebElement SUBMIT_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@type='submit']"));
	  
	  //login data
	  String loginId ="demo@techfios.com";
	  String password ="abc123";
	  
	  
	  USER_NAME_ELEMENT.sendKeys(loginId);
	  PASSWORD_ELEMENT.sendKeys(password);
	  SUBMIT_BUTTON_ELEMENT.click();
	  
	WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), ' Dashboard ')]"));
	Assert.assertEquals(DASHBOARD_TITLE_ELEMENT.getText(), "Dashboard", "Wrong page!!!");
	}
	
	@AfterMethod
	public void tearDown() {
	driver.close();
	driver.quit();
	}
	  
	     
}
