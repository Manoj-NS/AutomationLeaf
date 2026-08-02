package leaf_utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports setupReport() {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/LeafTap.html");
		spark.config().setReportName("Automation Report");
		spark.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(spark);
		
		return extent;
	}
	
	public static void tearDownReport() {
		extent.flush();
	}

}
