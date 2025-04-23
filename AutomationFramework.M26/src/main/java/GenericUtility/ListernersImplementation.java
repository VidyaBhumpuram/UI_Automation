package GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +" @Test execution started");
		
		//Intimate Extent report for Test
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +" @Test execution is PASS");
		
		//Log the Test result as PASS in extent report
		test.log(Status.PASS, methodName +" @Test execution is PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +" @Test execution is FAILED");
		
		//Log status of Failure in extent report
		test.log(Status.FAIL, methodName +" @Test execution is FAILED");
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodName+"-"+j.getSystemDateInFormet();
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//Attaching the screenshot to extent report
			test.addScreenCaptureFromPath(path);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +" @Test execution is SKIPPED");
		
		//Log the status of Skip in extent report
		test.log(Status.SKIP, methodName +" @Test execution is SKIPPED");
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in Extent report
		test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(" @test suite execution started");
		
		//Configure the Extent report
		ExtentSparkReporter esr = new ExtentSparkReporter("./Extent-Reports/Report-"+new JavaUtility().getSystemDateInFormet()+".html");
		esr.config().setDocumentTitle("Swag lab execution report");
		esr.config().setReportName("Exuection report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment","Testing");
		report.setSystemInfo("Reporter Name", "Vidya");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" @test suite execution completed");
		
		//Generate extent report
	    report.flush();
	}
	
	

}
