package com.testing.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.testing.listeners.TestBase;

public class CommonUtils {

	public Properties log4jProp = new Properties();
	public Properties configProp = new Properties();

	FileInputStream fileinput;
	Logger log = Logger.getLogger(CommonUtils.class);

	public String getPropertyValue(String propName) throws Exception {
		System.out.println("requested Property: " + propName);
		String retVal = (String) configProp.get(propName);
		System.out.println("Returning value:" + retVal);
		return retVal;
	}

	public void loadConfigPropertyFile(String sPathConfigPropertyFile) throws Exception {
		System.out.println("load Config property file" + sPathConfigPropertyFile);
		fileinput = new FileInputStream(sPathConfigPropertyFile);
		configProp.load(fileinput);
	}

	public void loadLog4jPropertyFile(String sPathLog4jPropertyFile) throws Exception {
		log.info("load Log4j property file" + sPathLog4jPropertyFile);
		fileinput = new FileInputStream(sPathLog4jPropertyFile);
		log4jProp.load(fileinput);
		PropertyConfigurator.configure(log4jProp);
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) TestBase.browUtil.driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
