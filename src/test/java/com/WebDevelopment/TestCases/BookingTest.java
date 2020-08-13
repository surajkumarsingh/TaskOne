package com.WebDevelopment.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.WebDevelopment.PageObject.BaseClass;
import com.WebDevelopment.PageObject.Flights;

public class BookingTest extends BaseClass {

	Flights fl;

	@BeforeClass

	public void init() {
		fl = new Flights(driver);

	}

	@Test

	public void flightBooking() {

		fl.setSourceAndDestination("Delhi (DEL)", "Mumbai (BOM)");
		fl.chooseFlights();
		fl.checkOut("fName", "lname", "Email@mail.com", "4565453343");

	}

}
