package com.aairlines.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aairlines.qa.base.TestBase;
import com.aairlines.qa.page.ChooseFlightPage;
import com.aairlines.qa.page.AmericanAirlinesElements;
import com.aairlines.qa.util.ScreenShotUtil;

public class AmericanAirlinesHomePageTest extends TestBase {
	AmericanAirlinesElements homepage;
	ChooseFlightPage chooseflightpage;
	ScreenShotUtil screenshotutil;
	
	public AmericanAirlinesHomePageTest() throws Throwable {
		super();
		}
	@BeforeMethod
	public void setup() throws Throwable {
		
try {
		Initialization();
		homepage = new AmericanAirlinesElements();
		chooseflightpage = new ChooseFlightPage();
		screenshotutil = new ScreenShotUtil();
}
catch(Exception e) {
	e.printStackTrace();
}
	}
	@Test(priority=1)
	public void homePageTitleTest() {
		try {
		String title=homepage.homePageTitleValidation();
		Assert.assertEquals(title, "American Airlines - Airline tickets and cheap flights at aa.com");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void homePageLogoTest() throws IOException, InterruptedException {
		try {
		boolean image= homepage.aairlinesLogoValidation();
		Assert.assertTrue(image);
		Thread.sleep(5000);
		screenshotutil.takeAAScreenshot(driver, "logo");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	public void bookFlightTest() throws Throwable {
		try {
		chooseflightpage =homepage.bookFlight(prop.getProperty("From"), prop.getProperty("To"), prop.getProperty("Depart"),prop.getProperty("Return"));
		Thread.sleep(5000);
		screenshotutil.takeAAScreenshot(driver, "npage");
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	@AfterMethod 
		  public void tearDown() {
			  driver.quit(); } 
}

