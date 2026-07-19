package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateAccPage {
	WebDriver driver;
	
	public CreateAccPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By clickSignin = By.xpath("//a[contains(@class, 'header-block__action-btn')and @aria-label='Sign in']");
	By clickCreateAcc = By.xpath("//a[@data-link-action='display-register-form' and normalize-space()='Create your account']");
	By genderM = By.id("field-id_gender_1");
	By genderF = By.id("field-id_gender_2");
	By firstName = By.id("field-firstname");
	By lastName = By.id("field-lastname");
	By email = By.id("field-email");
	By createAccCheckBoxForGuest = By.xpath("//input[@id='password-form__check']");
	By password = By.id("field-password");
	By dob = By.id("field-birthday");
	By check1 = By.id("field-optin");
	By check2 = By.id("field-psgdpr");
	By check3 = By.id("field-newsletter");
	By check4 = By.id("field-customer_privacy");
	By createAccBtn = By.xpath("//button[contains(@class,'btn btn-primary form-control-submit')and @data-link-action=\"save-customer\"]");
	By continueButtonGuest = By.xpath("//button[@name='continue']");
	By forLogout = By.xpath("//button[@id='userMenuButton']");
	By logOut = By.xpath("//a[contains(@class,'dropdown-item') and contains(normalize-space(),'Sign out')]");
	
	public void clickSign() {
		driver.findElement(clickSignin).click();
	}
	
	public void clickCreat() {
		driver.findElement(clickCreateAcc).click();
	}
		
	public void clickGender(String gender) {
		if(gender.equals("m")) {
			driver.findElement(genderM).click();
		}else {
			driver.findElement(genderF).click();
		}
		
	}
		
	public void enterFristName(String fname) {
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void enterEmail(String eml) {
		driver.findElement(email).sendKeys(eml);
	}
	
	public void clickCreateAccForGust() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(dob)).perform();
		driver.findElement(createAccCheckBoxForGuest).click();
		Thread.sleep(1000);
	}
	
	
	public void enterPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}
	
	public void enterDOB(String dateOfBirth) {
		driver.findElement(dob).sendKeys(dateOfBirth);
	}
	
	public void scrollToEle() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(createAccBtn)).perform();
	}
	public void scrollToContinueGuest() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(continueButtonGuest)).perform();
	}
	public void clickCheckBox1() {
		driver.findElement(check1).click();
	}
	public void clickCheckBox2() {
		driver.findElement(check2).click();
	}
	
	public void clickCheckBox3() {
		driver.findElement(check3).click();
	}
	
	public void clickCheckBox4() {
		driver.findElement(check4).click();
	}
	
	public void clickCreateBtn() {
		driver.findElement(createAccBtn).click();
	}
	
	public void clickForLogout() {
		driver.findElement(forLogout).click();
	}
	
	public void clickLogout() {
		driver.findElement(logOut).click();
	}
	
	public void continueBtnForGuest() {
		driver.findElement(continueButtonGuest).click();
	}
	
	public void create(String fname, String lname, String eml, String pswd, String dateOfBorth, String gndr) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		clickSign();
		clickCreat();
		clickGender(gndr);
		enterFristName(fname);
		enterLastName(lname);
		enterEmail(eml);
		enterPassword(pswd);
		enterDOB(dateOfBorth);
		scrollToEle();
		clickCheckBox1();
		clickCheckBox2();
		clickCheckBox3();
		clickCheckBox4();
		clickCreateBtn();
		clickForLogout();
		clickLogout();
	}
	public void createForGuest(String fname, String lname, String eml, String pswd, String dateOfBorth, String gndr) throws InterruptedException {
		clickGender(gndr);
		enterFristName(fname);
		enterLastName(lname);
		enterEmail(eml);
		clickCreateAccForGust();
		clickCreateAccForGust();
		clickCreateAccForGust();
		enterPassword(pswd);
		enterDOB(dateOfBorth);
		scrollToContinueGuest();
		clickCheckBox1();
		clickCheckBox2();
		clickCheckBox3();
		clickCheckBox4();
		continueBtnForGuest();
		
	}
	
}
