package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

	private ExtentFactory() {

	}

	private static ExtentFactory instance = new ExtentFactory();

	public static ExtentFactory getInstance() {
		return instance;
	}

	ThreadLocal<ExtentTest> threadedExtent = new ThreadLocal<ExtentTest>();

	public ExtentTest getExtentTest() {
		return threadedExtent.get();
	}

	public void setExtentTest(ExtentTest extentTestObject) {
		threadedExtent.set(extentTestObject);
	}

	public void removeExtentTest() {
		threadedExtent.remove();
	}
}
