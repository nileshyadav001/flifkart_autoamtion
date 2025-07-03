package com.eva.read;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	protected WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}
	public void baseTest() {
		 driver=new ChromeDriver();
			driver.get("https://www.flipkart.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.manage().window().maximize();
	} 
}
