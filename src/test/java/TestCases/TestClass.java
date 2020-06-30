package TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import PageClasses.CarLoanAmount;
import PageClasses.GetPrincipalAndInterest;
import PageClasses.InterestRate;
import PageClasses.PageTitle;
import PageClasses.SelectingCarLoan;
import PageClasses.Tenure;
import baseClass.BaseUI;
import baseClass.PageBaseClass;

public class TestClass extends BaseUI {
	
	SelectingCarLoan carLoan;
	CarLoanAmount Amount;
	InterestRate rate;
	Tenure term;
	PageTitle title;
	GetPrincipalAndInterest scroll;

	@Test(dataProvider = "testCase1")
	public void TestCase1(Hashtable<String, String> testtable) throws InterruptedException, IOException {
		logger = report.createTest("EMI calculation");
		invokeBrowser("firefox");
		PageBaseClass pageBaseClass = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBaseClass);
		carLoan = pageBaseClass.openApplication();
		Thread.sleep(3000);
		Amount = carLoan.clickCarLoan();
		Thread.sleep(3000);
		rate = Amount.EnterLoanAmount(testtable.get("Amount"));
		term = rate.EnterRateOfInterest(testtable.get("Interest"));
		title = term.EnterLoanTenure(testtable.get("Tenure"));
		scroll = title.Title();
		Thread.sleep(2000);
		scroll.getPrincipalAndInterest();
		scroll.fetchTheOutput();
		Thread.sleep(3000);
		QuitBrowser();

	}
	
	//@Test(dataProvider = "testCase2")
	public void TestCase2(Hashtable<String, String> testtable) throws InterruptedException, IOException {
		logger = report.createTest("EMI calculation");
		invokeBrowser("chrome");
		PageBaseClass pageBaseClass = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBaseClass);
		carLoan = pageBaseClass.openApplication();
		Thread.sleep(3000);
		Amount = carLoan.clickCarLoan();
		Thread.sleep(3000);
		rate = Amount.EnterLoanAmount(testtable.get("Amount"));
		term = rate.EnterRateOfInterest(testtable.get("Interest"));
		title = term.EnterLoanTenure(testtable.get("Tenure"));
		scroll = title.Title();
		Thread.sleep(2000);
		scroll.getPrincipalAndInterest();
		scroll.fetchTheOutput();
		Thread.sleep(3000);
		QuitBrowser();

	}

	@DataProvider
	public Object[][] testCase1() {
		return Utilities.DataProvider.getData("CalculatingEmi.xlsx", "EMI", " CalculatingEMI");
	}
	
	@DataProvider
	public Object[][] testCase2() {
		return Utilities.DataProvider.getData("CalculatingEmi.xlsx", "EMI", " Calculating");
	}


}
