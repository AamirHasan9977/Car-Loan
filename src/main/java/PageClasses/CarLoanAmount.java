package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.PageBaseClass;

public class CarLoanAmount extends PageBaseClass {

	public CarLoanAmount(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\'loanamount\']")
	public WebElement loanAmount;

	/*********************************
	 * Entering the loan amount
	 *********************************/

	public InterestRate EnterLoanAmount(String amount) {
		try {
			logger.log(Status.INFO, "Entering the loan amount of: "+amount);
			loanAmount.sendKeys(Keys.CONTROL, Keys.chord("a")); // select all text in textbox
			loanAmount.sendKeys(Keys.BACK_SPACE); // delete it
			if(amount.equals("")) {
				reportFail("Car loan amount value is not given in the excel file");
			}else {
			loanAmount.sendKeys(amount);
			}
			reportPass("Loan amount entered successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		InterestRate interestRate = new InterestRate(driver, logger);
		PageFactory.initElements(driver, interestRate);
		return interestRate;
	}

}
