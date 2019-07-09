package com.practice1.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice1.object.ui.LoginPage;
import com.practice1.utils.CreateDriver;

public class TestLoiginS187654 {
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondition() {
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);		
	}
	
	@AfterMethod
	public void postCondtion() {
		driver.close();
	}
	
	@Test
	public void testLoginInvalidTC197543() {
		login.waitForLoginPageToLoad();
		login.getUsernameTextBox().sendKeys("admin");
		login.getPasswordTextBox().sendKeys("invalid");
		login.getLoginButton().click();
		
		String actualErrMsg = login.getLoginErrMsg().getText();
		String expectedErrMsg = "Username or Password is invalid. Please try again.";
		
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		
	}
}
