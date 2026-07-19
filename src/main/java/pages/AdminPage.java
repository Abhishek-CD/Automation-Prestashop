package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	By searchBox = By.id("order_reference");
	By searchButton = By.xpath("//button[@name='order[actions][search]']");
	By clickOrder = By.xpath("//td[@class='boolean-type column-new clickable cursor-pointer']");
	By addDiscountBtn = By.xpath("//button[@data-target='#addOrderDiscountModal']");
	By discountNameBox = By.xpath("//input[@type='text' and @id='add_order_cart_rule_name']");
	By discountValueBox = By.id("add_order_cart_rule_value");
	By submitDiscount = By.id("add_order_cart_rule_submit");
	By selectPayment = By.xpath("//select[@id='update_order_status_new_order_status_id']");
	By updateStatusBtn = By.xpath("//button[contains(@class,'update-status')]");
	By frontOffice = By.xpath("//a[@href='#/en/front']");
	By userLoginMenuBtn = By.xpath("//button[@id='userMenuButton']");
	By clickOrders = By.xpath("//a[contains(@class,'dropdown-item') and contains(normalize-space(),'Orders')]");
	By viewInvoice = By.xpath("//a[@aria-label='View invoice']");
	
	
	
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
	
	public void searchBoxText(String id) {
		driver.findElement(searchBox).sendKeys(id);
		driver.findElement(searchButton).click();
	}
	public void clickTheOrder() {
		driver.findElement(clickOrder).click();
	}
	public void clickAddDiscount() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addDiscountBtn)).click();
	}
	public void AddDiscount() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(discountValueBox));
		driver.findElement(discountValueBox).sendKeys("10");
		driver.findElement(discountNameBox).sendKeys("Special Discount Offer");
		wait.until(ExpectedConditions.elementToBeClickable(submitDiscount)).click();
	}
	public void selectPaymentMethod() {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(selectPayment)).perform();
		
		WebElement payment = driver.findElement(selectPayment);
		Select select = new Select(payment);
		select.selectByValue("2");
		
		driver.findElement(updateStatusBtn).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
	}
	public void clickFrontOffice() {
		driver.switchTo().defaultContent();
		
		driver.findElement(frontOffice).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
		
	}
	public void clickUserLoginMenu() {
		driver.findElement(userLoginMenuBtn).click();
		driver.findElement(clickOrders).click();
	}
	public void clickViewInvoice() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewInvoice)).click();
		
	}
	
	
	public void respondOrder(String id) {
		clickBackOffice();
		clickLogin();
		clickOrders();
		searchBoxText(id);
		clickTheOrder();
		clickAddDiscount();
		AddDiscount();
		selectPaymentMethod();
		clickFrontOffice();
		clickUserLoginMenu();
		clickViewInvoice();
		
	}
}
