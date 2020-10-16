package com.qa.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.openmrs.base.TestBase;
import com.qa.openmrs.pages.HomePage;
import com.qa.openmrs.pages.LoginPage;

public class loginpagetest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public loginpagetest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=-2,enabled=true)
	public void validatelogotest(){
		boolean logo_disp=loginpage.validatelogo();
		Assert.assertEquals(logo_disp, true,"logo is not displayed");
	}
	
	@Test(priority=-1,enabled=true)
	public void validatetitle(){
		String act_title=loginpage.validatetitle();
		Assert.assertEquals(act_title,"Login1");
	}
	
	@Test(priority=3,enabled=true)
	public void logintest(){
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("location"));
	}
	
	@Test(priority=0,enabled=true)
	public void validatelinktest(){
		boolean link_disp=loginpage.validate_link();
		Assert.assertEquals(link_disp, true);
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
}
