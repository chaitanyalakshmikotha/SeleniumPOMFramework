package com.testing.listeners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

import com.testing.Utilities.BrowserUtils;
import com.testing.Utilities.CommonUtils;

@Listeners(com.testing.listeners.TestListener.class)
public class TestBase {
	public static String screenshotName = "";

	public static BrowserUtils browUtil = new BrowserUtils();
	public static CommonUtils comUtil = new CommonUtils();
	Logger log = Logger.getLogger(TestBase.class);

	@BeforeSuite
	public void triggerDependencies() throws Exception {

		comUtil.loadLog4jPropertyFile(System.getProperty("user.dir") + "/properties/log4jproperties");
		comUtil.loadConfigPropertyFile(System.getProperty("user.dir") + "/properties/config.properties");

		log.info("launching browser");
		browUtil.launchBrowser("ch");

	}

	@AfterSuite
	public void tearDown() {
		log.debug("Finished");
		browUtil.driver.quit();
	}
}
