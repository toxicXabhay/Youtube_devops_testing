package loginTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidLoginTest {
    public static void main(String[] args) {
        // 1. Open the Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Define an explicit wait timer (up to 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // 2. Go to the Google/YouTube Sign-In page directly
            driver.get("https://accounts.google.com/signin");
            
            // 3. Find the email box and type the username
            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
            emailInput.sendKeys("your-email@gmail.com");
            
            // 4. Click the "Next" button to load the password field
            WebElement nextButton = driver.findElement(By.id("identifierNext"));
            nextButton.click();
            
            // 5. Wait for the password field to render dynamically and enter an invalid password
            WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
            passwordInput.sendKeys("WrongPassword123!");
            
            // 6. Click the final login button
            WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
            passwordNextButton.click();
            
            // 7. Optional: Verify that an error message is displayed
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Ekjuhf')]")));
            System.out.println("Login failed as expected. Error message: " + errorMessage.getText());
            
        } catch (Exception e) {
            System.out.println("An error occurred during testing: " + e.getMessage());
        } finally {
            // 8. Close the browser when finished
            driver.quit();
        }
    }
}