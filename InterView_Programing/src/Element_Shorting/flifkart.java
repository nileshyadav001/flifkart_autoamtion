package Element_Shorting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flifkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		WebElement we=driver.findElement(By.xpath("//input[@class='Pke_EE']"));
				we.sendKeys("iphone16");
				we.submit();
		Thread.sleep(5000);
	String text=	driver.findElement(By.xpath("//input[@class='zDPmFV']")).getAttribute("value");
    System.out.println(text);
	}

}
