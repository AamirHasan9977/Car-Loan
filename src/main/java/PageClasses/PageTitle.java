package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.PageBaseClass;

public class PageTitle extends PageBaseClass {

	public PageTitle(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	/*******************************
	 * Getting the page title
	 *******************************/

	public GetPrincipalAndInterest Title() {
		try {
			logger.log(Status.INFO, "Fetching the page title");
			System.out.println(driver.getTitle());
			reportPass("Page title is displayed");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		GetPrincipalAndInterest getPrincipalAndInterest = new GetPrincipalAndInterest(driver, logger);
		PageFactory.initElements(driver, getPrincipalAndInterest);
		return getPrincipalAndInterest;
	}

}
