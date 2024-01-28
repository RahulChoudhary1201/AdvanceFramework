package reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.DriverFactory;

public class ReportListener implements ITestListener {

	static ExtentReports extent;

	@Override
	public void onStart(ITestContext context) {
		try {
			extent = ExtentReportNG.setupExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtentTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.PASS,
				"Test Case: " + result.getMethod().getMethodName() + " is Passed.");
		ExtentFactory.getInstance().removeExtentTest();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.FAIL,
				"Test Case: " + result.getMethod().getMethodName() + " is Failed");
		ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());

		// adding Screenshots
		File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String screenshotPath = System.getProperty("user.dir") + "\\Reports\\Screenshots\\" + actualDate + ".png";
		File dest = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ExtentFactory.getInstance().getExtentTest().addScreenCaptureFromPath(screenshotPath,
					"Test case failure Screenshot");
			ExtentFactory.getInstance().removeExtentTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP,
				"Test Case: " + result.getMethod().getMethodName() + " is Skipped.");
		ExtentFactory.getInstance().removeExtentTest();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

}
