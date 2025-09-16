package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	// dropdown, jscript, click, radiobutton, actions etc are declared here.
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}
	
	public void selectDropdownWithIndex(WebElement element, int index) {

		Select object = new Select(element);
		object.selectByIndex(index);

	}
	
    public void enterPasswordOnPasswordField(WebElement element,String password) {
		
        element.sendKeys(password);

    }
    public void clickOnSigninButton(WebElement element) {
	    element.click();
    
}
    
}