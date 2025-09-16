package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;
import Utilities.WaitUtility;
import net.bytebuddy.build.HashCodeAndEqualsPlugin.Identity;

public class CreateNewAdminUserPage {
	public WebDriver driver;
	public CreateNewAdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement CreateNewAdminUser;
    @FindBy(id = "username")private WebElement username;
    @FindBy(id = "password")private WebElement password;
    @FindBy(xpath = "//select[@class='form-control' and @id = 'user_type']")private WebElement userType;
    @FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")private WebElement save;
    @FindBy(xpath = "//div[@class='card-footer center']//a[text()='Reset']")private WebElement resetOnAddUser;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")private WebElement userCreatedAlert;
	public CreateNewAdminUserPage clickOnCreateNewAdminUser() {
		CreateNewAdminUser.click();
		return this;
	}
	
	public CreateNewAdminUserPage enterUsernameOnUsernameField(String adminUserName) {
		username.sendKeys(adminUserName);
		return this;
	}

	public CreateNewAdminUserPage enterPasswordOnPasswordField(String adminUserPassword) {
		password.sendKeys(adminUserPassword);
		return this;

	}

	public CreateNewAdminUserPage selectUserType() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(userType, 2);
		/*Select select = new Select(userType);
		select.selectByIndex(2);*/
		return this;
	}

	public CreateNewAdminUserPage clickOnSave() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, save);
		save.click();
		return this;
	}

	/*public CreateNewAdminUserPage clickOnReset() {
		resetOnAddUser.click();
		return this;
	}*/
	public boolean userCreatedSuccessfully() {
		return userCreatedAlert.isDisplayed();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")private WebElement searchUser;
	
    @FindBy(xpath = "//input[@class='form-control' and @id = 'un']")private WebElement usernameOnSearch;

	@FindBy(xpath = "//select[@class='form-control' and @id = 'ut']")private WebElement userTypeOnSearch;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")private WebElement search;
	
    @FindBy(xpath = "//div[@class='card-body']//a[text()='Reset']")private WebElement resetOnSearchUser;

	public CreateNewAdminUserPage clickOnSearch() {
		searchUser.click();
		return this;
    }

	public CreateNewAdminUserPage enterUsernameOnSearchbox() {
		usernameOnSearch.sendKeys("Ajith");
		return this;
	}

	public CreateNewAdminUserPage selectUserTypeOnSearch() {
		Select select = new Select(userTypeOnSearch);
		select.selectByIndex(2);
		return this;
	}

	public CreateNewAdminUserPage clickOnSearchInsideSearch() {
		search.click();
		return this;
	}

	/*public CreateNewAdminUserPage clickOnResetOnSearch() {
		resetOnSearchUser.click();
		return this;
	}*/
	
}
