package leaf_listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import leaf_base.BaseClass;
import leaf_utilities.ExtentManager;
import leaf_utilities.Screenshots;

public class TestListeners implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentManager.test=ExtentManager.extent.createTest(result.getName());
		ExtentManager.test.info("Test Started!!!"+result.getName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentManager.test.pass("Test Passed");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentManager.test.fail("Test Failed");
		ExtentManager.test.fail(result.getThrowable());
		
		WebDriver driver=BaseClass.driver;
		String testName=result.getName();
		
		try {
			String screenshotPath=Screenshots.captureScreenshot(driver, testName);
			ExtentManager.test.addScreenCaptureFromPath(screenshotPath);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentManager.test.skip("Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.extent.flush();
	}


}
