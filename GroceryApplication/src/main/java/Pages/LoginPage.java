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
	@FindBy(xpath ="//input[@name='username']") WebElement UserName;
	@FindBy(xpath ="//input[@name=\"password\"]")private WebElement Password;
	@FindBy(xpath ="//button[@class='btn btn-dark btn-block']")private WebElement SigninButton;
	@FindBy(xpath ="//label[@for='remember']")private WebElement CheckBox;
	
	
	public void enterUserNameOnUserNameField(String userName) {
		
		UserName.sendKeys(userName);
    }
	public void enterPasswordOnPasswordField(String password) {
		
        Password.sendKeys(password);
	}
	public void clickOnCheckBox() {
		CheckBox.click();
	}
	public void clickOnSigninButton() {
	    SigninButton.click();
	}
	
}

