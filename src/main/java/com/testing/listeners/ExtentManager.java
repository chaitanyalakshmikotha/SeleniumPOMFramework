package com.testing.listeners;

import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static ExtentReports createReport() {

		Logger log = Logger.getLogger(ExtentManager.class);
		String sPath = System.getProperty("user.dir") + "//Reports//TestReport.html";
		return extent = new ExtentReports(sPath);
	}

}
