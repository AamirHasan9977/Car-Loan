package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {

	// public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;

	/***************************************
	 * Create the Extent report
	 ***************************************/
	
	public static ExtentReports getReportInstances() {
		if (report == null) {
			String reportName = DateUtils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\test-output\\ExtentReport\\" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows 8");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "8.1.3");
			report.setSystemInfo("Testing platform", "Eclipse");
			report.setSystemInfo("Script platform", "Java");
			report.setSystemInfo("Browser", "Chrome");

			htmlReporter.config().setDocumentTitle("EMI Calculator");
			htmlReporter.config().setReportName("Calculating EMI for a given data");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}

		return report;
	}
}
