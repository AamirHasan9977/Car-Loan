package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.PageBaseClass;

public class SelectingCarLoan extends PageBaseClass {

	public SelectingCarLoan(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\'car-loan\']/a")
	public WebElement selectCarLoan;

	/***********************************
	 * Clicking on Car Loan option
	 *******************************/

	public CarLoanAmount clickCarLoan() {
		try {
			logger.log(Status.INFO, "Clicking the car loan option");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid black;');",
					selectCarLoan);

			if (selectCarLoan.isDisplayed() && selectCarLoan.isEnabled()) {
				selectCarLoan.click();
			} else {
				reportFail("Car loan option is not availabe");
			}
			reportPass("Car loan option clicked successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		CarLoanAmount carLoanAmount = new CarLoanAmount(driver, logger);
		PageFactory.initElements(driver, carLoanAmount);
		return carLoanAmount;

	}

}
