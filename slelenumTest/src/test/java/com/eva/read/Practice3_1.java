package com.eva.read;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class Practice3_1 {
	protected WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}
	public static void main(String[] args) {
		Practice3_1 pe=new Practice3_1();
		//pe.Electronics();
		//pe.snapshot();
		//pe.anyElement();
		pe.reports();

	}
	
public void Electronics() {
	 driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
	Actions act=new Actions(driver);
WebElement we=driver.findElement(By.xpath("//div[@aria-label='Electronics']"
		+ "//div//div//div/following-sibling::span//span[text()='Electronics']"));
act.moveToElement(we).build().perform();

driver.findElement(By.xpath("//a[contains(@class,'_1BJVlg') and"
		+ " contains(text(),'Electronics GST Store')]")).click();

WebElement elect=driver.findElement(By.xpath("//div[contains(@class,'bpjkJb')]"
		+ "//span[contains(text(),'Electronics')]"));
act.moveToElement(elect).build().perform();

List<WebElement> elects=driver.findElements(By.xpath("//a[@class='jBYtJt']"));
int size=elects.size();
for(int i=0;i<size;i++) {
	elects=driver.findElements(By.xpath("//a[@class='jBYtJt']"));
	WebElement elem=elects.get(i);
	String text=elem.getText();
	System.out.println(text);
	elem.click();
	driver.findElement(By.xpath("//div[contains(@class,'bpjkJb')]"
			+ "//span[contains(text(),'Electronics')]"));
	act.moveToElement(elect).build().perform();
}
}

public void snapshot(){
	 driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
	TakesScreenshot tss=(TakesScreenshot)driver;
	File sourceImage=tss.getScreenshotAs(OutputType.FILE);
	File toImage=new File("slelenumTest.png");
	try {
		Files.copy(sourceImage, toImage);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void anyElement() {
	WebElement weEle=driver.findElement(By.xpath("//div[contains(@aria-label,'Electronics')]"
			+ "//div//div[contains(@class,'YBLJE4')]"));
	File sourceImag=weEle.getScreenshotAs(OutputType.FILE);
	File toImage=new File("element.png");
	try {
		Files.copy(sourceImag, toImage);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void handleDropDown(WebElement we) {
	Select select=	new Select(we);
	select.selectByVisibleText("");
	select.selectByIndex(0);
	select.selectByValue("");
    we=select.getFirstSelectedOption();
    
}
public void actionsClass(WebElement we,WebElement we1) {
	Actions act=new Actions(driver);
	act.contextClick(we).build().perform();
	act.clickAndHold();
	act.doubleClick(we).build().perform();
	act.scrollToElement(we);
	act.scrollByAmount(0, 0);
	act.scrollFromOrigin(null, 0, 0);
	
	act.moveToElement(we).build().perform();
	act.clickAndHold(we).moveToElement(we1).release().build().perform();
	act.click(we1).build().perform();
	act.sendKeys(we1, null).build().perform();
	
}

public void waits(WebElement we, String text,int time) {
	WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(60));
	wdw.until(ExpectedConditions.elementToBeClickable(we));
	wdw.until(ExpectedConditions.visibilityOf(we));
	wdw.until(ExpectedConditions.textToBePresentInElement(we, text));
	wdw.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(we, text)));
	
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
	driver.manage().window().maximize();
	
}
public void popup() {
	Alert alert=driver.switchTo().alert();
	String str=alert.getText();
	alert.accept();//ok
	alert.dismiss();//cancel =NoAlertPresenseException
	
}

public void iframe(WebElement we) {
	driver.switchTo().frame(we);//index,nameOrid
	//work
	driver.switchTo().parentFrame();
	driver.switchTo().defaultContent();//NoSuchFrameException
}

public void windowHandle() {
String mainWindow=driver.getWindowHandle();	
Set<String> wds=driver.getWindowHandles();
for(String wd:wds) {
	driver.switchTo().window(wd);
	String currUrl=driver.getCurrentUrl();
	if(currUrl.contains("")) {//head
		break;
	}
	//work
driver.switchTo().window(mainWindow);	
}
}

public void reports() {
	ExtentReports extr=new ExtentReports();
	ExtentSparkReporter extsr=new ExtentSparkReporter("Report1.html");
	extr.attachReporter(extsr);
	
	ExtentTest ext=extr.createTest("test1");
	ext.log(Status.FAIL," testCase1 passed successfully");
	ext.log(Status.PASS," testCase1 passed successfully");
	ext.log(Status.INFO," testCase1 passed successfully");
	
	//ExtentTest ext1=extr.createTest(mt.getName());
	//ext1.log(Status.PASS," testCase1 passed successfully");
}

}
