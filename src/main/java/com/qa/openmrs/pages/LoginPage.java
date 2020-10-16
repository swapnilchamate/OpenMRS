package com.qa.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.openmrs.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//div[@class='logo']")
	WebElement logo;

	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(id="Inpatient Ward")
	WebElement location;

	@FindBy(id="loginButton")
	WebElement loginbtn;

	@FindBy(xpath="//*[@id='cantLogin']")
	WebElement cant_login_link;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}



	public HomePage login(String usrname, String pswd, String location){
		username.sendKeys(usrname);
		password.sendKeys(pswd);

		driver.findElement(By.id(location)).click();
		loginbtn.click();

		return new HomePage();
	}

	public boolean validatelogo(){
		return logo.isDisplayed();
	}

	public String validatetitle(){
		return driver.getTitle();
	}

	public boolean validate_link(){
		return cant_login_link.isDisplayed();
	}
}



