package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.PageBaseClass;

public class InterestRate extends PageBaseClass {

	public InterestRate(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id='loaninterest']")
	public WebElement interestRate;
	

	/*****************************
	 * Entering the rate of interest
	 ********************************/

	public Tenure EnterRateOfInterest(String interest) throws InterruptedException {

		try {
			logger.log(Status.INFO, "Entering the interest rate of: "+interest);
			interestRate.sendKeys(Keys.CONTROL, Keys.chord("a")); // select all text in textbox
			interestRate.sendKeys(Keys.BACK_SPACE); // delete it
			if(interest.equals("")) {
				reportFail("Interest rate value is not given in the excel file");
			}else {
			interestRate.sendKeys(interest);
			}
			reportPass("Interest rate entered successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		Tenure tenure = new Tenure(driver, logger);
		PageFactory.initElements(driver, tenure);
		return tenure;
	}
}
