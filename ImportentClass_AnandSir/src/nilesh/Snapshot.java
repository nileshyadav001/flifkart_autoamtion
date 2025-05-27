package nilesh;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Snapshot {
	public static void main(String[] args) throws IOException {//b)
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:7617");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("automation");
  	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
  	    TakesScreenshot ts=( TakesScreenshot)driver;   
  	    File resource=ts.getScreenshotAs(OutputType.FILE);
  	   File destination= new File("C:\\Users\\niles\\OneDrive\\Desktop\\Snapshot\\vtigerReport.png");//File object creating times file name or object wright in store $ vtigerReport.html own throw add
  	   Files.copy(resource,destination);//(a)copy curser bring then (b)self creat $ Files static method
	}

}
