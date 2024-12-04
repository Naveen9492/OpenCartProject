package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a[class='dropdown-toggle'] span[class*='hidden-xs']")
	WebElement linkMyAccount;
	@FindBy(css = "ul[class*='dropdown-menu-right'] li:nth-last-child(2)")
	WebElement linkRegister;
	@FindBy(css = "ul[class*='dropdown-menu-right'] li:nth-last-child(1)")
	WebElement linkLogin;
	
	public void clickMyAccount() {
		linkMyAccount.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
	public void clickRegister() {
		linkRegister.click();
	}
	

}
