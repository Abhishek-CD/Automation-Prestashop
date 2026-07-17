package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.CreateAccPage;
import utils.UserExcelData;

public class CreateAccTest extends BaseTest{
	CreateAccPage createAcc;
	@Test
	public void createTest() throws IOException {
		createAcc = new CreateAccPage(driver);
		for(int i=1; i<=2; i++) {
			String fname = UserExcelData.getCellData(i, 0);
			String lname = UserExcelData.getCellData(i, 1);
			String email = UserExcelData.getCellData(i, 2);
			String pswd = UserExcelData.getCellData(i, 3);
			String dob = UserExcelData.getCellData(i, 4);
			String gender = UserExcelData.getCellData(i, 5);
			createAcc.create(fname, lname, email, pswd, dob, gender);
		}
	}
}
