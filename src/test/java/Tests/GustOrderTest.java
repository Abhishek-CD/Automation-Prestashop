package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.CreateAccPage;
import pages.LandingPage;
import utils.AddressExcelData;
import utils.UserExcelData;

public class GustOrderTest extends BaseTest {
	LandingPage lpage;
	CreateAccPage createAcc;
	@Test
	public void orderGuestTest() throws IOException, InterruptedException {
		lpage = new LandingPage(driver);
		createAcc = new CreateAccPage(driver);
		
		String address = AddressExcelData.getCellData(3,0);
		String zip = AddressExcelData.getCellData(3, 1);
		String city = AddressExcelData.getCellData(3, 2);
		String comment = AddressExcelData.getCellData(3, 3);
		
		
		String fname = UserExcelData.getCellData(3, 0);
		String lname = UserExcelData.getCellData(3, 1);
		String email = UserExcelData.getCellData(3, 2);
		String pswd = UserExcelData.getCellData(3, 3);
		String dob = UserExcelData.getCellData(3, 4);
		String gender = UserExcelData.getCellData(3, 5);
		
		
		lpage.buyProduct();
		createAcc.createForGuest(fname, lname, email, pswd, dob, gender);
		lpage.addAddress(address,zip,city,comment);
	}

}
