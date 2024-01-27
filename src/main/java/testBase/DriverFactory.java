package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	// Singleton design pattern
	private DriverFactory() {
	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	// Factory Design Pattern: define separate factory methods for creating objects
	// and create object by calling that methods.
	private static final ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		if (threadedDriver.get() == null) {
			throw new IllegalStateException(
					"WebDriver is not set, Please set Webdriver instance by calling DriverFactory.setDriver...");
		}
		return threadedDriver.get();
	}

	public void setDriver(WebDriver driverParam) {
		threadedDriver.set(driverParam);
	}

	public void removeDriver() {
		threadedDriver.remove();
	}

	public void quitDriver() {
		if (threadedDriver.get() != null) {
			threadedDriver.get().quit();
			removeDriver();
		}
	}

}
