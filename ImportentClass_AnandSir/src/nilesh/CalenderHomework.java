package nilesh;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
///wrong
public class CalenderHomework {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
//		   String title=  driver.getTitle();
//		    
//		   if(title.equalsIgnoreCase("admin - My Home Page - Calendar - vtiger CRM 5 - Commercial Open Source CRM")) {
//			      System.out.println("PASSED: title is mached  with Expected Title");
//		   }
//		   else {
//			      System.out.println("Failed: title is not mached  with Expected Title");
		  // }
		driver.findElement(By.name("user_name")).sendKeys("admin");
		    driver.findElement(By.name("user_password")).sendKeys("nilesh");
		driver.findElement(By.xpath("//input[@alt='Login [Alt+L]']")).click();
		driver.findElement(By.xpath("//a[text()='Feedback']")).click();
m1();
		Set<String>ha=driver.getWindowHandles();    
		for(String hb:ha) {
			driver.switchTo().window(hb);
			String hk=driver.getCurrentUrl();
			if(hk.contentEquals("https://www.vtiger.com/products/crm/feedback.php?uid=be3cf66e70ef35fa9e4b87dff4f531ab"))
				break;
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[contains(@value,'suggestion')]")).click();
		String wind=driver.getWindowHandle();
		System.out.println(wind);
	}
	public static void m1() {
System.out.println("Hello");//debuging process --->recall
	}

}
