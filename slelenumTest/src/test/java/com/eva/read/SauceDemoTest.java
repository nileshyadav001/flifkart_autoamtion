package com.eva.read;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;

public class SauceDemoTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSauceDemoFlow() {
        // Step 1 & 2: Login
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Step 3: Sort by "Price (low to high)"
        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByVisibleText("Price (low to high)");

        // Step 3.2: Get all prices and find two most expensive
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<Double> priceValues = new ArrayList<>();
        for (WebElement price : prices) {
            priceValues.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        List<Double> topTwoPrices = priceValues.stream()
            .sorted(Comparator.reverseOrder())
            .limit(2)
            .toList();

        // Add 2 most expensive items to the cart
        for (Double price : topTwoPrices) {
            for (WebElement item : driver.findElements(By.className("inventory_item"))) {
                if (item.getText().contains("$" + price)) {
                    item.findElement(By.tagName("button")).click();
                    break;
                }
            }
        }

        // Step 4: Go to cart and validate
        driver.findElement(By.className("shopping_cart_link")).click();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 2, "Exactly 2 items should be in the cart.");

        double totalCartPrice = 0.0;
        for (WebElement item : cartItems) {
            String priceText = item.findElement(By.className("inventory_item_price")).getText();
            totalCartPrice += Double.parseDouble(priceText.replace("$", ""));
        }

        double expectedTotal = topTwoPrices.get(0) + topTwoPrices.get(1);
        Assert.assertEquals(totalCartPrice, expectedTotal, "Total price should match expected sum.");

        // Step 5: Proceed to checkout
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("226001");
        driver.findElement(By.id("continue")).click();

        // Step 6: Final confirmation
        driver.findElement(By.id("finish")).click();
        Assert.assertTrue(driver.getPageSource().contains("THANK YOU FOR YOUR ORDER"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

