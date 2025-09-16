package AutomationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Constants.Constants;
import Utilities.ScreenshotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBase {
    Properties properties;
	public WebDriver driver;
	FileInputStream fs;
	
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
    	properties = new Properties();
    	fs = new FileInputStream(Constants.CONFIGFILE);
    	properties.load(fs);
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver()
			.clearResolutionCache()
		    .forceDownload()
		    .setup();
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else{
			throw new Exception("Invalid Browser");
		}
		driver.get(properties.getProperty("url"));  //open url.
		driver.manage().window().maximize();   //maximize the url window.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait applied for 5 sec
	}
    @AfterMethod(alwaysRun = true)
    public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

	
	}

}
