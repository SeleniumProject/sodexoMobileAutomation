package com.bite.mobile.lib.iOS;

import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginLib_ios extends ScreenBase{

	public String SignSignUpBtn = "SIGN IN / SIGN UP";
	public String emailtxt = "Email address";
	public String passwordtxt = "Password";
	public String signinbtn = "SignIn";
	
	public LoginLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void Login(String email, String password) throws Throwable {
		try {

            Thread.sleep(3000);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
