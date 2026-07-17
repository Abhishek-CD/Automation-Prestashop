package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.CreateAccPage;
import pages.LandingPage;
import pages.LoginPage;
import utils.AddressExcelData;
import utils.UserExcelData;

public class LoginTest extends BaseTest{
	
	LoginPage login;
	CreateAccPage createAcc;
	LandingPage lpage;
	
	@Test
	public void loginToApp() throws IOException, InterruptedException {
		login = new LoginPage(driver);
		
		createAcc = new CreateAccPage(driver);
		
		lpage = new LandingPage(driver);
		
		String fname = UserExcelData.getCellData(1, 0);
		String lname = UserExcelData.getCellData(1, 1);
		String email = UserExcelData.getCellData(1, 2);
		String pswd = UserExcelData.getCellData(1, 3);
		String dob = UserExcelData.getCellData(1, 4);
		String gender = UserExcelData.getCellData(1, 5);
		
		
		
		
		String address = AddressExcelData.getCellData(1,0);
		String zip = AddressExcelData.getCellData(1, 1);
		String city = AddressExcelData.getCellData(1, 2);
		String comment = AddressExcelData.getCellData(1, 3);
		
		
//		for(int i=4;i<=7;i++) {
//			String testEmail = UserExcelData.getCellData(i, 2);
//			String testPswd = UserExcelData.getCellData(i, 3);
//			login.getLoggedIn(testEmail,testPswd);
//		}
		
		createAcc.create(fname, lname, email, pswd, dob, gender);
		
		login.getLoggedIn(email,pswd);
	
		login.homePg();
		login.searchOrder();
		
		lpage.buyAfterLogin();
		lpage.addAddress(address, zip, city, comment);
		
		
		
		
		
		
	}
}
