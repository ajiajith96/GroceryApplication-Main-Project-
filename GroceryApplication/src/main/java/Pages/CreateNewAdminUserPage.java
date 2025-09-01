package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAdminUserPage {
	public WebDriver driver;
	public CreateNewAdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") private WebElement AdminUser;
    @FindBy(className = "btn btn-rounded btn-danger")private WebElement CreateAdminUser;
	
	public void clickOnAdminUser() {
		AdminUser.click();
	}
	public void clickOnCreateAdminUser() {
		CreateAdminUser.click();
	}
	
}
