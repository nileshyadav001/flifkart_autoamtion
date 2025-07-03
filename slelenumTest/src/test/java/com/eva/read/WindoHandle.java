package com.eva.read;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindoHandle {
public static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
driver.navigate().to("http://localhost:9999");
driver.findElement(By.name(null));
	}
	
	public static void handleValue() {
		String mainWindow=driver.getWindowHandle();
		Set<String> handlesValue=driver.getWindowHandles();
		for(String handleV:handlesValue) {
			driver.switchTo().window(handleV);
			if(driver.getTitle().equalsIgnoreCase(" currenTitle")) {
				break;
			}
		}
		driver.switchTo().window(mainWindow);
	}

}
