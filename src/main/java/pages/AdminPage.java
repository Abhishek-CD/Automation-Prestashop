package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	WebDriver driver;
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By backOfficeBtn = By.xpath("//span[text()='Explore back office']");
	By backOffice = By.xpath("//a[@href='#/en/back']");
	By adminLoginButton = By.xpath("//button[@id='submit_login']");
	By orders = By.xpath("//span[.//a[normalize-space()='Orders']]");
	
	
	
	
	public void clickBackOffice() {
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//a[@href='#/en/back']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_login")));
		
	}
	
	public void clickLogin() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(adminLoginButton)).click();
		
	}
	
	public void clickOrders() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(orders)).click();
	}
	
	
	
	
	
	
	
	public void respondOrder() {
		clickBackOffice();
		clickLogin();
		clickOrders();
		
	}
}
