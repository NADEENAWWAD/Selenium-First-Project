package projecttwo;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;


public class myClass {
	
	// Define New Driver
    WebDriver driver;

    @BeforeTest
    public void setup() {
    	
    	// Initialize the WebDriver (open Chrome)
    	driver = new ChromeDriver();

        // Navigate to the website
        driver.get("http://www.saucedemo.com");
        
        // Maximize the browser window
        driver.manage().window().maximize();
   
    }
    
    @Test
    public void printItemName() {
    	
    	// UserName Field Element
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        
        // Password Field Element
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
        // Login Button Element
        driver.findElement(By.id("login-button")).click();
        
        // Items Element
        List <WebElement> itemList = driver.findElements(By.xpath("//div[@class='inventory_item_name ']")) ;
        
        // For Loop to Print the Item Name
        for(int count = 0 ; count < itemList.size() ; count++) {
        	System.out.println("The Item Name is " + itemList.get(count).getText()) ;
        }
    }


    @AfterTest
    public void myPostTesting() {
    	
    	// Close The Browser
    	driver.quit();
    }
}
