package com.bite.mobile.utility;

import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.android.CreateAccountLib_android;
import com.bite.mobile.lib.android.HomeLib_android;
import com.bite.mobile.lib.android.LinkCardLib_android;
import com.bite.mobile.lib.android.LoginLib_android;
import com.bite.mobile.lib.android.MenusLib_android;
import com.bite.mobile.lib.android.OrderLib_android;
import com.bite.mobile.lib.android.ReviewLib_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageInstance extends TestBase{

	 

	public PageInstance(AppiumDriver<MobileElement> driver) {
		super();
	}

	public static  HomeLib_android home() {
		HomeLib_android home = new HomeLib_android(driver);
		return home;
	}

	public static LoginLib_android login() {
		LoginLib_android login = new LoginLib_android(driver);
		return login;
	}

	public static CreateAccountLib_android createAccount() {
		CreateAccountLib_android ca = new CreateAccountLib_android(driver);
		return ca;
	}

	public static ReviewLib_android review() {
		ReviewLib_android review = new ReviewLib_android(driver);
		return review;
	}

	public static OrderLib_android order() {
		OrderLib_android order = new OrderLib_android(driver);
		return order;
	}
	
	public static MenusLib_android menus() {
		MenusLib_android menus = new MenusLib_android(driver);
		return menus;
	}

	public static LinkCardLib_android card() {
		LinkCardLib_android card = new LinkCardLib_android(driver);
		return card;
	}
}
