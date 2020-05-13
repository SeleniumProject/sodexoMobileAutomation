package com.bite.mobile.lib.iOS;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.CreateAccount_android;
import com.bite.mobile.screens.android.LinkCard_android;
import com.bite.mobile.screens.ios.LinkCard_iOS;
import com.bite.mobile.screens.ios.Login_iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LinkCardLib_ios extends ScreenBase{

	public String cardholdername ="Name on card";
	public String cardNumber ="Card Number";
	public String month ="Month";
	public String year="Year";
	public String cvvNum ="CVV";
	public String zipcodes="Zip Code";
	public String linkcardbtn="Link Card";
	
	public LinkCardLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void FillCardDetails(String nameoncard, String cardnum, String MM, String YY, String cvv) throws InterruptedException {
		waitforPageLoad(5);
		Type(LinkCard_iOS.nameoncard, nameoncard, cardholdername);
		waitforPageLoad(5);
		Type(LinkCard_iOS.cardNumber, cardnum, cardNumber);
		waitforPageLoad(5);
		System.out.println("MOnth select");
		Type(LinkCard_iOS.month, MM, month);
		waitforPageLoad(5);
		Type(LinkCard_iOS.month, YY, year);
		waitforPageLoad(5);
		Type(LinkCard_android.cvv, cvv, cvvNum);
		waitforPageLoad(5);
		LongPressButton(LinkCard_iOS.submit);
	}
}
