package com.testing.POTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.testing.listeners.TestBase;

public class Loginpage extends TestBase {

	WebDriver driver;

	public Loginpage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	WebElement Username;

	public void setUserName(String sUserName) throws Exception {
		browUtil.WaitForVisibility(Username);
		Username.sendKeys(sUserName);
	}

	@FindBy(id = "password")
	WebElement Password;

	public void setPassword(String sPassword) {
		browUtil.WaitForVisibility(Password);

		Password.sendKeys(sPassword);

	}

	@FindBy(id = "Login")
	WebElement login;

	public void clickLogin() {
		browUtil.WaitForVisibility(login);

		login.click();

	}

	@FindBy(id = "error")
	WebElement errorMessage;

	public WebElement errorMessage() {
		return errorMessage;
	}

	public void loginToSFDC(String sUserName, String sPasword) throws Exception {

		this.setUserName(sUserName);

		this.setPassword(sPasword);

		this.clickLogin();
		this.errorMessage();

	}

}
