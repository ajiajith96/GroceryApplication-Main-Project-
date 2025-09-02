package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAdminUserPage {
	public WebDriver driver;
	public CreateNewAdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath = "//p[text()='Admin Users']/ancestor::div/a[contains(text(),'More info')]") private WebElement AdminUser;
	
	public void clickOnAdminUser() {
		AdminUser.click(); 
	}
	
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement CreateNewAdminUser;
    @FindBy(id = "username")private WebElement username;
    @FindBy(id = "password")private WebElement password;
    @FindBy(name = "user_type")private WebElement userType;
    @FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")private WebElement save;
    @FindBy(xpath = "//div[@class='card-footer center']//a[text()='Reset']")private WebElement resetOnAddUser;
	public void clickOnCreateNewAdminUser() {
		CreateNewAdminUser.click();
	}
	
	public void enterUsernameOnUsernameField() {
		username.sendKeys("Ajith");
	}

	public void enterPasswordOnPasswordField() {
		password.sendKeys("ajithgopal");

	}

	public void selectUserType() {
		Select select = new Select(userType);
		select.selectByIndex(2);
	}

	public void clickOnSave() {
		save.click();
	}

	public void clickOnReset() {
		resetOnAddUser.click();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")private WebElement searchUser;
	
    @FindBy(name = "un")private WebElement usernameOnSearch;

	@FindBy(id = "ut")private WebElement userTypeOnSearch;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")private WebElement search;
	
    @FindBy(xpath = "//div[@class='card-body']//a[text()='Reset']")private WebElement resetOnSearchUser;

	public void clickOnSearch() {
		searchUser.click();

	}

	public void enterUsernameOnSearchbox() {
		usernameOnSearch.sendKeys("Ajith");
		
		Select select = new Select(userTypeOnSearch);
	}

	public void selectUserTypeOnSearch() {
		Select select = new Select(userTypeOnSearch);
		select.selectByIndex(3);
		
	}

	public void clickOnSearchInsideSearch() {
		search.click();
	}

	public void clickOnResetOnSearch() {
		resetOnSearchUser.click();
	}
	
}
