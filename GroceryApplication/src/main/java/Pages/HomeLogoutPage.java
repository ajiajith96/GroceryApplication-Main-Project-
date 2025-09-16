package Pages;

import org.apache.commons.math3.analysis.function.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLogoutPage {
	public WebDriver driver;
	public HomeLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath = "//a[@data-toggle='dropdown']")private WebElement admineButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement LogoutButton;
	@FindBy(xpath ="//button[@class='btn btn-dark btn-block']")private WebElement SigninButton;
	@FindBy(xpath = "//p[text()='Admin Users']/ancestor::div/a[contains(text(),'More info')]") private WebElement AdminUser;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")private WebElement ManageNews;

	
	public HomeLogoutPage clickOnAdmineButton() {
		admineButton.click();
		return this;
	}

	public LoginPage clickOnLogoutButton() {
		LogoutButton.click();
		return new LoginPage(driver);
	}
	public boolean userLoggedout() {
		return SigninButton.isDisplayed();
	}

	public CreateNewAdminUserPage clickOnAdminUser() {
		AdminUser.click(); 
		return new CreateNewAdminUserPage(driver);
	}
	public ManageNewsPage clickOnManageNews() {
		ManageNews.click();
		return new ManageNewsPage(driver);
	}
}
