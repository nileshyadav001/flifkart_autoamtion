package org.info.utils;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class WebUtils_Generic {
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void launchBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		System.out.println(browserName+" browser launch successfuly");
	}
	
	public void openUrl(String url) {
		try {
		driver.get(url);
		System.out.println(url+" Url hit successfuly");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebElement searchElement(String xpath) {
		WebElement we=null;
		try {
		 we=driver.findElement(By.xpath(xpath));
		 System.out.println("element found successfuly");
		}catch(NoSuchElementException e) {
			staticWait(3);
			 we=driver.findElement(By.xpath(xpath));
		}catch(Exception e) {
		e.printStackTrace();
		throw e;
		}
		return we;
		
	}
	
	public void staticWait(int timeOfSenconds) {
		try {
			Thread.sleep(timeOfSenconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void type(WebElement we,String value) {
		try {
		we.clear();
		we.sendKeys(value);
		System.out.println("element type successfuly");
		}catch(ElementNotInteractableException e) {
			jsType(value, we);
			System.out.println(value+"textBox in enter by jseScript successfuly");
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void click(WebElement we) {
		try {
		we.click();
		System.err.println("element click successefuly");
		}catch(ElementClickInterceptedException e) {
			jsClick(we);
			System.out.println("Element click by jseScript successfuly");
		}
	}
	
	public void jsType(String value,WebElement we) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='"+value+"'", we);
	}
	public void jsClick(WebElement we) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()",we );
	}
	
	public void snapshot(String imageName,String elementName) {
		TakesScreenshot scr=(TakesScreenshot)driver;
		File resourc=scr.getScreenshotAs(OutputType.FILE);
		File destination=new File("src\\"+imageName+"image.png");
		try {
			Files.copy(resourc, destination);
			
			System.err.println("Take snapshot "+elementName+" successfuly");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snapshotRandomElement(WebElement we,String imageName,String elementName) {
		File resourseEle=we.getScreenshotAs(OutputType.FILE);
		File destination=new File("src\\"+imageName+" image.png") ;
		try {
			System.err.println("random screenshot will perform "+elementName+" successfuly");
			Files.copy(resourseEle, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void mouseOver(WebElement we) {
		try {
		Actions act=new Actions(driver);
		act.moveToElement(we).build().perform();
		System.err.println("mouse over perform successfuly");
		}catch(StaleElementReferenceException e) {
			Actions act=new Actions(driver);
			act.moveToElement(we).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	} 
	public void switchToWindowByTitle(String pageTitle) {
		try {
		Set<String> handlesValue=driver.getWindowHandles();
		for(String handleValue:handlesValue) {
			driver.switchTo().window(handleValue);
			if(driver.getTitle().equalsIgnoreCase(pageTitle)) {
				System.err.println("Focus switch in window- its title-"+pageTitle);
				break;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchToWindowByUrl(String pageUrl) {
		try {
		Set<String> handlesValue=driver.getWindowHandles();
		for(String handleValue:handlesValue) {
			driver.switchTo().window(handleValue);
			if(driver.getCurrentUrl().contains(pageUrl)) {
				System.err.println("Focus switch in window- its title-"+pageUrl);
				break;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  popupAccept() {
		
		try {
		Alert alert=driver.switchTo().alert();
		String textPrint=alert.getText();
		 System.err.println("The popup print-"+textPrint);
		 staticWait(3);
		 
		alert.accept();
		}catch(ElementClickInterceptedException e) {
			Alert alert=driver.switchTo().alert();
			String textPrint=alert.getText();
			 System.err.println("The popup print-"+textPrint);
			alert.accept();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public String  popupDismiss() {
		String textPrint=null;
		try {
		Alert alert=driver.switchTo().alert();
		 textPrint=alert.getText();
		 System.err.println("The popup print-"+textPrint);
		 staticWait(3);
		alert.dismiss();;
		}catch(ElementClickInterceptedException e) {
			Alert alert=driver.switchTo().alert();
			 textPrint=alert.getText();
			 System.err.println("The popup print-"+textPrint);
			alert.accept();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return textPrint;
	}
}
