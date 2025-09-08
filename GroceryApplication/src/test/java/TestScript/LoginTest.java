package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Pages.LoginPage;
import Utilities.ExcelUtility;

public class LoginTest extends TestngBase{

	@Test(priority = 1, description = "Successfull user login with valid credential")	
	public void verifyUserLoginWithValidCredential() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
	}
    
	@Test(priority = 2, description = "User should not successfully login with wrong credetials")
	public void verifyUserLoginWithWrongCredential() throws IOException {
		String userName = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
	}
	@Test(priority = 3, description = "User should not successfully login with invalid password")
	public void verifyValidUsernameAndInvalidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
		}
	@Test(priority = 4, description = "User should not successfully login with invalid username")
	public void verifyInvalidUsernameAndValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(4, 0, "LoginPage");
		String password = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
	}
}

