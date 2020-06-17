package com.testing.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.security.Password;
import org.testng.log4testng.Logger;

import com.testing.listeners.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {
	static Logger log = Logger.getLogger(BrowserUtils.class);

	public static WebDriver driver = null;

	public void launchBrowser(String sBrowser) {
		log.info("launching Browser");

		if (sBrowser.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (sBrowser.startsWith("fi")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}
		if (driver != null) {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}

	}

	public void WaitForVisibility(WebElement eleToWait) {

		WebDriverWait Wait = new WebDriverWait(driver, 30);
		Wait.until(ExpectedConditions.visibilityOf(eleToWait));

	}

}
