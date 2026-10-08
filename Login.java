package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) {
        
        // 1. Open the Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // 2. Go to the login website (Change this URL to the website you want to test)
        driver.get("https://www.youtube.com");
        
        // 3. Find the username box and type the username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        
        // 4. Find the password box and type the password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        
        // 5. Find the login button and click it
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        // 6. Close the browser when finished
        driver.quit();
        
    }
}