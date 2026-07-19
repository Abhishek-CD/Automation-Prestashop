package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminPage;
import pages.CreateAccPage;
import pages.LandingPage;
import pages.LoginPage;
import utils.AddressExcelData;
import utils.UserExcelData;

public class AdminTest extends BaseTest {
	AdminPage adm;
	CreateAccPage createAcc;
	LoginPage login;
	LandingPage lpage;
	
	@Test
	public void Order() throws IOException, InterruptedException {
		adm = new AdminPage(driver);
		
		createAcc = new CreateAccPage(driver);
		
		login = new LoginPage(driver);
		
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
		
		
		
		createAcc.create(fname, lname, email, pswd, dob, gender);
		
		login.getLoggedIn(email,pswd);
		login.homePg();
		login.searchOrder();
		
		lpage.buyAfterLogin();
		String orderId = lpage.addAddress2(address, zip, city, comment);
		System.out.println(orderId);
		adm.respondOrder(orderId);
		
		
		
	}
	
	
}
