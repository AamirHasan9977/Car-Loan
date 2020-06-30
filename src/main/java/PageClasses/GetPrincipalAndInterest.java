package PageClasses;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.WriteExcelFile;
import baseClass.PageBaseClass;

public class GetPrincipalAndInterest extends PageBaseClass {

	public GetPrincipalAndInterest(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\'year2020\']")
	public WebElement yearSelection;

	@FindBy(xpath = "//*[@id=\'monthyear2020\']/td/div/table/tbody/tr[1]/td[2]")
	public WebElement principal;

	@FindBy(xpath = "//*[@id=\'monthyear2020\']/td/div/table/tbody/tr[1]/td[3]")
	public WebElement Interest;

	/*********************
	 * Printing the principal and interest in console
	 *************************/

	public void getPrincipalAndInterest() throws InterruptedException {
		try {
			logger.log(Status.INFO, "Fetching the principal and interest for the first month");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", yearSelection);
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid black;');",
					yearSelection);
			js.executeScript("arguments[0].click()", yearSelection);
			Thread.sleep(3000);
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid black;');",
					principal);
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid black;');",
					Interest);
			System.out.print("The Principal for first month is: ");
			System.out.println(principal.getText());
			System.out.print("The Interest for first month is: ");
			System.out.println(Interest.getText());
			reportPass("Principal and Interest for the first month is fetched successfully");
			reportPass("Principal for first month is: " + principal.getText());
			reportPass("Interest for first month is: " + Interest.getText());
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/*****************************
	 * Printing the output in Excel file
	 ***************************/

	public void fetchTheOutput() throws IOException {
		Hashtable<String, Object[]> dataSet = new Hashtable<String, Object[]>();

		dataSet.put("1", new Object[] { principal.getText(), Interest.getText() });
		logger.log(Status.INFO, "Storing the result in excel file");
		String name = WriteExcelFile.writeData(dataSet);
		logger.log(Status.PASS, "Results stored in excel file- " + name);

	}

}
