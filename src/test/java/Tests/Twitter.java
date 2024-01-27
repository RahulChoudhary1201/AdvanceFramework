package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testBase.BrowserFactory;
import testBase.DriverFactory;

public class Twitter extends BrowserFactory {
	@Test
	public void test3() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		System.out.println("Opening Twitter in thread: " + Thread.currentThread().getId());
		driver.get("https://twitter.com/?lang=en");
		System.out.println(driver.getTitle());
		System.out.println("Closing twitter");
		DriverFactory.getInstance().quitDriver();
	}
}
