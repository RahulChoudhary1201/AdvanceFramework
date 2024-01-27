package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.LoggerUtil;

public class LogListeners implements ITestListener {
	private String getTestName(ITestResult result) {
		return result.getTestName() != null ? result.getTestName()
				: result.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestStart(ITestResult result) {
		LoggerUtil.log(getTestName(result) + " : Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LoggerUtil.log(getTestName(result) + " : Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null) {
			cause = t.getMessage();
			LoggerUtil.getLogger().fatal(getTestName(result) + " : Test Failed : " + cause);

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LoggerUtil.log(getTestName(result) + " : Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		String suiteName=context.getSuite().getName();
		LoggerUtil.log("####################### Execution of Suite "+suiteName+" Started. #######################" );
	}

	@Override
	public void onFinish(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("************************** Test Execution Finished ************************************");
		LoggerUtil.log("Total number of Test Cases : " + total);
		LoggerUtil.log("Number of Test Cases Passed : " + passed);
		LoggerUtil.log("Number of Test Cases Failed : " + failed);
		LoggerUtil.log("Number of Test Cases Skipped  : " + skipped);
		String suiteName=context.getSuite().getName();
		LoggerUtil.log("####################### Execution of Suite "+suiteName+" Finished. #######################" );
	}
}
