package TestingAcademy.TestComponets;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestingAcademy.Resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	@Override
    public void onTestStart(ITestResult result) {
        // Code for test start
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code for test success
    	extentTest.get().log(Status.PASS, "Test Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code for test failure
    	extentTest.get().log(Status.FAIL, "Test Pass");
    	extentTest.get().fail(result.getThrowable()); //print errormsg
    	
    	try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    
    	String filePath = null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code for test skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code for partial test success
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        // Code for before test context start
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        // Code for after test context finish
    	extent.flush();
    }
    
}
