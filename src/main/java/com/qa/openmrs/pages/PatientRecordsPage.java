package com.qa.openmrs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.openmrs.base.TestBase;

public class PatientRecordsPage extends TestBase {

	List<WebElement> recordslist;
	
	@FindBy(xpath="//input[@id='patient-search']")
	WebElement patient_search;
	
	
	public PatientRecordsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public int checkforrecords(String fName){
		patient_search.sendKeys(fName);
		
		recordslist=driver.findElements(By.xpath("//table[@id='patient-search-results-table']/tbody/tr//td[text()='"+fName+"']"));
		int list_size=recordslist.size();
		return list_size;
	}
	
}
