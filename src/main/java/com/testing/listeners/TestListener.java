package com.testing.listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testing.Utilities.CommonUtils;

public class TestListener extends ExtentManager implements ITestListener {

	public static ExtentReports extent = ExtentManager.createReport();
	public static ExtentReports reports;
	public static ExtentTest test;
	Logger log = Logger.getLogger(TestListener.class);

	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}

	public void onTestFailure(ITestResult result) {
		try {
			System.out.println("on test failure");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
			CommonUtils.takeScreenshotAtEndOfTest();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test sucess within percentage");
	}

	public void onStart(ITestContext context) {
		System.out.println("on start");
		createReport();
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
	}

	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		reports.endTest(test);
		reports.flush();
	}

}
