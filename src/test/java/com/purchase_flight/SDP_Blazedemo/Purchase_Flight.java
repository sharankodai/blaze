package com.purchase_flight.SDP_Blazedemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Purchase_Flight extends Baseclass {

	WebDriver driver = null;
	SDP_Blaze ss;

	@BeforeTest
	public void browser_Launch() {
		driver = browserlaunch("chrome");
		implicit_wait();
	}

	@BeforeClass
	@SuppressWarnings("deprecation")
	public void url_Launch() {
		getUrl("https://blazedemo.com/");

	}

	@Test
	// departure city
	public void departure_City() {

		ss = new SDP_Blaze(driver);

		String depcity = "Portland";

		select(ss.getHome_page().getDep(), "text", depcity);

	}

	@Test(dependsOnMethods = "departure_City")
	// destination city // find flights
	public void destination_City() throws InterruptedException {
		Thread.sleep(3000);

		String descity = "Rome";

		select(ss.getHome_page().getDes(), "text", descity);

		Thread.sleep(2000);
		// find flights click

		click(ss.getHome_page().getFindflight());

	}

	@Test(dependsOnMethods = "destination_City")
	// Price
	public void price() throws InterruptedException {

		List<WebElement> prices = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
		List<Float> pricelist = new ArrayList<>();
		for (WebElement webElement : prices) {
			System.out.println("Prices: " + webElement.getText().replaceAll("[$]", ""));
			String replaceAll = webElement.getText().replaceAll("[$]", "");
			float parseFloat = Float.parseFloat(replaceAll);
			pricelist.add((float) parseFloat);

		}
		System.out.println("Price list::::" + pricelist);

		Float min = Collections.min(pricelist);
		System.out.println("minimum price:" + min);

		Thread.sleep(2000);
		// Airline name
		WebElement airlinename = driver
				.findElement(By.xpath("//table/tbody/tr/td[contains(text()," + min + ")]//preceding-sibling::td[3]"));
		System.out.println("Airline name: " + airlinename.getText());
		String air = airlinename.getText();

		// Flight no
		WebElement flightno = driver
				.findElement(By.xpath("//table/tbody/tr/td[contains(text()," + min + ")]//preceding-sibling::td[4]"));
		System.out.println("Flight no: " + flightno.getText());

		// choose the flight
		WebElement choose_the_flight = driver.findElement(
				By.xpath("//table/tbody/tr/td[contains(text()," + min + ")]//preceding-sibling::td[3][contains(text(),'"
						+ air + "')]//parent::tr//child::td/input[@type='submit']"));
//		choose_the_flight.click();
		click(choose_the_flight);

	}

	// enter the details
	@Test(dependsOnMethods = "price")
	public void enter_the_Details() throws InterruptedException {

		Thread.sleep(3000);

		sendKey(ss.getForm_Filling().getFirst_Name(), "sharan");

		sendKey(ss.getForm_Filling().getAddress(), "chooleimedu");

		sendKey(ss.getForm_Filling().getCity(), "chennai");

		sendKey(ss.getForm_Filling().getState(), "Tamilnadu");

		sendKey(ss.getForm_Filling().getZipCode(), "600094");

		select(ss.getForm_Filling().getCardType(), "text", "Visa");

		sendKey(ss.getForm_Filling().getCreditCardNumber(), "8786 0998 7655");

		clear(ss.getForm_Filling().getCreditCardMonth());
		sendKey(ss.getForm_Filling().getCreditCardMonth(), "03");

		clear(ss.getForm_Filling().getCreditCardYear());
		sendKey(ss.getForm_Filling().getCreditCardYear(), "2024");

		sendKey(ss.getForm_Filling().getNameOnCard(), "sharan");

		click(ss.getForm_Filling().getRememberMe());

		Thread.sleep(4000);

		click(ss.getForm_Filling().getPurchase_flight());

	}

	@Test(dependsOnMethods = "enter_the_Details")
	// screenshot
	public void screen_Shot() throws IOException {

		capture("Blazedemo");

	}

}