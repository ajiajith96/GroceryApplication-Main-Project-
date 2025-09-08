package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Pages.CreateNewAdminUserPage;
import Pages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.RandomDataUtility;

public class CreateNewAdminUserPageTest extends TestngBase {
	
	@Test(description = "Successfully create new user admin")
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
		RandomDataUtility random = new RandomDataUtility();
		String adminUserName = random.createRandomUserName();
		String adminUserPassword = random.createRandomPassword();
		createnewadminuser.enterUsernameOnUsernameField(adminUserName);
		createnewadminuser.enterPasswordOnPasswordField(adminUserPassword);
		createnewadminuser.selectUserType();
		createnewadminuser.clickOnSave();
		//createnewadminuser.clickOnReset();
	}
	
	@Test(description = "Successfully search the given username exist or not")
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
