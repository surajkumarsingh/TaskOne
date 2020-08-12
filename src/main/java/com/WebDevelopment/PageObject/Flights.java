package com.WebDevelopment.PageObject;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Flights extends BaseClass {

	WebDriver driver;

	/**
	 * Parameterize Constructor
	 * 
	 * @param driver
	 */
	public Flights(WebDriver driver) {

		PageFactory.initElements(driver, this);

		this.driver = driver;
	}

	/**
	 * Source {@link WebElement}
	 *
	 */
	@FindBy(id = "gosuggest_inputSrc")

	public WebElement source;

	/**
	 * Destination {@link WebElement}
	 * 
	 */
	@FindBy(id = "gosuggest_inputDest")

	public WebElement destination;

	/**
	 * departure Date {@link WebElement}
	 * 
	 */
	@FindBy(id = "departureCalendar")

	public WebElement departureCalendar;

	@FindBy(id = "returnCalendar")

	public WebElement returnCalendar;

	/**
	 * Search {@link WebElement}
	 * 
	 */
	@FindBy(id = "gi_search_btn")

	public WebElement search;
	/**
	 * Modify Search Button {@link WebElement}
	 * 
	 */
	@FindBy(xpath = "//button[contains(text(),'Modify search and try again')]")

	public WebElement modifySearchBtn;

	@FindBy(xpath = "//div[contains(@class,'fltHpyOnwrdWrp')]//span[contains(@class,'hpyBlueLt')][contains(text(),'PRICE')]")

	public WebElement priceMaxOfdep;

	@FindBy(xpath = "//div[contains(@class,'fltHpyRtrnWrp')]//span[contains(@class,'hpyBlueLt')][contains(text(),'PRICE')]")

	public WebElement priceMaxOfRtr;

	@FindBy(xpath = "//div[contains(@class,'dF justifyBetween alignItemsEnd padTB10')]//span[text()='DEL']//following::span[text()='BOM']//following::input[@type='radio']")
	public WebElement radioBtnDelMum;

	@FindBy(xpath = "//div[contains(@class,'dF justifyBetween alignItemsEnd padTB10')]//span[text()='BOM']//following::span[text()='DEL']//following::input[@type='radio']")
	public WebElement radioBtnMumDel;

	@FindBy(xpath = "//input[contains(@class,'button fr fltbook fb widthF105 quicks fb')]")
	public WebElement bookBtn;

	@FindBy(xpath = "//input[@id='secure-trip']")
	public WebElement secureTripRadioBtn;

	@FindBy(xpath = "//select[@id='Adulttitle1']")
	public WebElement selectTitle;

	@FindBy(xpath = "//input[contains(@placeholder,'First Name/Given Name')]")
	public WebElement firstName;

	@FindBy(xpath = "//input[contains(@placeholder,'Middle Name')]")
	public WebElement middletName;

	@FindBy(xpath = "//input[contains(@placeholder,'Last Name/Surname')]")
	public WebElement lastName;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@id='mobile']")
	public WebElement mobileNo;

	@FindBy(xpath = "//form[@id='travellerForm']//div//button")
	public WebElement ProceedBtn;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement OkBtn;

	@FindBy(xpath = "//span[contains(text(),'Skip to Payment')]")
	public WebElement skipToPaymentBtn;

	@FindBy(xpath = "//span[contains(text(),'Wallets')]")
	public WebElement WalletOption;

	@FindBy(id = "amazonpay")
	public WebElement amazonpayRadioBtn;

	

	/**
	 * 
	 * input source, destination, set current date and search.
	 * 
	 * @param Source {@link String}
	 * @param Des    {@link String}
	 * @throws InterruptedException
	 */
	public void setSourceAndDestination(String Source, String Des)  {

		departureCalendar.click();
		driver.findElement(By.xpath("//div[@aria-label='" + date.getJourneyDate() + "']")).click();
		returnCalendar.click();
		driver.findElement(By.xpath("//div[@aria-label='" + date.getreturningDate() + "']")).click();

		source.sendKeys(Source);

		WebElement srctarget = driver.findElement(By.xpath("//span[contains(text(),'Delhi')]"));

		wait.until(ExpectedConditions.elementToBeClickable(srctarget)).click();

		// action.moveToElementAndclick(srctarget);
		destination.sendKeys(Des);
		WebElement desTarget = driver.findElement(By.xpath("//span[contains(text(),'Mumbai')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Mumbai')]")))
				.click();
//	    js.click(desTarget);
		// action.moveToElementAndclick(desTarget);
////		Thread.sleep(3000);
		search.click();

	}

	public void chooseFlights() {

		priceMaxOfdep.click();
		priceMaxOfRtr.click();

		js.click(radioBtnDelMum);
		bookBtn.click();

	}
	
	
	public void checkOut(String fName, String lname, String Email, String phone) {
		
		secureTripRadioBtn.click();
		
		System.out.println("Please Enter Details FirstName, LastName, Email and Phone Number each seperated by Space");
		//travelerDatails
		select.selectByVisibleText(selectTitle, "Mr");
		firstName.sendKeys(fName);
		lastName.sendKeys(lname);
		email.sendKeys(Email);
		mobileNo.sendKeys(phone);
		ProceedBtn.click();
		OkBtn.click();
		skipToPaymentBtn.click();
		WalletOption.click();
		amazonpayRadioBtn.click();
		
	}

	
}
