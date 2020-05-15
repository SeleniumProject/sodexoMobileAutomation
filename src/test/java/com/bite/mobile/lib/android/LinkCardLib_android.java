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
	public String addpaymentmethod="ADD PAYMENT METHOD";
	
	
	public LinkCardLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);

	}
	
	public void AddPaymentMethod() throws InterruptedException {
		waitforPageLoad(5);
		LongPressButton(LinkCard_android.AddPaymentMethod);
	}
	
	public void FillCardDetails(String cardnum, String MM, String YYYY, String cvv, String zipCode) throws InterruptedException {
		waitforPageLoad(5);
		LinkCard_android.clickLinkCard();
		//LongPressButton(LinkCard_android.linkcard);
		waitforPageLoad(5);
		Type(LinkCard_android.cardNumber, cardnum, cardNumber);
		waitforPageLoad(5);
		System.out.println("MOnth select");
		LongPressButton(LinkCard_android.month);
		waitforPageLoad(5);
		CreateAccount_android.selectValueFromPopUp(MM, month);
		waitforPageLoad(5);
        LongPressButton(LinkCard_android.year);
    	waitforPageLoad(5);
		CreateAccount_android.selectValueFromPopUp(YYYY, year);
		waitforPageLoad(5);
		Type(LinkCard_android.cvv, cvv, cvvNum);
		waitforPageLoad(5);
		Type(LinkCard_android.zipcode, zipCode, zipcodes);
		waitforPageLoad(5);
		LinkCard_android.clickLinkCard();
		waitforPageLoad(5);
	}

	
	
}
