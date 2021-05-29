
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import OrangeHRM.Pages.LoginPage;
import Utilities.Utils;
import WebAutomation.WebAutomationTest;

public class invalidCredetials {

	LoginPage lp;

	@BeforeClass
	@Parameters({"browserName"})
	public void init(String browser) {
		lp = new LoginPage(browser);
	}

	@Test(dataProvider = "readfromexcel")
	public void invalidCredentials(String username, String password, String expectedResult) {

		lp.doLogin(username, password);
		String errorMessage = lp.getErrorMessage();
		Assert.assertEquals(errorMessage, expectedResult);

	}
	
	@AfterClass
	public void tearDown() {
		lp.closeBrowser();
	}

	@DataProvider
	public Object[][] readfromexcel(){
		return Utils.readDataFromExcel("./data.xlsx");
	}

}
