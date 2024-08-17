package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {
	public ExtentReports setupExtentReport()
	{
		SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		//get current date
		Date date=new Date();
		String actualDate=format.format(date);
		
		String reportPath=System.getProperty("User.dir")+"/Reports/target/ExecutionReport_"+actualDate+".html";
		ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		
		spark.config().setDocumentTitle("Document Title");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Report name");
		
		return report;
		
	}

}
