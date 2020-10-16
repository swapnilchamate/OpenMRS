package com.qa.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.openmrs.base.TestBase;

public class RegisterPatientPage extends TestBase{

	@FindBy(xpath="//*[@class='logo']")
	WebElement registerpagelogo;

	@FindBy(xpath="//*[@id='content']//div[@id='content']/h2")
	WebElement header;

	@FindBy(xpath="//*[@class='question-legend focused']/span")
	WebElement name;

	@FindBy(xpath="//*[@class='question-legend']/span[@id='genderLabel']")
	WebElement gender;

	@FindBy(xpath="//*[@class='question-legend']/span[@id='birthdateLabel']")
	WebElement birthdate;
	
	@FindBy(xpath="//*[starts-with(@class,'question-legend')]/span[text()='Address']")
	WebElement Address_label;
	
	@FindBy(xpath="//*[starts-with(@class,'question-legend')]/span[text()='Phone Number']")
	WebElement PhoneNumber_label;
	
	@FindBy(xpath="//*[starts-with(@class,'question-legend')]/span[text()='Relatives']")
	WebElement Relative_label;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement Address1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement Address2;
	
	@FindBy(xpath="//input[@id='cityVillage']")
	WebElement City;
	
	@FindBy(id="stateProvince")
	WebElement State;
	
	@FindBy(id="country")
	WebElement Country;
	
	@FindBy(id="postalCode")
	WebElement PostalCode;

	@FindBy(xpath="//input[@name='givenName']")
	WebElement given;

	@FindBy(xpath="//input[@name='middleName']")
	WebElement middlename;

	@FindBy(xpath="//input[@name='familyName']")
	WebElement familyname;

	@FindBy(xpath="//*[@id='gender-field']")
	WebElement genderdrpdwn;

	@FindBy(xpath="//input[@id='birthdateDay-field']")
	WebElement birthdateDay;

	@FindBy(xpath="//input[@id='birthdateYear-field']")
	WebElement birthdateYear;

	@FindBy(xpath="//*[@id='birthdateMonth-field']")//
	WebElement birthdateMonth;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//*[@id='relationship_type']")
	WebElement relationType;
	
	@FindBy(xpath="//p[@class='left']/input[starts-with(@class,'person-typeahead')]")
	WebElement personName;
	
	@FindBy(xpath="//*[@id='confirmation_label']")
	WebElement confirm_label;
	
	@FindBy(xpath="//input[@id='submit']")
	WebElement confirm_btn;
	
	public RegisterPatientPage(){
		PageFactory.initElements(driver, this);
	}

	public boolean validateregisterpagelogo(){
		return registerpagelogo.isDisplayed();
	}

	public String validateheader(){
		return header.getText();
	}


	public void registerpatient(String givenname,String middle, String familyName, String Gender,
			String BirthDay, String BirthMonth, String BirthYear, String address1, String address2,
			String city, String state, String country, String postalcode,
			String PhoneNumber, String RelationshipType, String PersonName){

		given.sendKeys(givenname);
		middlename.sendKeys(middle);
		familyname.sendKeys(familyName);

		gender.click();
		//Select act=new Select(genderdrpdwn);
		//act.selectByValue(Gender);

		if (Gender.equalsIgnoreCase("male")) {
			driver.findElement(By.xpath("//*[@id='gender-field']/option[@value='M']")).click();
		} else if (Gender.equalsIgnoreCase("female")) {
			driver.findElement(By.xpath("//*[@id='gender-field']/option[@value='F']")).click();
		} 

		birthdate.click();
		birthdateDay.sendKeys(BirthDay);
		Select act=new Select(birthdateMonth);
		act.selectByVisibleText(BirthMonth);
		birthdateYear.sendKeys(BirthYear);
		
		Address_label.click();
		Address1.sendKeys(address1);
		Address2.sendKeys(address2);
		City.sendKeys(city);
		State.sendKeys(state);
		Country.sendKeys(country);
		PostalCode.sendKeys(postalcode);
		
		PhoneNumber_label.click();
		phoneNumber.sendKeys(PhoneNumber);
		
		Relative_label.click();
		Select act1=new Select(relationType);
		act1.selectByVisibleText(RelationshipType);
		personName.sendKeys(PersonName);
		
		confirm_label.click();
		
		confirm_btn.click();
		
	}

}

