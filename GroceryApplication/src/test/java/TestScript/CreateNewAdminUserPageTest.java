package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Constants.Constants;
import Pages.CreateNewAdminUserPage;
import Pages.HomeLogoutPage;
import Pages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.RandomDataUtility;

public class CreateNewAdminUserPageTest extends TestngBase {
	HomeLogoutPage homelogoutpage;
    CreateNewAdminUserPage createnewadminuser;
	
	@Test(description = "Successfully create new user admin")
	public void verifyUserAdminCreation() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox();
		homelogoutpage=loginpage.clickOnSigninButton();
		
		createnewadminuser=homelogoutpage.clickOnAdminUser();
		createnewadminuser.clickOnCreateNewAdminUser();
		RandomDataUtility random = new RandomDataUtility();
		String adminUserName = random.createRandomUserName();
		String adminUserPassword = random.createRandomPassword();
		createnewadminuser.enterUsernameOnUsernameField(adminUserName).enterPasswordOnPasswordField(adminUserPassword).selectUserType().clickOnSave();
		//createnewadminuser.clickOnReset();
		boolean userCreated = createnewadminuser.userCreatedSuccessfully();
		Assert.assertTrue(userCreated, Constants.USERNOTCREATED);
	}
	
	@Test(description = "Successfully search the given username exist or not")
	public void verifySearchAdminUsers() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox();
		homelogoutpage=loginpage.clickOnSigninButton();

		//CreateNewAdminUserPage createnewadminuser = new CreateNewAdminUserPage(driver);
		createnewadminuser=homelogoutpage.clickOnAdminUser();
		createnewadminuser.clickOnSearch().enterUsernameOnSearchbox().selectUserTypeOnSearch().clickOnSearchInsideSearch();
		//createnewadminuser.clickOnResetOnSearch();

}
}
