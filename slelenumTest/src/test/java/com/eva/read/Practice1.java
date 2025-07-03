package com.eva.read;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

public class Practice1 {
	public static WebDriver driver;
	public static void main(String[] args) {
		 driver=new ChromeDriver();
      driver.get("https://www.redbus.in/");
      snapshot();
      anyElement();
      getElementDisplayStatus();
      ValidateInnerText();
      ValidateAtributeValue();
      validateElementIsVisible();
      validateElementIsInvisible();
      validateElementIsEnabled();
      validateElementIsDisabled();
      validatePageTitle();
      startEnd();
      decending();
      polindrom();
	}
	public static void snapshot() {
		TakesScreenshot tst=(TakesScreenshot)driver;
		File sourceImage=tst.getScreenshotAs(OutputType.FILE);
		File toImage=new File("takesShot.png");
		try {
			Files.copy(sourceImage, toImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void anyElement() {
		WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
		File sourceImage=we.getScreenshotAs(OutputType.FILE);
		File toImage=new File("elementTakes.png");
		try {
			Files.copy(sourceImage, toImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dropDown(WebElement we) {
		Select st=new Select(we);
		st.selectByVisibleText("");
		st.selectByIndex(0);
		st.selectByValue("");
       we=st.getFirstSelectedOption();
	}
	public void actionClass(WebElement we,String name) {
		Actions act=new Actions(driver);
		act.contextClick(we).build().perform();
		act.clickAndHold().build().perform();
		act.doubleClick(we).build().perform();
		act.scrollByAmount(220,330);
		act.scrollFromOrigin(null, 0, 0);
		act.scrollToElement(we);
		
		act.moveToElement(we).build().perform();
		act.clickAndHold(we).moveToElement(we).release(we).build().perform();
		act.click(we);
		act.sendKeys(we, name); 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
	}
	public void waits(int time,WebElement we,String text) {
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(time));
		wdw.until(ExpectedConditions.visibilityOf(we));
		wdw.until(ExpectedConditions.elementToBeClickable(we));
		wdw.until(ExpectedConditions.textToBePresentInElement(we,text));
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
		Alert al=driver.switchTo().alert();
		String text=al.getText();
		al.accept();//ok
		al.dismiss();//cancel both NoAlertPresentException
		
	}
	public void iFrame(WebElement we) {
		//We
		driver.switchTo().frame(we);
		//work
		driver.switchTo().defaultContent();
		//work
		driver.switchTo().parentFrame();
		//work                           NoSuchFrameException
	}
	
	public void windowHandles() {
		 Set<String> gwhs=driver.getWindowHandles();
		 for(String gwh:gwhs) {
			 driver.switchTo().window(gwh);
			 if(driver.getTitle().equalsIgnoreCase(" ")) {//Head DOM
				break; 
			 }
			 if(driver.getCurrentUrl().contains(" ")) {
				 
			 }
		 }
		 //work
		String gwh = driver.getWindowHandle();
		driver.switchTo().window(gwh);
		//work
	}
	public void Reports(Method mt) {
		ExtentReports extr=new ExtentReports();
		ExtentSparkReporter exts=new ExtentSparkReporter("Reports.html");
		extr.attachReporter(exts);
		
		ExtentTest ext=extr.createTest(mt.getName());
		ext.log(Status.FAIL,"chrome browserLaunch successfuly");
		
		ExtentTest ext1=extr.createTest("test2");
		ext1.log(Status.FAIL,"chrome browserLaunch successfuly");
	}
	public void jsScript(WebElement we, String mouseOverCode) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()");
		js.executeScript("arguments[0].value='automation'", we);
		js.executeScript(mouseOverCode,we);//internet
		
		js.executeScript("window.scrollBy(200,400)");
		js.executeScript("window.scrollBy(0,document.body.scrollHieght)");//bottom
		js.executeScript("arguments[0].scrollIntoView(true)",we);
	}
	
	public static boolean getElementDisplayStatus() {
		WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
		Dimension dim=we.getSize();
		boolean status=false;
		if(dim.getHeight()>0 && dim.getWidth()>0) {
			status=true;
			System.out.println("method is element display"+status);
		}
		return status;
	}
	
	public static void ValidateInnerText() {
		WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
		String actualText=we.getText();
		if(actualText.equalsIgnoreCase("Train tickets")) {
			System.out.println("passed.actual-"+actualText+" && expected-"+"Train tickets");
		}else {
			System.out.println("failed.actual-"+actualText+" && expected-"+"Train tickets");
		}
	}
	
	public static void ValidateAtributeValue() {
		WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
		 String actualAtribute=we.getAttribute("class");
		 if(actualAtribute.equalsIgnoreCase("class")) {
			 System.out.println("passed.actual-"+actualAtribute+" && expected-"+"class");
		 }else {
			 System.out.println("failed.actual-"+actualAtribute+" && expected-"+"class");
		 }
	}
	public static void validateElementIsVisible() {
		WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
		boolean actualStatus=we.isDisplayed();
		if(actualStatus==true) {
			System.out.println("passed.actual-"+actualStatus+" && expected-true");
		}else {
			System.out.println("failed.actual-"+actualStatus+" && expected-true");
		}
	}
	
	public static void validateElementIsInvisible() {
		WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
		boolean actualStatus=we.isDisplayed();
		if(actualStatus==true) {
			System.out.println("passed.actual-"+actualStatus+" && expected-false");
		}else {
			System.out.println("failed.actual-"+actualStatus+" && expected-false");
		}
	}
	
public static void validateElementIsEnabled() {
	WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
	boolean actualStatus=we.isEnabled();
	if(actualStatus==true) {
		System.out.println("passed.actual-"+actualStatus+" && expected-true");
	}else {
		System.out.println("failed.actual-"+actualStatus+" && expected-true");
	}
}

public static void validateElementIsDisabled() {
	WebElement we=driver.findElement(By.xpath("//span[contains(text(),'Train tickets')]"));
	boolean actualStatus=we.isEnabled();
	if(actualStatus==true) {
		System.out.println("passed.actual-"+actualStatus+" && expected-faulse");
	}else {
		System.out.println("failed.actual-"+actualStatus+" && expected-faulse");
	}
}

public static void validatePageTitle() {
	String actualTitle=driver.getTitle();
	if(actualTitle.equalsIgnoreCase("Bus Ticket Booking Online at Cheapest Price with Top Bus Operators- redBus")) {
		System.out.println("passed.actual-"+actualTitle+" && expected-"+"Bus Ticket Booking Online at Cheapest Price with Top Bus Operators- redBus");
	}else {
		System.out.println("failed.actual-"+actualTitle+" && expected-"+"Bus Ticket Booking Online at Cheapest Price with Top Bus Operators- redBus");
	}
}

public static void validateDropdownSelectedText(WebElement we,String expectedSelectedText) {
	Select Select=new Select(we);
	String actualSelectedText=Select.getFirstSelectedOption().getText();
	if(actualSelectedText.equalsIgnoreCase(expectedSelectedText)) {
		System.out.println("passed.actual-"+actualSelectedText+" && expected-"+expectedSelectedText);
	}else {
		System.out.println("failed.actual-"+actualSelectedText+" && expected-"+expectedSelectedText);
	}
}

public static void startEnd() {
	String sentence="Sita is singing a song";
	String[] words=sentence.toLowerCase().split(" ");
	for(String word:words) {
		if(word.startsWith("s")||word.endsWith("ing")) {
			System.out.println(word);
		}
	}
} 

public static void decending() {
	int[]num= {12,42,3,45,1,34,56,60,00,23};
	int digit;
	for(int i=0;i<num.length;i++) {
		for(int j=0;j<num.length;j++) {
			if(num[i]>num[j]) {
				digit=num[i];
				num[i]=num[j];
				num[j]=digit;
			}
		}
	}
//	for(int i=0;i<num.length;i++) {
//		System.out.print(num[i]+",");
//	}
	System.out.println(num[1]);
	System.err.println(num[num.length-2]);
}


public static void polindrom(){

String name="naman";
String store="";
for(int i=name.length()-1;i>=0;i--){

char ch=name.charAt(i);
store=store+ch;
}
//System.out.println(store);
if(store.equals(name)){
System.out.println(name+" is a polindrom");
}else{
System.out.println(name+" is not a polindrom");

}
}


}
