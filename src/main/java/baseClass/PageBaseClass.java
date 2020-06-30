package baseClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.SelectingCarLoan;
import Utilities.DateUtils;

public class PageBaseClass extends BaseUI {
	public ExtentTest logger;

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = (RemoteWebDriver) driver;
		this.logger = logger;
	}

	/************************
	 * Clicking on Car Loan link
	 *******************************/

	public SelectingCarLoan openApplication() {
		try {
			logger.log(Status.INFO, "Opening the website : https://emicalculator.net/");
			driver.navigate().to("https://emicalculator.net/");
			reportPass("Website opened successfully");

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		SelectingCarLoan selectingCarLoan = new SelectingCarLoan(driver, logger);
		PageFactory.initElements(driver, selectingCarLoan);
		return selectingCarLoan;
	}

	/*********************** Reporting Functions *************************/

	/**************************************
	 * Fail function
	 ************************************/

	public void reportFail(String reportString) {

		logger.log(Status.FAIL, reportString);
		takeScreenShotonFailure();
		QuitBrowser();
	}

	/****************************************
	 * Pass function
	 ************************************/

	public void reportPass(String reportString) {

		logger.log(Status.PASS, reportString);
	}

	/**************************************
	 * Taking screen shot
	 *******************************/

	public void takeScreenShotonFailure() {

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);

		File destinationFile = new File(
				System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtils.getTimeStamp() + ".png");

		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtils.getTimeStamp() + ".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
