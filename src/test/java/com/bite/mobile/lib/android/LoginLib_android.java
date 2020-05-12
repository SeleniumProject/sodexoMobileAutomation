package com.bite.mobile.lib.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Login_android;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginLib_android extends ScreenBase{

	/**
	 * author : Ramesh K
	 * Name of the Elements in the Page or Screen
	 */
	public String SignSignUpBtn = "SIGN IN / SIGN UP";
	public String emailtxt = "Email address";
	public String passwordtxt = "Password";
	public String signinbtn = "SignIn";
	
	public LoginLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);

	}

	public void Login(String email, String password) throws Throwable {
		try {
			Thread.sleep(2000);
              //Type(LoginScreen_android.emailedittxt, email, emailtxt);
              Type(Login_android.passwordedittxt, password, passwordtxt);
              click(Login_android.signinsignupbtn, signinbtn);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
