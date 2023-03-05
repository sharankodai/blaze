package com.purchase_flight.SDP_Blazedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SDP_Blaze {
	public static WebDriver driver;
	private Home_page a;
	private Form_Filling ff;
	
	public SDP_Blaze(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	public Home_page getHome_page() {
		a= new Home_page(driver);
		return a;
	}

	public Form_Filling getForm_Filling() {
		ff= new Form_Filling(driver);
		return ff;
	}
}
