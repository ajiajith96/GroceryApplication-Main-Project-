package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Pages.CreateNewAdminUserPage;
import Pages.LoginPage;
import Utilities.ExcelUtility;

public class CreateNewAdminUserPageTest extends TestngBase {
	
	@Test
	public void verifyUserAdminCreation() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
		
		CreateNewAdminUserPage createnewadminuser = new CreateNewAdminUserPage(driver);
		createnewadminuser.clickOnAdminUser();
		createnewadminuser.clickOnCreateNewAdminUser();
		createnewadminuser.enterUsernameOnUsernameField();
		createnewadminuser.enterPasswordOnPasswordField();
		createnewadminuser.selectUserType();
		createnewadminuser.clickOnSave();
		//createnewadminuser.clickOnReset();
	}
	
	@Test
	public void verifySearchAdminUsers() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();

		CreateNewAdminUserPage createnewadminuser = new CreateNewAdminUserPage(driver);
		createnewadminuser.clickOnAdminUser();
		createnewadminuser.clickOnSearch();
		createnewadminuser.enterUsernameOnSearchbox();
		createnewadminuser.selectUserTypeOnSearch();
		createnewadminuser.clickOnSearchInsideSearch();
		//createnewadminuser.clickOnResetOnSearch();

}
}
