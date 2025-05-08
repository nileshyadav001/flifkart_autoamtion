package org.info.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebUtil {

	public WebDriver driver;
	///getter method 
	public WebDriver getDriver() {//getDriver with is object of  WebDriver
		return  driver;
	}
	
	///setter method
	
	public void setDriver(WebDriver driverObject) {
		driver=driverObject;
	}
	
	public void launchBrowser(String browserName) {		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		
		}else if(browserName.equalsIgnoreCase("Safari")) {
			driver=new SafariDriver();
		}else if(browserName.equalsIgnoreCase("InternetExplorer")) {
			driver=new InternetExplorerDriver();
		}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
System.out.println(browserName+"browser launch successfully");
		
	}
	
	public void navigateToUrl(String value) {
		try {
		driver.navigate().to(value);
		System.out.println(" NavigateTo through Url hit successfully");
		}catch(Exception e) {
			
		}
	}
	
	public void openUrl(String url) {
		try {
		driver.get(url);
		System.out.println(url+" hit url successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebElement searchElement(String xpath,String elementName)  {
		 WebElement we=null;
		try { 
	    we=driver.findElement(By.xpath(xpath));
	    System.out.println("element found "+elementName+" successfully");
	    
		}catch(NoSuchElementException e) {
			staticWait(20);//time issue resolve lines(559)
		we=driver.findElement(By.xpath(xpath));
		}catch(InvalidSelectorException e) {
			System.out.println("xpath syntax is wrong, please check");
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw e;
		}
return we;
	}
	
	public void type(WebElement we, String value,String elementName) {
		try {
			we.clear();
			we.sendKeys(value);
			System.out.println(value+" entered in "+elementName+" textbox successfully");
			
		}catch(ElementNotInteractableException e) {
			jsType(we,value);
			System.out.println(value+" entered in textbox successfully by javascript ");
			//jsType(driver,we);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void click(WebElement we,String elementName) {
		try {
		we.click();
		System.out.println(elementName+" element clicked successfully");
		}catch(ElementClickInterceptedException e) {
			jsClick(we);
		}catch(ElementNotInteractableException e) {
			jsClick(we);
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	public void jsType(WebElement we,String value) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='"+value+"",we );
	}
	
	public void jsClick(WebElement we) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()",we );
	}
	
	public void jsScrollByAmount(int x,int y) {
		try {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeAsyncScript("window.scrollBy("+x+","+y+")");
		}catch(Exception e) {
	     e.printStackTrace();
		}
	}
	
	public void jsScrollToElement() {
		try {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("document.body.scrollHeight");
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public void jeScrollAnyElement(WebElement we) {
		try {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", we);
			}catch(Exception e ) {
		e.printStackTrace();
	}
	}
	
	public void ScreenShot(String imageName,String elementName) {
	TakesScreenshot tss=(TakesScreenshot)driver;
	File sourseFile=tss.getScreenshotAs(OutputType.FILE);
	File destination=new File("src\\"+imageName+"Image.png");//+imageName+=>because image Name will difference Hence Image can not Delete
	try {
		Files.copy(sourseFile, destination);
		System.out.println("Screenshot performed "+elementName+" successfully");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void SpacificElement(WebElement we,String imageName,String elementName) {
		File sourceFile=we.getScreenshotAs(OutputType.FILE);
		File destination=new File("Screenshot\\"+imageName+"Image.png");
		System.out.println("SpacificElement snapshot will have performed "+elementName+" successfully");
		try {
			Files.copy(sourceFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToWindowByTitle(String pageTitle) {
		try {
		Set<String> handleValues=driver.getWindowHandles();
		for(String  handleValue : handleValues) {
			driver.switchTo().window(handleValue);
			String currentWindowTitle=driver.getTitle();//html page gone then Head click found title
			if(currentWindowTitle.equalsIgnoreCase(pageTitle)) {
				System.out.println("Focus switch in window - its title -"+pageTitle);
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}		
	}
	
	public void switchToWindowByUrl(String windowUrl) {
		try {
		Set<String> handleValues=driver.getWindowHandles();
		for(String  handleValue : handleValues) {
			driver.switchTo().window(handleValue);
			String currentWindowUrl=driver.getCurrentUrl();//html page gone then Head click found title
			if(currentWindowUrl.contains(windowUrl)) {
				System.out.println("Focus switch in window - its Url -"+windowUrl);
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public String getInnerText(WebElement we) {
		String innertext=null;
		try {
		 innertext=we.getText();

		 System.out.println("innerText print successfully");
		}catch(ElementNotInteractableException e) {
			//Internet rightClick over javascrip code write
		}catch(StaleElementReferenceException e) {
			 innertext=we.getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return innertext;
	}
	
	public  String getAttributeValue(WebElement we, String value) {
		String getAttributeValue=null;
		try {
		 getAttributeValue=we.getAttribute(value);
		System.out.println("AttributeValue print the successfully");
		}catch(ElementNotInteractableException e) {
			//Internet getAttribute javascript code write
		}catch(StaleElementReferenceException e) {
			 getAttributeValue=we.getAttribute(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return getAttributeValue;
	}
	
	public String getTagNameAnyElement(WebElement we) {
		String AnyElement=null;
		try {
	    AnyElement=we.getTagName();
		System.out.println("TagName print the successfully");
		}catch(ElementNotInteractableException e) {
			//Internet getTagName javascript code write
		}catch(StaleElementReferenceException e) {
			  AnyElement=we.getTagName();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return AnyElement;
	}
	
	public boolean displayedElement(WebElement we) {
		boolean display=false;
		try {
		 display=we.isDisplayed();
		System.out.println("Element will Displaying");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return display;
	}
	
	public boolean  enabledElement(WebElement we,String ElementName) { 
		boolean enabled=true;
		try {
		 enabled=we.isEnabled();
		System.out.println("Element Enable successfully "+ElementName);
		}catch(Exception e) {
		e.printStackTrace();	
		}
		return  enabled;
	}
	
	public boolean selectedRadioCheckBoxBotton(WebElement we,String ElementName) {
	
		boolean 	 selected=we.isSelected();
		System.out.println("CheckBox is checke successfully "+ElementName);
return selected;
	}
	
	
public Dimension getSize(WebElement we,String elementName ) {
	Dimension dim=null;
	try {
 dim=we.getSize();
 System.out.println("Size lenght print will have " +elementName+ " successfully");
	}catch(StaleElementReferenceException e) {
		dim=we.getSize();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return dim;
}

public int getHieght(Dimension dim,String elementName) {
int height=0;
	try {
     height=dim.getHeight();
     System.out.println("Height lenght print will have " +elementName+ " successfully");
	}catch(Exception e) {
		e.printStackTrace();
		throw e;
	}
	return height;
}

public int getWidth(Dimension dim,String elementName) {
	int width=0;
	try {
 width=dim.getWidth();
 System.out.println("Width lenght print will have "+elementName+" successfully");
return width;
	}catch(Exception e) {
		e.printStackTrace();
	}
	return width;
}
	

public Point getLocation(WebElement we,String elementName) {
	Point location=null;
	try {
	 location=we.getLocation();
	System.out.println("Location find will have "+elementName+" successfully");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return location;
}

public int getX(Point location,String elementName) {
	 int width=0;
	try {
	 width=location.getX();
System.out.println("X lenght print will have "+elementName+" successfully");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return width;
}

public int getY(Point location,String elementName) {
	int Height=0;
	try {
 Height=location.getY();
 System.out.println("Y lenght print will have "+elementName+" successfully");
 
	}catch(Exception e) {
		e.printStackTrace();
	}
	return Height;
}

	
	///Upload a File method creat
	
	/* This method will performed All text print 
	 * parameters- WebDriver object ,WebElement object
	 * Return- void
	 * Modified data -15/02/2025
	 * Modified by- Nilesh yadav
	 * */
	
	public List<String>  getAllElementsText(String xpath,String elememtName) {
		List<WebElement> list=driver.findElements(By.xpath(xpath));
		List<String> elementsTextList=new ArrayList<String>(); 
		for(WebElement we :list) {
		String innerText=we.getText();
		elementsTextList.add(innerText);
		System.out.println("elements add "+elememtName+" successfully");
		}
		return elementsTextList;
	}
	
	public void clickAllElements(String xpath,String elementName) {
		List<WebElement> list=driver.findElements(By.xpath(xpath));
		for(WebElement we:list) {
		we.click();	
		System.out.println("Click all elements "+elementName+" successfully");
		}
	}
	
	/* This method will performed Frame
	 * parameters- WebElement object
	 * Return- void
	 * Modified data -15/02/2025
	 * Modified by- Nilesh yadav
	 * */
	
	public void swichtToFrame(WebElement weFrame) {
		try {
		driver.switchTo().frame(weFrame);
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public void switchToFrame(int index) {
		try {
		driver.switchTo().frame(index);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/* This method will performed ChromeDriver methods 
	 * parameters- WebDriver object ,WebElement object
	 * Return- void
	 * Modified data -15/02/2025
	 * Modified by- Nilesh yadav
	 * */
	public String getCurrentUrl(String elementName) {
		String url=null;
		try {
	url=driver.getCurrentUrl();
	System.out.println("CurrentUrl print will have"+elementName+" successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public void maximize() {
		try {
		driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void setSize(int width,int height) {
		try {
		Dimension dim =new Dimension(width,height);
		driver.manage().window().setSize(dim);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeAllBrowser() {
		driver.quit();
	}
	
	public void closeBrowser() {
		driver.close();//one browser off
	}
	
	public String getTitle(String elementName) {
		String  pageTitle=null;
		try {
		 pageTitle=driver.getTitle();
		System.out.println("title print will have "+elementName+" successfully");
    	}catch(Exception e) {
			e.printStackTrace();
		}
		return pageTitle;
	}
	
	/* This method will performed popup handel 
	 * parameters- WebDriver object ,WebElement object
	 * Return- void
	 * Modified data -18/02/2025
	 * Modified by- Nilesh yadav
	 * */
	public void popup() {
		
		try {
		Alert alert=driver.switchTo().alert();
		String alertPrint=alert.getText();
		System.err.println("The pupop print -"+alertPrint);
		alert.accept();
		}catch(ElementClickInterceptedException e) {
			Alert alert=driver.switchTo().alert();
			String alertPrint=alert.getText();
			System.err.println("The pupop print -"+alertPrint);
			alert.accept();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String  popupDissmiss() {
		String alertPrint=null;
		try {
		Alert alert=driver.switchTo().alert();
		alertPrint=alert.getText();
		System.err.println("The pupop print -"+alertPrint);
		alert.dismiss();
		}catch(ElementClickInterceptedException e) {
			Alert alert=driver.switchTo().alert();
			
			alertPrint=alert.getText();
			alert.accept();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alertPrint;
	}

	/* This method will performed dropdown
	 * parameters- WebDriver object ,WebElement object
	 * Return- void
	 * Modified data -18/02/2025
	 * Modified by- Nilesh yadav
	 * */
	
	public void selectByVisibleText(WebElement we,String selectText,String elementName) {
		try {
		 Select select =new Select(we);
		 select.selectByVisibleText(selectText);
		 System.out.println(selectText+" enterd the value in "+elementName+" dropdown box");
		 Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println("Code in error, please check");
		}
	}
	
	public void selectTextByIndex(WebElement we,int indexNo,String elementName) {
		try {
		 Select select =new Select(we);
		 select.selectByIndex(indexNo);
		 System.out.println(indexNo+" enterd the value in dropdown box");
		}catch(Exception e) {
			System.out.println("Code in error, please check");
		}
	}
	
	public void selectTextByValue(WebElement we,String atributevalue) {
		try {
		 Select select =new Select(we);
		 select.selectByValue(atributevalue);
		 System.out.println(atributevalue+" enterd the value in dropdown box");
		}catch(Exception e) {
			System.out.println("Code in error, please check");
		}
	}
	
	public WebElement getFirstSelectOption(WebElement we) {
		WebElement dtr=null;
		try {
		 Select select =new Select(we);
		dtr=select.getFirstSelectedOption();
		 System.out.println(" enterd the value in dropdown box");
		}catch(Exception e) {
			System.out.println("Code in error, please check");
		}
		return dtr;
	}
	
	///Actions class methods
	
/*This method will performed rightClick
 * parameters- WebElement object
 * Return- Void
 * Modified Date-15/02/2025
 * Modified By- Nilesh Yadav
 * */
	
	public void rightClick(WebElement we,String elementName) {
	try {
		Actions abs=new Actions(driver);
		abs.contextClick(we).build().perform();
		System.out.println("rightClick performed "+elementName+" successfully");
	}catch(ElementNotInteractableException e) {
		//Internet rightClick over code write
	}catch(StaleElementReferenceException e) {
		 Actions abs=new Actions(driver);
		 abs.contextClick(we).build().perform();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
/*This method will performed clickAndHold
 * Parameters-  WebElement object,String object
 * Return- void 
 * Modified Date- 20/02/2025
 * Modified By- Nilesh Yadav
 * */
	
	public void clickAndHold(WebElement we,String elementName) {
		try {
		Actions cds=new Actions(driver);
		cds.clickAndHold().build().perform();
		System.out.println("clickAndHold Performed "+elementName+" successfully ");
		}catch(ElementNotInteractableException e) {
			//Internet from clickAndHold code
		}catch(StaleElementReferenceException e) {
			Actions cds=new Actions(driver);
			cds.clickAndHold();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
/* This method will performed doubleClick  
 * parameters- WebElement object,String object
 * Return- void
 * Modified data -15/02/2025
 * Modified by- Nilesh yadav
 * */
	public void doubleClick(WebElement we,String elementName) {
		try {
		 Actions act=new Actions(driver);
		 act.doubleClick(we).build().perform();
		 System.out.println("doublClick performed "+elementName+" successfully");
		}catch(ElementNotInteractableException e) {
			//Internet from doubleClick code
		}catch(StaleElementReferenceException e) {
			 Actions act=new Actions(driver);
			 act.doubleClick(we).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method will performed page scroll  
	 * parameters- WebDriver object ,WebElement object
	 * Return- void
	 * Modified data -15/02/2025
	 * Modified by- Nilesh yadav
	 * */
	
	public void scrollToElement(WebElement we,String elementName) {
		try {
		 Actions ach=new Actions(driver);
		 ach.scrollToElement(we).build().perform();
		 System.out.println("page is scrolled to element "+elementName+" successfully");
		}catch(ElementNotInteractableException e) {
			//Internet from scrollTo code
		}catch(StaleElementReferenceException e) {
			 Actions ach=new Actions(driver);
			 ach.scrollToElement(we).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method will performed mouse over 
	 * parameters- WebElement object,String object
	 * Return- void
	 * Modified data -20/02/2025
	 * Modified by- Nilesh yadav
	 * */
	public void mouseOver(WebElement we,String elementName) {
		try {
		 Actions ach=new Actions(driver);
		 ach.moveToElement(we).build().perform();
		 System.out.println("mouseOver performed "+elementName+"successfully");
		}catch(ElementNotInteractableException e) {
			//Internet from Mouse over code write
		}catch(StaleElementReferenceException e) {
			 Actions ach=new Actions(driver);
			 ach.moveToElement(we).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method will performed drag and drop
	 * parameters- WebElement object,String object
	 * Return- void
	 * Modified data -21/02/2025
	 * Modified by- Nilesh yadav
	 * */
public void  dragAndDrop(WebElement weDrag,WebElement weDrop,String elementName) {
	try {
	Actions act=new Actions(driver);
	act.clickAndHold(weDrag).moveToElement(weDrop).release().build().perform();
	System.out.println("drag and performed "+elementName+" successfully");
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
public void  sendkeysActions(WebElement we,String name,String elementName) {
	try {
	Actions act=new Actions(driver);
	act.sendKeys(we,name);
	System.out.println("SendKeys Performed will have "+elementName+" successfully by Actions class ");
	}catch(Exception e) {
		e.printStackTrace();
	}		
}

public void  clickActions(WebElement we,String elementName) {
	try {
	Actions act=new Actions(driver);
	act.sendKeys(we);
	System.out.println("Click Performed will have "+elementName+" successfully by Actions class ");
	}catch(Exception e) {
		e.printStackTrace();
	}		
}

/* This method will performed static wait
 * parameters- int object
 * Return- void
 * Modified data -23/02/2025
 * Modified by- Nilesh yadav
 * */
public void staticWait(int timeInSeconds) {
try {
	Thread.sleep(timeInSeconds*1000);
} catch (InterruptedException e) {
	e.printStackTrace();
}	
}

/* This method will performed non-static wait
 * parameters- int object
 * Return- void
 * Modified data -23/02/2025
 * Modified by- Nilesh yadav
 * */

public void waitForVisibility(WebElement we,int timeout) {//wait for visible text changing
	WebDriverWait wt =new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wt.until(ExpectedConditions.visibilityOf((we)));
}

public void waitForEnabling(WebElement we,int timeout) {//wait for Enabling 
	WebDriverWait wt =new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wt.until(ExpectedConditions.elementToBeClickable((we)));
}

public void waitForText(WebElement we,int timeout,String text) {//wait for text changing
	WebDriverWait wt =new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wt.until(ExpectedConditions.textToBePresentInElement(we,text));
}
//not
public void waitForDisabling(WebElement we,int timeout) {//wait for Disabling 
	WebDriverWait wt =new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wt.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((we))));
}

public void waitForInvisibility(WebElement we,int timeout) {//wait for Invisible text changing
	WebDriverWait wt =new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wt.until(ExpectedConditions.not(ExpectedConditions.visibilityOf((we))));
}

//PageLoadWait

public void changePageLoadTimeout(int timeout) {
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
}

//Method Displayed by 2
public boolean getElementDisplayStatus(WebElement we) {
	Dimension dim=we.getSize();
	boolean status=false; 
	 if(dim.getHeight()>0 && dim.getWidth()>0) {
		 status=true; 
	 }
	 return status;
}
/* This method will performed Validiation
 * parameters- int object
 * Return- void
 * Modified data -23/02/2025
 * Modified by- Nilesh yadav
 * */

public void validateInnerText(WebElement we,String expectedText) {
	//String expectedText="Leads";//Fix value in parameters because every time expectedValue is change
	String actualText=we.getText();
	if(actualText.equalsIgnoreCase(expectedText)) {
		System.out.println("passed. actual-"+actualText+" && expected-"+expectedText);
	}else {
		System.out.println("failed. actual-"+actualText+" && expected-"+expectedText);
	}
}

public void validateAtribute(WebElement we,String expectedAtribute,String atributeName) {
	String actualAtribute=we.getAttribute(atributeName);
	if(actualAtribute.equalsIgnoreCase(expectedAtribute)) {
		System.out.println("passed. actual-"+actualAtribute+" && expected-"+expectedAtribute);
	}else {
		System.out.println("failed. actual-"+actualAtribute+" && expected-"+expectedAtribute);
	}
}

public void validateElementIsVisible(WebElement we) {
	boolean actualStatus=we.isDisplayed();
	if(actualStatus== true) {
		System.out.println("passed. actual-"+actualStatus+" && expected-true");
	}else {
		System.out.println("failed. actual-"+actualStatus+" && expected-true");
	}
}

public void validateElementIsInvisible(WebElement we) {//as a:-login click then button is stay away
	boolean actualStatus=we.isDisplayed();
	if(actualStatus== true) {
		System.out.println("passed. actual-"+actualStatus+" && expected-false");
	}else {
		System.out.println("failed. actual-"+actualStatus+" && expected-false");
	}
}

public void validateElementIsEnabled(WebElement we) {//as a:-login button Enabled
	boolean actualStatus=we.isEnabled();
	if(actualStatus== true) {
		System.out.println("passed. actual-"+actualStatus+" && expected-true");
	}else {
		System.out.println("failed. actual-"+actualStatus+" && expected-true");
	}
}

public void validateElementIsDisabled(WebElement we) {//as a:-login button Enabled
	boolean actualStatus=we.isEnabled();
	if(actualStatus== true) {
		System.out.println("passed. actual-"+actualStatus+" && expected-false");
	}else {
		System.out.println("failed. actual-"+actualStatus+" && expected-false");
	}
}

public void validatePageTitle(String expectedTitle) {
	String actualTitle=driver.getTitle();
	if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("passed. actual-"+actualTitle+" && expected-"+expectedTitle);
	}else {
		System.out.println("failed. actual-"+actualTitle+" && expected-"+expectedTitle);
	}
}

public  void validateDropdownSelectedText(WebElement we, String expectedSelectedText) {
	Select select =new Select(we);
	String actualSelectedText=select.getFirstSelectedOption().getText();
	if(actualSelectedText.equalsIgnoreCase(expectedSelectedText)) {
		System.out.println("passed. actual-"+actualSelectedText+" && expected-"+expectedSelectedText);
	}else {
		System.out.println("failed. actual-"+actualSelectedText+" && expected-"+expectedSelectedText);
	}
}


	
}
