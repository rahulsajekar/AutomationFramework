package OrangeHRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import WebAutomation.WebAutomationTest;

public class LoginPage {

	public WebAutomationTest webAutomationTest;

	public LoginPage(String browserName) {
		webAutomationTest = new WebAutomationTest();
		webAutomationTest.startBrowser(browserName);
		webAutomationTest.enterApplicationUrl();
		webAutomationTest.createObjectRepositories("LoginPage");
	}

	public void doLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	public void enterUsername(String username) {
		webAutomationTest.enterText(webAutomationTest.objRepo.get("usernameField"), username);
	}

	public void enterPassword(String password) {
		webAutomationTest.enterText(webAutomationTest.objRepo.get("passwordField"), password);
	}

	public void clickLoginButton() {
		webAutomationTest.clickElement(webAutomationTest.objRepo.get("signInBtn"));
	}

	public String getWelcomePageTitle() {
		return webAutomationTest.getPageTitle();
	}

	public String getErrorMessage() {
		return webAutomationTest.getErrorMessage();
	}
	
	public void closeBrowser() {
		webAutomationTest.closeBrowser();
	}

}
