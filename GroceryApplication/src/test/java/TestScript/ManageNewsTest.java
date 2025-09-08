package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.TestngBase;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtility;
import Utilities.RandomDataUtility;

public class ManageNewsTest extends TestngBase {
	@Test
	public void verifyUserIsAbleToAddNewNewsContent() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnCheckBox();
		loginpage.clickOnSigninButton();
		ManageNewsPage newnews = new ManageNewsPage(driver);
		newnews.clickOnManageNews();
		newnews.clickOnNewNews();
		String newsTitle = ExcelUtility.getStringData(1, 0, "NewsPage");
		RandomDataUtility random = new RandomDataUtility();
		String newsTitle1 = random.createRandomText();

		newnews.enterNewsTitleInsideTextBox(newsTitle1);
		newnews.clickOnSaveButton();

	}

	@Test
	public void verifySearchForNewNewsTitle() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();

		ManageNewsPage newnews = new ManageNewsPage(driver);
		newnews.clickOnManageNews();
		newnews.clickOnSearch();
		String newsTitle = ExcelUtility.getStringData(1, 0, "NewsPage");
		newnews.enterNewsTitlInsideSearchBox(newsTitle);
		newnews.clickOnSearchResultButton();
	}

	@Test
	public void verifyResetButtonFunctionality() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnManageNews();
		news.clickOnResetButton();
	}

		
	}
