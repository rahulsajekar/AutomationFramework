package OrangeHRM.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import OrangeHRM.Pages.DashboardPage;

public class testLogout {

	DashboardPage dp;
	@BeforeClass
	public void init() {
		dp = new DashboardPage();
	}
	
	@Test(priority = 1)
	public void logout() {
		dp.doLogout();
		String title = dp.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
}
