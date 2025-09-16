package TestScript;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Constant;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Constants.Constants;
import Pages.HomeLogoutPage;
import Pages.LoginPage;
import Utilities.ExcelUtility; 

public class LoginTest extends TestngBase{
    public HomeLogoutPage homelogoutpage;
	@Test(priority = 1, description = "Successfull user login with valid credential", groups = {"smoke"})	
	public void verifyUserLoginWithValidCredential() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox(); // chaining of pages done and the format is as shown. Chaining is done when the driver is in same page(landing page).
		homelogoutpage=loginpage.clickOnSigninButton();
		boolean dashboardDisplay = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constants.VALIDCREDENTIALERROR);
	}
    
	@Test(priority = 2, description = "User should not successfully login with wrong credetials", dataProvider = "loginProvider")
	public void verifyUserLoginWithWrongCredential(String userName, String password) throws IOException {
		//String userName = ExcelUtility.getStringData(2, 0, "LoginPage");
		//String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox().clickOnSigninButton();//since login error will be shown and landing page will be login page itself.
		String expected = "7rmart supermarket";
		String actual = loginpage.getTitleText();
		Assert.assertEquals(actual, expected, Constants.INVALIDCREDENTIALERROR);
	}
	@Test(priority = 3, description = "User should not successfully login with invalid password", groups = {"smoke"}, retryAnalyzer = RetryAnalyser.Retry.class)
	public void verifyValidUsernameAndInvalidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(3, 1, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox().clickOnSigninButton();
		String expected = "Admin Users";
		String actual = loginpage.getAdminUserText();
		Assert.assertEquals(actual, expected, Constants.INVALIDPASSWORDERROR);
		
		}
	@Test(priority = 4, description = "User should not successfully login with invalid username")
	public void verifyInvalidUsernameAndValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(4, 0, "LoginPage");
		String password = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox().clickOnSigninButton();
		String expected = "Admin Users";
		String actual = loginpage.getAdminUserText();
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEERROR);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}

