package nilesh;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown {
	
	public static void main(String[] args) {
		   
   ChromeDriver driver=		  new ChromeDriver();
       driver.get("http://localhost:8888");
		
     //  driver.findElement(By.name("user_name")).sendKeys("admin");
      // driver.findElement(By.name("user_password")).sendKeys("nilesh");
       //driver.findElement(By.id("submitbutton")).click();
       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys("nilesh");
      driver.findElement(By.xpath("//input[@alt='Login [Alt+L]']")).click();
      // We=driver.findElement(By.linkText("Sales"));
       WebElement weLastname=driver.findElement(By.xpath("//a[text()='Sales']"));
      // weLastname.clear();
       weLastname.sendKeys("1");
       weLastname.click();
     String leadsHeadingText = driver.findElement(By.xpath("(//a[text()='Leads'])[6]")).getText();
      System.out.println(leadsHeadingText);
      
      WebElement weDeletButton=driver.findElement(By.xpath("//input[@value='Delete']"));
      String actualDeletbuttonText= weDeletButton.getAttribute("value");
       System.out.println(actualDeletbuttonText);
       
       boolean DeletButtonStatus=weDeletButton.isEnabled();
       System.out.println(DeletButtonStatus);
       
       boolean displayStatus=weDeletButton.isDisplayed();
       System.out.println(displayStatus);
     // Dimension fff=weDeletButton.getSize();
      
//      int sasd= fff.getHeight();
//      int sasd2= fff.getWidth();
//      System.out.println( "first name hight="+sasd);
//      System.out.println( sasd2);
//      Point aaa= weDeletButton.getLocation();
//      int aaX=aaa.getX();
//      int aaaY= aaa.getY();
//      System.out.println(aaX);
      
      
     // System.out.println(aaa);
       
       
	}

}
