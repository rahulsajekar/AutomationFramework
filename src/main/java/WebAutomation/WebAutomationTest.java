package WebAutomation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utilities.Utils;

public class WebAutomationTest {

	RemoteWebDriver driver;

	// Hashmap to store objects
	public HashMap<String, WebElement> objRepo = new HashMap<String, WebElement>();
	public void startBrowser(String browserName) {
		Utils.initializeEnvVars();
		String driverPath = Utils.envVars.get("DriversPath")+"\\";
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath+Utils.envVars.get("ChromeDriverName"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			break;
		}
	}
	
	// read the objectRepository file and put all elements in a hash map
	public void createObjectRepositories(String fileName) {
		try {
			String filePath = Utils.envVars.get("ObjectRepositoriesFolder")+fileName+".txt";
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			while(line!=null) {
				String[] parts = line.split(",");
				WebElement requiredWebElement = getWebElement(parts[1],parts[2]);
				objRepo.put(parts[0], requiredWebElement);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File is not exits at: "+Utils.envVars.get("ObjectRepositoriesFolder"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void enterApplicationUrl() {
		driver.get(Utils.envVars.get("ApplicationUrl"));
	}
	
	// find and return the web element
	private WebElement getWebElement(String strategy, String locator) {
		switch(strategy) {
		case "BY_ID" : 
			return driver.findElementById(locator);
		case "BY_NAME" :
			return driver.findElementByName(locator);
		case "BY_CSS" :
			return driver.findElementByCssSelector(locator);
		case "BY_XPATH" :
			return driver.findElementByXPath(locator);
		case "BY_LINKTEXT" :
			return driver.findElementByLinkText(locator);
		}
		return null;
	}
	
	public void enterText(WebElement e,String text) {
		e.clear();
		e.sendKeys(text);
	}

	public void clickElement(WebElement e) {
		e.click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public String getErrorMessage() {
		return driver.findElementById("spanMessage").getText();
	}
	
}
