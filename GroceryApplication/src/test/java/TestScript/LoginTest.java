package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Pages.LoginPage;
import Utilities.ExcelUtility;

public class LoginTest extends TestngBase{

	@Test	
	public void verifyUserLoginWithValidCredential() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
	}
    
	@Test
	public void verifyUserLoginWithWrongCredential() throws IOException {
		String userName = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
	}
	@Test
	public void verifyValidUsernameAndInvalidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
		}
	@Test
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

