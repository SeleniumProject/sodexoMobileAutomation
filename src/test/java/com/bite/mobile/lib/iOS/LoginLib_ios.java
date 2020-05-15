package com.bite.mobile.lib.iOS;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.ios.Login_iOS;

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
			waitforPageLoad(5);
              //Type(LoginScreen_android.emailedittxt, email, emailtxt);
              Type(Login_iOS.passwordtxt, password, passwordtxt);
              click(Login_iOS.SigninSignupbtn, signinbtn);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
