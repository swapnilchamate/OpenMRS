package com.qa.openmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.openmrs.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//*[@class='logo']")
	WebElement homepagelogo;

	@FindBy(xpath="//*[@class='logout']")
	WebElement logout_link;

	@FindBy(xpath="//*[@id='home-container']/h4")
	WebElement loginmessage;

	@FindBy(id="coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	WebElement findpatientrecord;

	@FindBy(id="org-openmrs-module-coreapps-activeVisitsHomepageLink-"
			+ "org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")
	WebElement activevisits;

	@FindBy(id="referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-"
			+ "registrationapp-registerPatient-homepageLink-extension")
	WebElement registerpatient;

	@FindBy(id="referenceapplication-vitals-referenceapplication-vitals-extension")
	WebElement capturevitals;

	@FindBy(id="appointmentschedulingui-homeAppLink-"
			+ "appointmentschedulingui-homeAppLink-extension")
	WebElement appointmentscheduling;

	@FindBy(id="reportingui-reports-homepagelink-reportingui-reports-homepagelink-extension")
	WebElement reports;

	@FindBy(id="coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension")
	WebElement datamanagement;

	@FindBy(id="org-openmrs-module-adminui-configuremetadata-homepageLink-org-"
			+ "openmrs-module-adminui-configuremetadata-homepageLink-extension")
	WebElement configuremetadata;

	@FindBy(id="coreapps-systemadministration-homepageLink-coreapps-"
			+ "systemadministration-homepageLink-extension")
	WebElement SystemAdministration;


	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	public boolean validatelogo(){
		return homepagelogo.isDisplayed();
	}

	public String validateloginmessge(){
		//System.out.println(loginmessage.getText().substring(0,23));
		return loginmessage.getText();
	}

	public RegisterPatientPage registerpatient(){
		registerpatient.click();
		return new RegisterPatientPage();
	}

	public PatientRecordsPage findpatientrecord(){
		findpatientrecord.click();
		return new PatientRecordsPage();
	}
	
	
}