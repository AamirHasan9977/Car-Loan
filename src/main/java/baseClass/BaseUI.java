package baseClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportManager;

public class BaseUI {

	public ExtentReports report = ExtentReportManager.getReportInstances();
	public ExtentTest logger;
	//public WebDriver driver = null;
	public RemoteWebDriver driver;
	
	PageBaseClass pBaseClass;

	/*************************************
	 * Invoke the Browser
	 *************************************/

	public void invokeBrowser(String browserName) {
		DesiredCapabilities capabilities = null;
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				//capabilities = DesiredCapabilities.chrome();
				//driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"),capabilities);
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				 //capabilities = DesiredCapabilities.firefox();
				//driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"),capabilities);
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				// capabilities = DesiredCapabilities.internetExplorer();
				//driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"),capabilities);
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			pBaseClass.logger.log(Status.INFO, "Selecting the broswer and opening it");
			pBaseClass.reportPass(browserName+ " browser opened successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

	}

	/*****************************
	 * Closing the browser and Flushing the report
	 ************************************/

	public void QuitBrowser() {
		report.flush();
		driver.quit();
		
	}

	/***********************************
	 * wait function
	 ******************************************/
	public void Implicitwait() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
