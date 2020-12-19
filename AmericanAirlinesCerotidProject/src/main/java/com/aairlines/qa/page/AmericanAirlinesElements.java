package com.aairlines.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aairlines.qa.base.TestBase;

public class AmericanAirlinesElements extends TestBase {

	//Page Factory
	@FindBy(xpath="//*[@id=\'main-navigation\']/div[1]/h1/a/img")
	WebElement Logo;
	@FindBy(xpath="//*[@id='jq-findFlights']")
	WebElement Book;
	@FindBy(xpath="//*[@id='reservationFlightSearchForm']/div[1]/div/ul/li[1]/label/span[2]")
	WebElement Flight;
	@FindBy(xpath="//*[@id='bookingCheckboxContainer']/div[1]/div[1]/label/span[3]")
	WebElement RoundTrip;
	@FindBy(xpath="//*[@id='reservationFlightSearchForm.originAirport']")
	WebElement From;
	@FindBy(xpath="//*[@id='reservationFlightSearchForm.destinationAirport']")
	WebElement To;
	@FindBy(xpath="//*[@id='flightSearchForm.adultOrSeniorPassengerCount']")
	WebElement Passengers;
	@FindBy(xpath="//*[@id='aa-leavingOn']")
	WebElement Depart;
	@FindBy(xpath="//*[@id='aa-returningFrom']")
	WebElement Return;
	@FindBy(xpath="//*[@id='flightSearchForm.button.reSubmit']")
	WebElement Search;

	//Initializing the Page Objects
	public AmericanAirlinesElements()throws Throwable{
	 PageFactory.initElements(driver, this);
	}
	public String homePageTitleValidation() {
		return driver.getTitle();
	}
	public boolean aairlinesLogoValidation() {
		return Logo.isDisplayed();
	}
	public ChooseFlightPage bookFlight(String strFrom, String strTo, String strDD, String strRD) throws Throwable{
		try {
		Book.click();
		Flight.click();
		RoundTrip.click();
		Thread.sleep(5000);
		From.sendKeys(strFrom);
		To.sendKeys(strTo);
		Select sel = new Select(Passengers);
		sel.selectByIndex(1);
		Depart.sendKeys(strDD);
		Return.sendKeys(strRD);
		Thread.sleep(5000);
		Search.click();

		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ChooseFlightPage();	
		}
	
}
