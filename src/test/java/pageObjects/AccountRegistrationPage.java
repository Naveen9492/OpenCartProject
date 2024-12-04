package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "#input-firstname")
	WebElement txtFirstName;
	
	@FindBy(css = "#input-lastname")
	WebElement txtLastName;
	
	@FindBy(css = "#input-email")
	WebElement txtEmail;
	
	@FindBy(css = "#input-telephone")
	WebElement txtTelephone;
	
	@FindBy(css = "#input-password")
	WebElement txtPassword;
	
	@FindBy(css = "#input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(css = "input[name='agree']")
	WebElement chkbxAgree;
	
	@FindBy(css = "input[type='submit'][value='Continue']")
	WebElement btnContinue;
	
	@FindBy(css = ".col-sm-9 h1")
	WebElement confirmationMsg;
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phne) {
		txtTelephone.sendKeys(phne);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void checkAgreePolicy() {
		chkbxAgree.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return (confirmationMsg.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}

}
