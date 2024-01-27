package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
//	protected WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void createBrowserInstance(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			WebDriver driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			DriverFactory.getInstance().setDriver(driver);
		}
		if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt = new EdgeOptions();
			opt.addArguments("-private");
			WebDriver driver = new EdgeDriver(opt);
			driver.manage().window().maximize();
			DriverFactory.getInstance().setDriver(driver);
		}
		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("-private");
			WebDriver driver = new FirefoxDriver(opt);
			driver.manage().window().maximize();
			DriverFactory.getInstance().setDriver(driver);
		}
		if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions opt = new InternetExplorerOptions();
			opt.addCommandSwitches("-private");
			WebDriver driver = new InternetExplorerDriver(opt);
			driver.manage().window().maximize();
			driver = new InternetExplorerDriver(opt);
		}
	}

//	public void quitDriver() {
//		if (driver != null) {
////			driver.close();
//			driver.quit();
//			DriverFactory.getInstance().removeDriver();
//		}
//	}

}
