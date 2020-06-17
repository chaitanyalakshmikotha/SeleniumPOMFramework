package com.testing.POTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.listeners.TestBase;

public class Homepage extends TestBase {
	WebDriver driver;
	@FindBy(xpath = "//span[@id='userNavLabel']")
	WebElement dropdown;
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement myprofile;
	@FindBy(xpath = "//span[@id='userNavLabel']")
	WebElement userprofile;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;

	public Homepage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void dropdownClick() {
		browUtil.WaitForVisibility(dropdown);

		dropdown.click();
	}

	public void myprofileClick() {
		browUtil.WaitForVisibility(myprofile);

		myprofile.click();
	}

	public void userprofileClick() {
		browUtil.WaitForVisibility(userprofile);

		userprofile.click();
	}

	public void logoutClick() {
		browUtil.WaitForVisibility(logout);

		logout.click();

	}
}
