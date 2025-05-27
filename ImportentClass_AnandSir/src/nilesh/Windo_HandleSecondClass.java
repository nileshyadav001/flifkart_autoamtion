package nilesh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windo_HandleSecondClass {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:7617");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		WebElement element=driver.findElement(By.name("user_password"));
		element.sendKeys("automation");
		
		String value=element.getAttribute("name");//html page will print from name attribute value
		System.out.println(value);
		boolean status= element.isDisplayed();
		
		if(status==true) {
			System.out.println("PASSED:PASSWORD IS VISIBLE ON UI");
		}
		else {
			System.out.println("FAILED :password is visible on ui");
		}
		
  	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();

	}

}
