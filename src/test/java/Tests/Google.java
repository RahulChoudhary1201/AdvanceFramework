package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testBase.BrowserFactory;
import testBase.DriverFactory;

public class Google extends BrowserFactory{
	@Test
	public void test1() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		System.out.println("Opening Google in thread: "+ Thread.currentThread().getId());
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		System.out.println("Closing Google");
		DriverFactory.getInstance().quitDriver();
	}
}
