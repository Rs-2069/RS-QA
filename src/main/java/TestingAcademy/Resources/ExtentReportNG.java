package TestingAcademy.Resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	
	public static  ExtentReports getReportObject()
	{
		//ExtentReport and ExtentSparkReport
		String path = System.getProperty("user.dir")+"//reports//index.html";
		//ExtentReport report = new ExtentReport();
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Test Result");
		report.config().setReportName("Web Automatio Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		return extent;
	}
}
