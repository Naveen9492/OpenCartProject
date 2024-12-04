package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {

	@Test(groups = {"sanity" , "master"})
	public void validateAccountLogin() {
		logger.info("***Started TC002_AccountLoginTest***");
		HomePage hp = new HomePage(driver);
		logger.info("clicked on my account");
		hp.clickMyAccount();
		logger.info("clicked on login on home page");
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		logger.info("entered email");
		lp.setEmail(p.getProperty("email"));
		logger.info("entered password");
		lp.setPassword(p.getProperty("password"));
		logger.info("clicked on login btn");
		lp.clickLogin();
		MyAccountPage mc = new MyAccountPage(driver);
		logger.info("confirming login or not");
		if (mc.confirmLogin()) {
			logger.info("Login success");
			Assert.assertTrue(true);
		}
		else {
			logger.info("login failed");
			Assert.fail();
		}
		logger.info("***Ended TC002_AccountLoginTest***");
	}
	
}
