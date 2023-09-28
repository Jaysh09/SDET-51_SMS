package java.com.SMS.genericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerimpleClass extends Baseclass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		//actual testscripts execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"---> Execution Starts");
	}


	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---> Passed");
		Reporter.log(MethodName+"---> Testscript executed successfully");	
	}

	
	public void onTestFailure(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		try {
			String FailedScript = WebDriverUtility.takeScreenShot(Baseclass.sdriver, MethodName);
			test.addScreenCaptureFromPath(FailedScript);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"---- Failed");
		Reporter.log(MethodName+"----> Failed");
	}
	
//		TakesScreenshot ts=(TakesScreenshot)Baseclass.sdriver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenshot/faledtest.png");
//		try {
//			FileUtils.copyFile(src,dest);
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}
	

	//@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"---- skipped");
		Reporter.log(MethodName+"----> skipped");
	}

	//@Override
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Extentreport/report.html");
		
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("SMS");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		report.setSystemInfo("Reporter Name", "Jayashree");
	}

	//@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
	

}
