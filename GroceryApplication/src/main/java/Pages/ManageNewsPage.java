package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @class='btn btn-rounded btn-danger']")private WebElement NewNews;
	@FindBy(id = "news")private WebElement NewsContent; 
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement textbox;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchNews;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchTextBox;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchResultButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;

	

	public ManageNewsPage clickOnNewNews() {
		NewNews.click();
		return this;
	}

	public ManageNewsPage enterNewsTitleInsideTextBox(String newsTitle) {
		textbox.sendKeys(newsTitle);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public ManageNewsPage clickOnSearch() {
		searchNews.click();
		return this;
	}

	public ManageNewsPage enterNewsTitlInsideSearchBox(String newsTitle) {
		searchTextBox.sendKeys(newsTitle);
		return this;
	}

	public ManageNewsPage clickOnSearchResultButton() {
		searchResultButton.click();
		return this;
	}

	public ManageNewsPage clickOnResetButton() {
		resetButton.click();
		return this;
	}
}
	


