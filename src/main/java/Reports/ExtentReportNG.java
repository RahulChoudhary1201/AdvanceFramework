package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import resusableComponents.PropertiesOperation;

public class ExtentReportNG {

	static ExtentReports extent;

	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String reportPath = System.getProperty("user.dir") + "\\Reports\\ExecutionReport " + actualDate + ".html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		reporter.config().setDocumentTitle("Document Title");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Report Name");
		extent.setSystemInfo("Executed On Environment: ", PropertiesOperation.getPropertyValueByKey("url"));
		extent.setSystemInfo("Executed On Browser: ", PropertiesOperation.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed On OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		return extent;
	}

}
