package Element_Shorting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flifkart_Price_Comparisation_Works {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 driver.get("https://www.flipkart.com/");
		 driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone",Keys.ENTER);
		//Fetch the all page element list
		 List<WebElement>webElement= driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		 
		 List<Integer> itemList=new ArrayList<Integer>();//one by one add element lines 32
		 for(int page=1;page<=25-1;page++) {
			 webElement= driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']")); //20 line repeat whose page can't refresh
			 
			 for(int i=0;i<=webElement.size()-1;i++) {
				 WebElement weList=webElement.get(i);
				 String list=weList.getText().replace("₹","").replace(",", "").trim();
				Integer newList= Integer.parseInt(list);
				itemList.add(newList);
			 }
		 driver.findElement(By.xpath("//span[text()='Next']")).click();//1st loops works element to be click
		 Thread.sleep(2000);
	}
Collections.sort(itemList);//sorting 
for(Integer allList:itemList) {
	System.out.println(allList);
}

//Fetch the Low to High element list 
driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
List<WebElement>newSortingList=driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
List<Integer> itemList2=new ArrayList<Integer>();
for(int page2=1;page2<=24-1;page2++) {
	newSortingList=driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
	for(int j=0;j<=newSortingList.size()-1;j++) {
		WebElement neList=newSortingList.get(j);
		 String priceList=neList.getText().replace("₹","").replace(",", "").trim(); 
		 Integer price=Integer.parseInt(priceList);
		 itemList2.add(price);
	}
	 driver.findElement(By.xpath("//span[text()='Next']")).click();
	 Thread.sleep(2000);
}
System.err.println( itemList2);
//driver.quit();
//now matched
int b=1;
for(Integer a:itemList) {
	Integer c=itemList2.get(b);
	if(c.equals(a)) {
		System.out.println("Matched list");
	}else {
		System.out.println("Not matched list");
	}
	b++;
}
}

}
