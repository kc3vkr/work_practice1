package com.practice1.object.ui;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUsernameTextBox() {
		WebElement userName = driver.findElement(By.name("username"));
		return userName;
	}
	
	public WebElement getPasswordTextBox() {
		return driver.findElement(By.name("pwd"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.id("loginButton"));
	}
	
	public void waitForLoginPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginFormContainer"))));
	}
	
}
