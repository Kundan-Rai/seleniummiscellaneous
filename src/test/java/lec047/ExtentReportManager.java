package lec047;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	public void onStart(ITestContext context) 
	{
//		String reportPath = System.getProperty("user.dir")+"/extentreports/myExtentReport.html"; 
		String reportPath = "./extentreports/myExtentReport.html"; 
		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("Automatin Report");	// Title of report
		sparkReporter.config().setReportName("Functional Testing"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);// Theme of the report
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		
		extentReport.setSystemInfo("Computer name", "localhost");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("Tester Name", "Kundan Rai");
		extentReport.setSystemInfo("Browser name", "Chrome");
	}
	
	public void onTestStart(ITestResult result)
	{
		
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		extentTest = extentReport.createTest(result.getName());	// Create a new entry in the report
		extentTest.log(Status.PASS, "Test case PASSED is : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.FAIL, "Test case FAILED is : "+result.getName());
		extentTest.log(Status.FAIL, "Test case FAILED cause is : "+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.SKIP, "Test case SKIPPED is : "+result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		extentReport.flush();
	}
}
