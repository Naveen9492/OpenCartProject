package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "input[id='input-email']")
	WebElement txtEmail;
	
	@FindBy(css = "input[id='input-password']")
	WebElement txtPassword;
	
	@FindBy(css = "input[type='submit'][value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

}
