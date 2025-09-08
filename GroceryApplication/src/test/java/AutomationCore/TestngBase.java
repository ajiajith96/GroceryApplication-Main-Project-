package AutomationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.ScreenshotUtility;

public class TestngBase {

	public WebDriver driver;
    @BeforeMethod
	public void initializeBrowser() {
		
		driver = new FirefoxDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");  //open url.
		driver.manage().window().maximize();   //maximize the url window.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait applied for 5 sec
	}
    @AfterMethod
    public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

	
	}

}
