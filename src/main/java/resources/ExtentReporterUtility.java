package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	static ExtentReports extent;;
	public static ExtentReports getReportobject()
	{
		String path= System.getProperty("user.dir")+ "\\reports\\index.html";
		//System.out.println(path);
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Testing Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Bhawna Chutani");
		return extent;
	}

}
