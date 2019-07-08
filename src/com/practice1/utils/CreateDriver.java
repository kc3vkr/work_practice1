package com.practice1.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	
	
	public static WebDriver getDriverInstance() {
		WebDriver driver = null;
		
		String browser = DataHandlers.getDataFromProperties("C:/Users/Veman/Desktop/Study Materials/Java Contents/Test data/configuration.properties", "browser");
		String url = DataHandlers.getDataFromProperties("C:/Users/Veman/Desktop/Study Materials/Java Contents/Test data/configuration.properties", "url");
		
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/Veman/Desktop/Study Materials/Java Contents/Firefox Drivers/geckodriver-v0.23.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/Veman/Desktop/Study Materials/Java Contents/Chrome Drivers/New folder/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("------------Invalid BrowserOption------------");
			return driver;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
