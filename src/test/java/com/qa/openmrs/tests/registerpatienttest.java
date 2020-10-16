package com.qa.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

public class registerpatienttest extends TestBase {

	
	PatientRecordsPage findpatient;
	ActiveVisitsPage activevisits;
	RegisterPatientPage registerpatient;
	AppointmentSchedulingPage appointmentscheduling;
	HomePage homepage;
	LoginPage loginpage;
	
	public registerpatienttest(){
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
		registerpatient=homepage.registerpatient();
	}
	
	@Test(priority=1,enabled=false)
	public void validateregisterpagelogotest(){
		boolean logo_disp=registerpatient.validateregisterpagelogo();
		Assert.assertEquals(logo_disp, true);
	}
	
	@Test(priority=2,enabled=false)
	public void validateheadertest(){
		String act_header=registerpatient.validateheader();
		Assert.assertEquals(act_header, "Register a patient","Register patient page header is not matching");
	}

	@DataProvider(name="registerpatientdata")
	public Object[][] gettestdata(){
		Object data[][]=utils.getexceldata();
		return data;
	}
	
	@Test(dataProvider="registerpatientdata",priority=1,enabled=true)
	public void registerpatient(String givenname,String middle, String familyName, String Gender,
			String BirthDay, String BirthMonth, String BirthYear, String Address, String Address2,
			String City, String State, String Country, String PostalCode,
            String PhoneNumber, String RelationshipType, String PersonName){
		
		registerpatient.registerpatient(givenname, middle, familyName, Gender, BirthDay, BirthMonth, 
			BirthYear, Address, Address2, City,State, Country, PostalCode,PhoneNumber, RelationshipType, PersonName);
	
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
}
