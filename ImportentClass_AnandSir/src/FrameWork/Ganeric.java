package FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ganeric {

	/* selectByvalue
	 * SelectByVisibleText
	 * SelectByIndex
	 * 
	 * getTitle
	 * getText
	 * get location
	 * get size
	 * 
	 * 
	 * 
	 */
	static WebDriver driver;
	public static void launchBrowser(String browserName) {
		String name=browserName.toLowerCase();
		System.out.println(name);
		switch(name) {

		case "chrome":
			driver=new ChromeDriver();
			System.out.println("chrome Browser launch successfully");
			break;

		case "firefox":
			driver=new FirefoxDriver();
			System.out.println("FireFoxDriver Browser launch successfully");
			break;

		case "edge":
			driver=new EdgeDriver();
			System.out.println("Edge Browser launch successfully");
			break;


		default :
			System.out.println("Browser is not launch");

		}
	}


	public static void hitURL(String url) {
		driver.get(url);
		System.out.println("the "+url+" is entered successfuly");

	}
	public static WebElement myFindElement(String xpath,String elementName) {
		WebElement element=driver.findElement(By.xpath(xpath));
		System.out.println("the "+elementName+" Element has found succesfuly");

		return element;
	}
	public static void mysendKeys(String xpath,String elementName,String inputValue) {
		//WebElement element=myFindElement("//input[@name='user_name']","userNameTB");
		WebElement element=myFindElement(xpath,elementName);
		element.sendKeys(inputValue);
		System.out.println("the sendKeys actions has performed succesfuly on the "+elementName);
	}
	

	public static void myclick(String xpath,String elementName) {

		WebElement element=myFindElement(xpath,elementName );
		element.click();
		System.out.println("the click actions has performed succesfuly on the "+elementName);
	}
	public static String getTitle(String xpath) {
		String   title=     driver.getTitle();
		System.out.println("The title print->"+title);
		return title;
	}
	public static String  getText(String xpath,String elementName) {

		WebElement element=myFindElement(xpath,elementName );
		String text=	element.getText();
		System.out.println("The InerText print->"+elementName);
		return text;
	}
	public static String  getAttribute(String xpath,String elementName,String inputValue) {

		WebElement element=myFindElement(xpath,elementName );
	   String text=	element.getAttribute(inputValue);
		System.out.println("The without Inter text value print->"+elementName);
      return text;
	}
	public static Dimension getSize(String xpath,String elementName) {

		WebElement element=myFindElement(xpath,elementName );
		Dimension  dobj=element.getSize();
		System.out.println("The Leads cancel button size print->"+elementName);
           return dobj;
	}
	public static void getLocation(String xpath,String elementName) {

		WebElement element=myFindElement(xpath,elementName );
		Point CancelLeadsButton=element.getLocation();
		int gy=CancelLeadsButton.getX();
		int hy=CancelLeadsButton.getY();
		System.out.println("The Leads cancel button locasion print->"+elementName);

	}
	public static void SelectByVisibleText(String xpath,String elementName,String chooseText) {

		WebElement element=myFindElement(xpath,elementName );
		
		//element.gets
		Select sobj=   new Select(element);
		   sobj.selectByVisibleText(chooseText);
		System.out.println("The InerText print->"+elementName);

	}


}	
