package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestngBase {

	public WebDriver driver;
    @BeforeMethod
	public void initializeBrowser() {
		
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");  //open url.
		driver.manage().window().maximize();   //maximize the url window.
	}
    @AfterMethod
	public void closeAndQuit() {
		//driver.close();
		//driver.quit();
	}

}
