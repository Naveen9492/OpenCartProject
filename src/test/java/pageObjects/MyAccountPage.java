package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "aside[id='column-right'] div a:nth-child(1)")
	WebElement myactconfirm;
	
	@FindBy(css = "aside[id='column-right'] div a:nth-child(13)")
	WebElement lnkLogoutBtn;
	
	public boolean confirmLogin() {
		
			if (myactconfirm.getText().equals("My Account")) {
				return true;
			} else {
				return false;
			}
	}
	
	public void clickLogout() {
		lnkLogoutBtn.click();
	}
	
}
