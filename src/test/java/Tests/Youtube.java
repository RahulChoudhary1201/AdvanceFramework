package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testBase.BrowserFactory;
import testBase.DriverFactory;

public class Youtube extends BrowserFactory {

	@Test
	public void test2() throws InterruptedException {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		System.out.println("Opening Youtube in thread: " + Thread.currentThread().getId());
		driver.get("https://www.youtube.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("search-input")).click();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> titles = driver
				.findElements(By.xpath("//*[@class='yt-simple-endpoint style-scope ytd-playlist-renderer']"));
		for (WebElement webElement : titles) {
			System.out.println(webElement.getText());
		}

		System.out.println(driver.getTitle());

		System.out.println("Closing youtube");
		DriverFactory.getInstance().quitDriver();
	}

	@Test
	public void test3() throws InterruptedException {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		System.out.println("Opening SpeedTest in thread: " + Thread.currentThread().getId());
		driver.get("https://www.speedtest.net/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='start-text']")).click();
		String text = driver.findElement(By.xpath("(//div[@class='result-label'])[7]")).getText();
		System.out.println(text);

		System.out.println(driver.getTitle());
		System.out.println("Closing SpeedTest");
		DriverFactory.getInstance().quitDriver();
	}
}
