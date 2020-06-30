package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.PageBaseClass;

public class Tenure extends PageBaseClass {

	public Tenure(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\'loanterm\']")
	public WebElement loanTenure;

	@FindBy(xpath = "//*[@id=\'emicalculatorinnerform\']/div[7]/div/div/div/div/div/label[1]")
	public WebElement typeOfTenure;

	/*******************************
	 * Entering the tenure
	 **********************************/

	public PageTitle EnterLoanTenure(String term) throws InterruptedException {
		try {
			logger.log(Status.INFO, "Entering the tenure of: "+term);
			loanTenure.sendKeys(Keys.CONTROL, Keys.chord("a")); // select all text in textbox
			loanTenure.sendKeys(Keys.BACK_SPACE); // delete it
			if(term.equals("")) {
				reportFail("Loan tenure value is not given in the excel file");
			}else {
			loanTenure.sendKeys(term);
			typeOfTenure.click();
			}
			reportPass("Loan tenure entered successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		PageTitle pageTitle = new PageTitle(driver, logger);
		PageFactory.initElements(driver, pageTitle);
		return pageTitle;
	}

}
