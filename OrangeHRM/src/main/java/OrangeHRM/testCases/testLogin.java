package OrangeHRM.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import OrangeHRM.Pages.LoginPage;
import Utilities.Utils;

public class testLogin {

	/*
	 * Enter username in username field Enter password in password field Click on
	 * Login Button check we land in Dashboard Page
	 */

	LoginPage loginPage;

	@BeforeClass
	@Parameters({ "browserName" })
	public void init(String browserName) {
		Utils.initializeEnvVars();
		loginPage = new LoginPage(browserName);
	}

	@Test(priority = 1)
	@Parameters({ "Username", "Password" })
	public void validCredentials(String username, String password) {
		loginPage.doLogin(username, password);
		String title = loginPage.getWelcomePageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@AfterTest
	public void tearDown() {
		loginPage.closeBrowser();
	}

	
}
