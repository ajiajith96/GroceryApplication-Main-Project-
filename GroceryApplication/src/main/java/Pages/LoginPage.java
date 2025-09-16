package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}    
	@FindBy(xpath ="//input[@name='username']")private WebElement UserName;
	@FindBy(xpath ="//input[@name=\"password\"]")private WebElement Password;
	@FindBy(xpath ="//button[@class='btn btn-dark btn-block']")private WebElement SigninButton;
	@FindBy(xpath ="//label[@for='remember']")private WebElement CheckBox;
	@FindBy(xpath = "//p[text()='Dashboard']")private WebElement Dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")private WebElement LoginTitle;
	@FindBy(xpath = "//p[text()='Admin Users']")private WebElement AdminUserTitle;
	
	public LoginPage enterUserNameOnUserNameField(String userName) {//#Chaining - Driver control remains in the same page after the .sendKeys action
		//Hence return Type is changed from void to LoginPage.
		UserName.sendKeys(userName);
		return this;//landing remains in loginpage itself so return to this page itself given.
    }
	public LoginPage enterPasswordOnPasswordField(String password) {
		
        Password.sendKeys(password);
        return this;
	}
	public LoginPage clickOnCheckBox() {
		CheckBox.click();
		return this;
	}
	public HomeLogoutPage clickOnSigninButton() {
	    SigninButton.click();
	    return new HomeLogoutPage(driver);
	}
	
	public boolean isDashboardDisplayed() {
		return Dashboard.isDisplayed();
		}
	
	public String getTitleText() {//Chaining not required here coz this is Assertion
		return LoginTitle.getText();
	}
	
    public String getAdminUserText() {//#Chaining not required here coz this is Assertion
    	return AdminUserTitle.getText();
    	}

}

