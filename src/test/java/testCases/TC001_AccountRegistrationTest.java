package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	@Test(groups = {"regression" , "master"})
	public void validateAccountRegitration() {
		
		logger.info("***Starting TC001_AccountRegistrationTest***");
		
		try {
			
			HomePage hp = new HomePage(driver);
			logger.info("Clicked on MyAccount");
			hp.clickMyAccount();
			logger.info("Clicked on register");
			hp.clickRegister();
			logger.info("Providing customer details");
			AccountRegistrationPage ar = new AccountRegistrationPage(driver);
			ar.setFirstName(randomString());
			ar.setLastName(randomString());
			ar.setEmail(randomString()+"@gmail.com");
			ar.setTelephone(randomNumers());
			String pwd = randomPassword();
			ar.setPassword(p.getProperty("password"));
			ar.setConfirmPassword(p.getProperty("password"));
			ar.checkAgreePolicy();
			ar.clickContinue();
			logger.info("Validating expected message");
			
			if(ar.getConfirmationMessage().equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
			
			
		} catch (Exception e) {
			
			Assert.fail();
		}
		logger.info("***Finished TC001_AccountRegistrationTest***");
		
	}
	
}
