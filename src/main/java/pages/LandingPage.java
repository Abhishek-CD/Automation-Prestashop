package pages;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By showAllProducts = By.xpath("//a[contains(normalize-space(),'All featured products')]");
	By product1 = By.xpath("//img[@alt='Hummingbird printed t-shirt']");
	By selectSizeBtn1 = By.id("input_1_1");
	By selectSizeBtn2 = By.id("input_1_2");
	By addToCart = By.xpath("//button[@data-button-action='add-to-cart' and @type='submit']");
	By cartCount = By.cssSelector(".cart-products-count");
	By cartPopupTitle = By.id("blockcart-modal-title");
	By cartBadge = By.xpath("//span[@class='header-block__badge']");
	By continueShopping = By.xpath("//button[@class='btn btn-outline-primary btn-with-icon']");
	By clothesMenu = By.linkText("Clothes");
	By product2 = By.xpath("//img[@title='Brown bear printed sweater']");
	By incrementQtyBtn = By.id("increment_button_2");
	By cart = By.xpath("//a[@class='header-block__action-btn pe-md-0']");
	By proceedCheckout = By.xpath("//a[@class='btn btn-primary btn-lg']");
	
	
	By addressCol = By.id("field-address1");
	By zipcodeCol = By.id("field-postcode");
	By addressContinue = By.xpath("//button[@name='confirm-addresses']");
	By cityCol = By.id("field-city");
	By deliveryMsg = By.id("delivery_message");
	By payment = By.xpath("//button[@name='confirmDeliveryOption']");
	By payByBank = By.id("payment-option-1");
	By privacyCheckbox = By.id("conditions_to_approve[terms-and-conditions]");
	By placeOrderButton = By.xpath("//button[@type='submit' and contains(normalize-space(.), 'Place Order')]");
	By homeLogo = By.xpath("//img[@class='logo img-fluid']");
	
	public void clickAllProducts() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(showAllProducts)).perform();
		
		driver.findElement(showAllProducts).click();
	}
	public void clickProduct1() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement product = wait.until(
	        ExpectedConditions.elementToBeClickable(product1)
	    );

	    product.click();
	}
	public void sizeSelector1() {
		Select selectSize = new Select(driver.findElement(selectSizeBtn1));
		selectSize.selectByValue("2");
	}
	public void sizeSelector2() {
		Select selectSize = new Select(driver.findElement(selectSizeBtn2));
		selectSize.selectByValue("2");
	}	

	
	public void clickAddToCart() throws InterruptedException {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(addToCart)).perform();
		Thread.sleep(4000);
	    driver.findElement(addToCart).click();
	}
	
	
	public void clickContinueShopping() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();
	}
	public void goBackToClothes() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement clothes = wait.until(ExpectedConditions.elementToBeClickable(clothesMenu));

	    clothes.click();
	}
	public void clickProduct2() {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(product2)).perform();
		driver.findElement(product2).click();
	}
	public void addQuantity() {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(incrementQtyBtn)).perform();
		driver.findElement(incrementQtyBtn).click();
	}
	public void clickCart() {
		driver.findElement(cart).click();
	}
	public void clickProceedCheckout() {
		driver.findElement(proceedCheckout).click();
	}
	
	
	
	
	
	public void addAddressCol(String adrs) {
		driver.findElement(addressCol).sendKeys(adrs);
	}
	
	public void addZipcode(String zip) {
		driver.findElement(zipcodeCol).sendKeys(zip);
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(addressContinue)).perform();
	}
	public void addCity(String city) {
		driver.findElement(cityCol).sendKeys(city);
	}
	public void addressContinueBtn() {
		driver.findElement(addressContinue).click();
	}
	public void setDeliveryMsg(String msg) {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(payment)).perform();
		driver.findElement(deliveryMsg).sendKeys(msg);
	}
	public void clickContinuePayment() {
		driver.findElement(payment).click();
	}
	public void clickPayByBank() {
		driver.findElement(payByBank).click();
	}
	public void clickPrivacyCheckBox() {
		driver.findElement(privacyCheckbox).click();
	}
	public void placeOrder() throws InterruptedException {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(placeOrderButton)).perform();
		driver.findElement(placeOrderButton).click();
		
		clickAllProducts();
	}
	public void buyProduct() throws InterruptedException {
		clickAllProducts();
		clickProduct1();
		sizeSelector1();
		clickAddToCart();
		clickContinueShopping();
		goBackToClothes();
		clickProduct2();
		sizeSelector2();
		addQuantity();
		clickAddToCart();
		clickContinueShopping();
		clickCart();
		clickProceedCheckout();
	}

	public void addAddress(String address,String zip, String city, String comment) throws InterruptedException {
		addAddressCol(address);
		addZipcode(zip);
		addCity(city);
		addressContinueBtn();
		setDeliveryMsg(comment);
		clickContinuePayment();
		clickPayByBank();
		clickPrivacyCheckBox();
		placeOrder();
		
	}
	
	
	public void buyAfterLogin() throws InterruptedException {
//		System.out.println("Success!!!!!!!!");
		clickProduct1();
		sizeSelector1();
		clickAddToCart();
		clickContinueShopping();
		clickCart();
		clickProceedCheckout();
	}
	
}
