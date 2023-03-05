package com.purchase_flight.SDP_Blazedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	public static WebDriver driver;
	
	public Home_page(WebDriver driver1) {
		this.driver =driver1;
		PageFactory.initElements(driver, this);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getDep() {
		return dep;
	}

	public WebElement getDes() {
		return des;
	}

	public WebElement getFindflight() {
		return findflight;
	}

	@FindBy (xpath="//select[@name='fromPort']")
	private WebElement dep;
	
	@FindBy (xpath="//select[@name='toPort']")
	private WebElement des;
	
	@FindBy (xpath="//input[@value='Find Flights']")
	private WebElement findflight;
	

}
