package com.practice1.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice1.object.ui.LoginPage;
import com.practice1.utils.CreateDriver;

public class SampleLoginTest {
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preConditions() {
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
		
	}
	
	@AfterMethod
	public void postConditions() {
		driver.close();
	}
	
	@Test
	public void testLoginTitle1() {
		login.waitForLoginPageToLoad();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void testLogin2() {
		login.waitForLoginPageToLoad();
		login.getUsernameTextBox().sendKeys("admin");
		login.getPasswordTextBox().sendKeys("invalid");
		login.getLoginButton().click();
				
	}

}
