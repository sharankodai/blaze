package com.purchase_flight.SDP_Blazedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form_Filling {
public static WebDriver driver;
	
	public Form_Filling(WebDriver driver1) {
		this.driver =driver1;
		PageFactory.initElements(driver, this);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirst_Name() {
		return first_Name;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getCreditCardMonth() {
		return creditCardMonth;
	}

	public WebElement getCreditCardYear() {
		return creditCardYear;
	}

	public WebElement getNameOnCard() {
		return nameOnCard;
	}

	public WebElement getRememberMe() {
		return rememberMe;
	}

	public WebElement getPurchase_flight() {
		return purchase_flight;
	}

	@FindBy (xpath="//input[@id='inputName']")
	private WebElement first_Name;
	
	@FindBy (xpath="//input[@id='creditCardNumber']")
	private WebElement creditCardNumber;
	
	@FindBy (id="address")
	private WebElement address;
	
	public WebElement getCreditCardNumber() {
		return creditCardNumber;
	}

	@FindBy (id="city")
	private WebElement city;
	
	@FindBy (id="state")
	private WebElement state;
	
	@FindBy (id="zipCode")
	private WebElement zipCode;
	
	@FindBy (id="cardType")
	private WebElement cardType;
	
	@FindBy (id="creditCardMonth")
	private WebElement creditCardMonth;
	
	@FindBy (id="creditCardYear")
	private WebElement creditCardYear;
	
	@FindBy (id="nameOnCard")
	private WebElement nameOnCard;
	
	@FindBy (id="rememberMe")
	private WebElement rememberMe;
	
	@FindBy (xpath="//input[@class='btn btn-primary']")
	private WebElement purchase_flight;



	
}
