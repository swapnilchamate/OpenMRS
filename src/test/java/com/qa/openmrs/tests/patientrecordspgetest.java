package com.qa.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openmrs.base.TestBase;
import com.qa.openmrs.pages.ActiveVisitsPage;
import com.qa.openmrs.pages.AppointmentSchedulingPage;
import com.qa.openmrs.pages.HomePage;
import com.qa.openmrs.pages.LoginPage;
import com.qa.openmrs.pages.PatientRecordsPage;
import com.qa.openmrs.pages.RegisterPatientPage;
import com.qa.openmrs.utils.utils;

public class patientrecordspgetest extends TestBase{

	PatientRecordsPage findpatient;
	ActiveVisitsPage activevisits;
	RegisterPatientPage registerpatient;
	AppointmentSchedulingPage appointmentscheduling;
	HomePage homepage;
	LoginPage loginpage;

	public patientrecordspgetest(){
		super();
	}

	@BeforeMethod
	public void Setup(){
		initialization();
		homepage=new HomePage();
		findpatient=new PatientRecordsPage();
		activevisits=new ActiveVisitsPage();
		registerpatient=new RegisterPatientPage();
		appointmentscheduling = new AppointmentSchedulingPage();
		loginpage = new LoginPage();

		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("location"));
		findpatient=homepage.findpatientrecord();

	}


	@DataProvider(name="getPatientName")
	public Object[][] checkpatientrecord(){
		Object data[][]=utils.getNameexceldata();
		return data;
	}

	@Test(dataProvider="getPatientName", enabled=true)
	public void findpatientthroughsearch(String givenname,String middle, String familyName){

		String fullName= givenname+" "+middle+" "+familyName;

		int records=findpatient.checkforrecords(fullName);
		if (records>0) {
			System.out.println("Record Present");
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Record not Present");
			Assert.assertTrue(false);
		}
	}


	@AfterTest
	public void TearDown(){
		//driver.quit();
	}
}
