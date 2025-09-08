package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Pages.HomeLogoutPage;
import Pages.LoginPage;
import Utilities.ExcelUtility;

public class HomeLogoutPageTest extends TestngBase {
	
	@Test(description = "Successfully user is logged out")
	public void verifyUserLogoutSuccessfully() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
		HomeLogoutPage homelogoutpage = new HomeLogoutPage(driver);
		homelogoutpage.clickOnAdmineButton();
	    homelogoutpage.clickOnLogoutButton();
 }

}