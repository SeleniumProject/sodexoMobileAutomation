package com.bite.mobile.lib.iOS;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Login_android;
import com.bite.mobile.screens.ios.Login_iOS;
import com.bite.mobile.screens.ios.Order_iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class OrderLib_ios extends ScreenBase {

	public String loginbtn = "LOGIN";
	public String emailtxt = "Email Address";
	public String passwordtxt = "Password";
	public String signin = "SIGN IN ";
	public String place = "Pick Up Place";
	public String time = "Pick Up Time";
	public String phone = "Phone Number ";

	public OrderLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void EnterPickUpPlace(String place) {
               click(Order_iOS.place, place);
               Order_iOS.clickDone();
	}

	public void PickUpTime(String time) {
	    click(Order_iOS.time, time);
        Order_iOS.clickDone();
	}

	public void PhoneNumber(String phonenumber) throws InterruptedException {
		waitforPageLoad(5);
          Type(Order_iOS.phonenumber, phonenumber, phone);
	}

	public void clickPayByCard() throws InterruptedException {
		waitforPageLoad(5);
		waitForElementpresent(Order_iOS.paybycard);
		LongPressButton(Order_iOS.paybycard);
	}
	public void PayAtPickUp() throws InterruptedException {
		waitforPageLoad(5);
		waitForElementpresent(Order_iOS.payatpickup);
		LongPressButton(Order_iOS.payatpickup);
	}
	
	
	public void Login(String email, String password) throws Throwable {
		try {
			waitForElementpresent(Order_iOS.loginbtn);
			LongPressButton(Order_iOS.loginbtn);
			Type(Login_iOS.emailtxt, email, emailtxt);
			waitForElementpresent(Login_iOS.emailtxt);
			Type(Login_iOS.passwordtxt, password, passwordtxt);
			waitforPageLoad(5);
			click(Login_iOS.signinbtn, signin);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
