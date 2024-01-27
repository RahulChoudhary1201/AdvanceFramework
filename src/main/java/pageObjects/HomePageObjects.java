package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

	private WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Paul Collings']")
	WebElement profileName;

	@FindBy(xpath = "(//img[@alt='profile picture'])[1]")
	WebElement profilePicture;

	public boolean verifyProfilePicture() {
		if (profilePicture.isDisplayed()) {
			return true;
		}
		return false;
	}

	public String profileName() {
		return profileName.getText();
	}

}
