package OrangeHRM.Pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Utils;
import WebAutomation.WebAutomationTest;

public class DashboardPage {

	LoginPage lp;
	WebAutomationTest w;
	public DashboardPage() {
		Utils.initializeEnvVars();
		lp = new LoginPage("chrome");
		lp.doLogin("Admin", "admin123");
		w = lp.webAutomationTest;
		w.createObjectRepositories("DashBoardPage");	
	}
	
	public void doLogout() {
		clickOnUser();
		clickOnLogoutBtn();
	}

	private void clickOnLogoutBtn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.clickElement(w.objRepo.get("logoutBtn"));
	}

	private void clickOnUser() {
		w.clickElement(w.objRepo.get("user"));
	}
	
	public String getTitle() {
		return w.getPageTitle();
	}
}
