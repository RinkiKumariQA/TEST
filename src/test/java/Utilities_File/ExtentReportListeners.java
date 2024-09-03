package Utilities_File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Test_Case_File.BaseClass;

public class ExtentReportListeners extends BaseClass implements ITestListener
{
	 ExtentSparkReporter createReport;
	   ExtentReports addTest;
	   ExtentTest addLog;
	   
	   @BeforeTest
	   void setup()
	   {
		   createReport =new ExtentSparkReporter("DataDrivenReport.html");
		   addTest =new ExtentReports();
		   addTest.attachReporter(createReport);
		   
		   addTest.setSystemInfo("Operating System", "Window");
		   addTest.setSystemInfo("Browser", "chrome");
		   addTest.setSystemInfo("UserName","Rinki");
		   
		   createReport.config().setDocumentTitle("Test Case Report");
		   createReport.config().setReportName("Report Day");
		   createReport.config().setTheme(Theme.STANDARD);
	   }
		   
 public void onStart(ITestContext Result)
 {
	  setup();
 }
 public void onTestStart(ITestResult Result)
 {
	   System.out.println("onTestStart");
 }
 public void onTestSuccess(ITestResult Result)
 {
	   addLog= addTest.createTest(Result.getName());
	   addLog.log(Status.PASS, MarkupHelper.createLabel("Pass testcase", ExtentColor.GREEN));
 }
 public void onTestFailure(ITestResult Result)
 
 {
	   try {
		ScreenShot();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   addLog=addTest.createTest(Result.getName());
	   addLog.log(Status.FAIL, MarkupHelper.createLabel("Fail testcase", ExtentColor.RED));
	   String path="C:\\Users\\RINKI\\eclipse-workspace\\Data_Driven_Framework\\ScreenShot\\A1.png";
	   
	   addLog.fail("screenshot"+addLog.addScreenCaptureFromPath(path));
	}
 
 public void onTestSkipped(ITestResult Result)
 {
	   addLog = addTest.createTest(Result.getName());
	   addLog.log(Status.SKIP, MarkupHelper.createLabel("Skipped testcase", ExtentColor.PURPLE));
 }
 
 public void onFinish(ITestContext Result)
 {
	   addTest.flush();
 }
}
