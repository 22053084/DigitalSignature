package com.digitalsignature;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginWebTest {
	
	  //declare Selenium WebDriver
	  private WebDriver webDriver;	
	  
	  @Test
	  public void Login() {
		  //Load website as a new page
		  webDriver.navigate().to("http://localhost:8090/DigitalSignature");
		  
		  //Assert the title to check that we are indeed in the correct website
		  Assert.assertEquals(webDriver.getTitle(), "Digital Signature");
		  
		  System.out.println("title: "+webDriver.getTitle());
		  
		  //Login using credentials
		  webDriver.findElement(By.name("email")).sendKeys("xxx@xxx.com");
		  webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  webDriver.findElement(By.name("password")).sendKeys("123");
		  webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  webDriver.findElement(By.name("login-btn")).sendKeys(Keys.ENTER);

		  //Assert the new title to check that the title is the dashboard and the button click had successfully bring us to the dashboard
		  Assert.assertTrue(webDriver.getTitle().contains("Welcome to Digital Signature - Dashboard"));
		  System.out.println("Login: "+webDriver.getTitle());
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  //Setting system properties of ChromeDriver
		  //use C:\Program Files\Google\Chrome\chromedriver_win32
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe");

		  ChromeOptions optionsBeta = new ChromeOptions();optionsBeta.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		  //initialize FirefoxDriver at the start of test
		  webDriver = new ChromeDriver(optionsBeta);  
	  }
	
	  @AfterTest
	  public void afterTest() {
		  //Quit the ChromeDriver and close all associated window at the end of test
		  webDriver.quit();	
	  }

}
