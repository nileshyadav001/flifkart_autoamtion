package Element_Shorting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InFlipkartCountThe {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		 // Close the login popup if it appears
        try {
            driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z")).click(); // Close login popup
        } catch (Exception e) {
            System.out.println("Login popup not found or already closed.");
        }

        // Get the visible page text
        String pageText = driver.findElement(By.tagName("body")).getText();

        // Count occurrences of the word "the" (case-insensitive)
        String[] words = pageText.split(" "); // split by whitespace
        int count = 0;
        for (String word : words) {
        	
            if (word.equalsIgnoreCase("the")) {
            	System.out.println(word);
                count++;
            }
        }

        System.out.println("Occurrences of 'the': " + count);

        driver.quit();

	}

}
