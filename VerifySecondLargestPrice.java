package test2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifySecondLargestPrice {

    public static void main(String[] args) {

        // STEP 1- Launch Chrome Browser in Guest Mode
    	
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // STEP 2- Navigate to the URL
        
        driver.get("https://www.saucedemo.com/v1/");

        // STEP 3- Enter the Username & Password
        
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // STEP 4- Click Login
        
        driver.findElement(By.id("login-button")).click();

        // STEP 5- Capture & print First Product Name
        
        WebElement firstProductName = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String productName = firstProductName.getText();
        System.out.println("First Product Name: " + productName);

        // STEP 6- Capture & print First Product Price
        
        WebElement firstProductPrice = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"));
        String inventoryPrice = firstProductPrice.getText();
        System.out.println("Inventory Price: " + inventoryPrice);

        // STEP 7- Add First Product to Cart
        
        driver.findElement(By.xpath("(//button[text()='Add To Cart'])[1]")).click();

        // STEP 8- Click on Cart Icon
        
        driver.findElement(By.className("shopping_cart_link")).click();

        // STEP 9- Verify the Cart Price matches the product price 
        
        String cartPrice = driver.findElement(By.className("inventory_item_price")).getText();
        if (inventoryPrice.equals(cartPrice)) {
            System.out.println("Price verified: Inventory price matches Cart price");
        } else {
            System.out.println("Price mismatch!");
        }

        // STEP 10- Click Checkout
        
        driver.findElement(By.id("checkout")).click();

        // STEP 11- Enter First Name,Last Name, Postal Code
        
        driver.findElement(By.id("first-name")).sendKeys("Kaviya");
        driver.findElement(By.id("last-name")).sendKeys("V");
        driver.findElement(By.id("postal-code")).sendKeys("600001");

        // STEP 12- Click Continue
        
        driver.findElement(By.xpath("//input[@value='continue']")).click();

        // STEP 13- Collect All Product Prices
        
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        
        System.out.println("Second Largest Price: $" + secondLargest);

        // STEP 15- Click Finish
        
        driver.findElement(By.id("finish")).click();

        // STEP 16- Close Browser
        
        driver.quit();
    }
}


