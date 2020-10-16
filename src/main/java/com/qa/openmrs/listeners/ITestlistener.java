package com.qa.openmrs.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.openmrs.base.TestBase;
import com.qa.openmrs.utils.utils;

public class ITestlistener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started:"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case Successfully Passed:"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case Failed:"+result.getName());
		utils.failed(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case Skipped:"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case FailedButWithinSuccessPercentage:"+result.getName());
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite Started:"+context.getName());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite Finished:"+context.getName());
	}

}
