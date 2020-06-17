package com.testing.Tests;

import org.testng.annotations.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;

import com.testing.POTests.Homepage;
import com.testing.POTests.Loginpage;
import com.testing.listeners.TestBase;

public class TestCases extends TestBase {

	Logger log = Logger.getLogger(TestCases.class);

	@BeforeTest
	public void setup() {

		browUtil.driver.get("https://login.salesforce.com/");
		screenshotName = getClass().getSimpleName();

	}

	@Test(priority = 1)
	public void LoginWithInvalid() throws Exception {
		Loginpage loginpage = PageFactory.initElements(browUtil.driver, Loginpage.class);
		loginpage.setUserName(comUtil.getPropertyValue("username"));
		loginpage.setPassword("");
		loginpage.clickLogin();
		log.info("login with invalid credentials");
		Assert.assertNotNull(loginpage.errorMessage());
	}

	@Test(priority = 2)
	public void LoginWithvalid() throws Exception {

		Loginpage loginpage = PageFactory.initElements(browUtil.driver, Loginpage.class);
		loginpage.setUserName(comUtil.getPropertyValue("username"));
		loginpage.setPassword(comUtil.getPropertyValue("password"));
		loginpage.clickLogin();
		log.info("Login With valid credentials");

		Assert.assertTrue(browUtil.driver.getCurrentUrl().trim().contains("Homepage"));

	}

	@Test(priority = 3)
	public void Homepage() throws Exception {

		Homepage homepage = PageFactory.initElements(browUtil.driver, Homepage.class);
		homepage.dropdownClick();
		homepage.myprofileClick();
		homepage.userprofileClick();
		homepage.logoutClick();
		log.info("logout is clicked");
		Assert.assertTrue(browUtil.driver.getCurrentUrl().trim().contains("logout"));

	}

}
