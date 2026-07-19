package Tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	static WebDriver driver;
	@BeforeMethod
	void initializeBrowser() {
		
        // Create Chrome options
        ChromeOptions options = new ChromeOptions();

        // Create preferences map
        Map<String, Object> prefs = new HashMap<>();

        // Disable password manager
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("autofill.profile_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        // Start Chrome with the options
        driver = new ChromeDriver(options);

        
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        driver.manage().window().maximize();
        driver.get("https://demo.prestashop.com/#/en/front");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // for the specific element
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
        
    }
//	@AfterMethod
//	void browserQuit() {
//		driver.quit();
//	}

}
