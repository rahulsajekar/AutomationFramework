package IntegratingCucumber;

import org.testng.Assert;

import OrangeHRM.Pages.LoginPage;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class LoginTestcases_StepDefinations 
{

	LoginPage loginpage;
	@Given("^User is on Login screen$")
	public void User_is_on_Login_screen() 
	{
	    // Express the Regexp above with the code you wish you had
		loginpage=new LoginPage("chrome");
	}
	
	@When("^User enters \"([^\"]*)\" in UserName field$")
	public void EnterUserName(String UserName) 
	{
	
		loginpage.enterUsername(UserName);
	}

	@When("^User enters \"([^\"]*)\" in Password field$")
	public void EnterPassword(String Password) 
	{
	
		loginpage.enterPassword(Password);
	}

	@When("^User clicks on Login button$")
	public void ClickLogin_button() 
	{
		loginpage.clickLoginButton();
	}

	@Then("^User should enter into an application$")
	public void CheckIfUserisLoggedIn() {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@Then("^Login Error:([^\"]*) should appear$")
	public void Login_Error_Password_cannot_be_empty_should_appear(String Error) {
	    // Express the Regexp above with the code you wish you had
	    String LoginError=loginpage.getErrorMessage();
	    Assert.assertEquals(Error, LoginError);
	}


	@When("^User enters ([^\"]*) in UserName field$")
	public void EnterUserName1(String Uname) {
	    // Express the Regexp above with the code you wish you had
	    loginpage.enterUsername(Uname);
	}

	@When("^User enters ([^\"]*) in Password field$")
	public void EnterPassword1(String Password) {
	    // Express the Regexp above with the code you wish you had
	    loginpage.enterPassword(Password);
	}
}
