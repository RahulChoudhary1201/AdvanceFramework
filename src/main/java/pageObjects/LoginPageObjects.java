package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	@FindBy(name = "username")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

	public void login(String userNameInput, String passwordInput) {
		email.sendKeys(userNameInput);
		password.sendKeys(passwordInput);
		loginBtn.click();
	}

}
