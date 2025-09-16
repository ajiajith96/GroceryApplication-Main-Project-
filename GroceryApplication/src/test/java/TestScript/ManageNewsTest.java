package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Pages.HomeLogoutPage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtility;
import Utilities.RandomDataUtility;

public class ManageNewsTest extends TestngBase {
	HomeLogoutPage homelogoutpage;
	ManageNewsPage newnews;
	
	@Test
	public void verifyUserIsAbleToAddNewNewsContent() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox();
		homelogoutpage=loginpage.clickOnSigninButton();
		//ManageNewsPage newnews = new ManageNewsPage(driver);
		newnews=homelogoutpage.clickOnManageNews();
		newnews.clickOnNewNews();
		String newsTitle = ExcelUtility.getStringData(1, 0, "NewsPage");
		RandomDataUtility random = new RandomDataUtility();
		//String newsTitle = random.createRandomText();

		newnews.enterNewsTitleInsideTextBox(newsTitle).clickOnSaveButton();

	}

	@Test
	public void verifySearchForNewNewsTitle() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		homelogoutpage=login.clickOnSigninButton();

		//ManageNewsPage newnews = new ManageNewsPage(driver);
		newnews=homelogoutpage.clickOnManageNews();
		newnews.clickOnSearch();
		String newsTitle = ExcelUtility.getStringData(1, 0, "NewsPage");
		newnews.enterNewsTitlInsideSearchBox(newsTitle).clickOnSearchResultButton();
	}

	@Test
	public void verifyResetButtonFunctionality() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnCheckBox();
		homelogoutpage=loginpage.clickOnSigninButton();
		//ManageNewsPage newnews = new ManageNewsPage(driver);
		newnews=homelogoutpage.clickOnManageNews();
		newnews.clickOnSearch();
		String newsTitle = ExcelUtility.getStringData(1, 0, "NewsPage");
		RandomDataUtility random = new RandomDataUtility();
		//String newsTitle = random.createRandomText();

		//newnews.enterNewsTitleInsideTextBox(newsTitle).clickOnSaveButton();
		//ManageNewsPage newnews = new ManageNewsPage(driver);
		newnews.clickOnSearchResultButton().clickOnResetButton();
	}

		
	}
