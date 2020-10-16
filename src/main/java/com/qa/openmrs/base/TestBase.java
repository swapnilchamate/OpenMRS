package com.qa.openmrs.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.qa.openmrs.utils.utils;
import com.sun.jna.platform.FileUtils;

public class TestBase {

	/*author: Swapnil Chamate  -updated  */
	
	public static WebDriver driver;
	public static Properties prop;
	public static String browsername;

	public TestBase(){
		prop = new Properties();
		File src = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com"
				+ "\\qa\\openmrs\\config\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization(){
		browsername= prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SoftWare\\Browser_Drivers\\chromedriver_win32_2\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver","E:\\SoftWare\\Browser_Drivers\\geckodriver-v0.19.1-win32\\geckodriver.exe" );
			driver=new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser Type");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
	}
	
	
}