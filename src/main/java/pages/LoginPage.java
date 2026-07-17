package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By clickSignin = By.xpath("//a[contains(@class, 'header-block__action-btn')and @aria-label='Sign in']");
	By email = By.id("field-email");
	By password = By.id("field-password");
	By signin = By.id("submit-login");
	By homeLogo = By.xpath("//img[@class='logo img-fluid']");
	By searchBox = By.xpath("//input[@class='js-search-input form-control ps-searchbar__input']");
	By searchBtn = By.xpath("//i[@class='material-icons ps-searchbar__magnifier js-search-icon']");
	
	
	
	String passText = "Hummingbird printed t-shirt";
	

	public void clickSign() throws InterruptedException {
		driver.findElement(clickSignin).click();
		Thread.sleep(3000);
	}
	public void enterEmail(String em) {
		driver.findElement(email).sendKeys(em);
	}
	public void enterPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}
	public void signIn() throws InterruptedException {
		driver.findElement(signin).click();
		Thread.sleep(1500);
	}
	public void clickHomeLogo() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(homeLogo)).click();
	}
	public void searchText() {
		driver.findElement(searchBox).sendKeys(passText);
		driver.findElement(searchBtn).click();
	}
	
	public void getLoggedIn(String email,String password) throws InterruptedException {
		
		clickSign();
		enterEmail(email);
		enterPassword(password);
		signIn();
	}
	public void homePg() {
		clickHomeLogo();
	}
	public void searchOrder() {
		searchText();
	}
}
