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
	
	public void clickOnAdmineButton() {
		admineButton.click();
	}

	public void clickOnLogoutButton() {
		LogoutButton.click();
	}
}
