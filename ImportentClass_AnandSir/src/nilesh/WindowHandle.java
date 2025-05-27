package nilesh;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:7617");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("automation");
  	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
 
	String Rn=	driver.getWindowHandle();
	System.out.println(Rn + " main window ");  //every tymes diffirent Handele value

driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
driver.findElement(By.xpath("//img[@title='Select']")).click();

            Set<String> handlevalues= driver.getWindowHandles();//set curser bring, then import $ dublicate not allow
	              for(String handleValue :handlevalues) {//selenium focus sub window shifting for sub window use foreach loop
	            	  // System.out.println(handleValue);
	            	  driver.switchTo().window(handleValue);//switchTo use subwindow for focus
	            	 String url=driver.getCurrentUrl();//jis window par rahega usaka url bring
	            	 if(url.contains("http://localhost:5182/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid="))//small information through url hit for contains use 
	            	 {
	            		 driver.close();//(3) perticuler window close remainder continue 
	            		 continue;//(3)
	            		 //(1)break;//throw the loops out	 
	            	 }
	            	 else {//      (2)  window close method means main window not display
	            		 //(2)driver.close();
	            	 }
	            	  
	              }
	              //loop end
	              driver.findElement(By.xpath("//input[@name='search']")).click();       
	}
}

