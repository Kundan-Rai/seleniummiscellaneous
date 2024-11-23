package lec047;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener implements ITestListener
{
	public void onStart(ITestContext context) 
	{
	    System.out.println("Test execution is started...onStart");
	}
	
	public void onFinish(ITestContext context)
	{
	    System.out.println("Test execution is completed...onFinith");
	}
	
	public void onTestStart(ITestResult result)
	{
	    Reporter.log("Test started...onTestStart",true);
	}
	
	public void onTestSuccess(ITestResult result) 
	{
	    Reporter.log("Test passed...onTestSuccess",true);
	}
	
	public void onTestFailure(ITestResult result)
	{
	    System.out.println("Test Failed...onTestFailure");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("Test skipped...onTestSkipped",true);
	}
}
