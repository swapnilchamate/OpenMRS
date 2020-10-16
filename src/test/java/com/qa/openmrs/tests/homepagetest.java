package com.qa.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.openmrs.base.TestBase;
import com.qa.openmrs.pages.ActiveVisitsPage;
import com.qa.openmrs.pages.AppointmentSchedulingPage;
import com.qa.openmrs.pages.HomePage;
import com.qa.openmrs.pages.LoginPage;
import com.qa.openmrs.pages.PatientRecordsPage;
import com.qa.openmrs.pages.RegisterPatientPage;

public class homepagetest extends TestBase {

	PatientRecordsPage findpatient;
	ActiveVisitsPage activevisits;
	RegisterPatientPage registerpatient;
	AppointmentSchedulingPage appointmentscheduling;
	HomePage homepage;
	LoginPage loginpage;
	
	public homepagetest(){
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
	}

	@Test(priority=0)
	public void validatehomepagelogotest(){
		boolean hplogo_disp=homepage.validatelogo();
		Assert.assertEquals(hplogo_disp, true,"HomePage logo not displayed");
	}
	
	@Test(priority=1)
	public void validateloginmessagetest(){
		String msgtext=homepage.validateloginmessge();
		Assert.assertEquals("Logged in as Super User", msgtext.substring(0, 23));
	}
	
	@Test(priority=2)
	public void goto_registerpatient(){
		registerpatient=homepage.registerpatient();
	}
	
	@Test(priority=3)
	public void goto_findpatientpage(){
		findpatient=homepage.findpatientrecord();
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
}
