package com.bite.mobile.lib.android;
import org.openqa.selenium.By;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.CreateAccount_android;
import com.bite.mobile.screens.android.LinkCard_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
public class LinkCardLib_android extends ScreenBase{

	/**
	 * author : Ramesh K
	 * Name of the Elements in the Page or Screen
	 */
	public String linkcard ="Link Card";
	public String cardNumber ="Card Number";
	public String month ="Month";
	public String year="Year";
	public String cvvNum ="CVV";
	public String zipcodes="Zip Code";
	public String linkcardbtn="Link Card";
	
	
	public LinkCardLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);

	}
	
	public void FillCardDetails(String cardnum, String MM, String YYYY, String cvv, String zipCode) throws InterruptedException {
		Thread.sleep(2000);
		Thread.sleep(2000);
		LinkCard_android.clickLinkCard();
		//LongPressButton(LinkCard_android.linkcard);
		Thread.sleep(7000);
		Type(LinkCard_android.cardNumber, cardnum, cardNumber);
		Thread.sleep(2000);
		System.out.println("MOnth select");
		LongPressButton(LinkCard_android.month);
		Thread.sleep(2000);
		CreateAccount_android.selectValueFromPopUp(MM, month);
		Thread.sleep(2000);
        LongPressButton(LinkCard_android.year);
        Thread.sleep(2000);
		CreateAccount_android.selectValueFromPopUp(YYYY, year);
		Thread.sleep(2000);
		Thread.sleep(2000);
		Type(LinkCard_android.cvv, cvv, cvvNum);
		Thread.sleep(2000);
		Type(LinkCard_android.zipcode, zipCode, zipcodes);
		Thread.sleep(2000);
		LinkCard_android.clickLinkCard();
		Thread.sleep(2000);
	}

	
	
}
