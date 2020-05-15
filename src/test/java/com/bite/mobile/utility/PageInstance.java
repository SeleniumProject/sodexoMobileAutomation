package com.bite.mobile.utility;

import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.android.CreateAccountLib_android;
import com.bite.mobile.lib.android.HomeLib_android;
import com.bite.mobile.lib.android.LinkCardLib_android;
import com.bite.mobile.lib.android.LoginLib_android;
import com.bite.mobile.lib.android.MenusLib_android;
import com.bite.mobile.lib.android.OrderLib_android;
import com.bite.mobile.lib.android.ReviewLib_android;
import com.bite.mobile.lib.iOS.CreateanAccountLib_ios;
import com.bite.mobile.lib.iOS.HomeLib_ios;
import com.bite.mobile.lib.iOS.LinkCardLib_ios;
import com.bite.mobile.lib.iOS.LoginLib_ios;
import com.bite.mobile.lib.iOS.MenusLib_ios;
import com.bite.mobile.lib.iOS.OrderLib_ios;
import com.bite.mobile.lib.iOS.ReviewLib_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageInstance extends TestBase{

	 

	public PageInstance(AppiumDriver<MobileElement> driver) {
		super();
	}

	/**
	 * Android instances
	 * @return
	 */
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
	
	/**
	 * iOS instances
	 * 
	 */
	
	public static  HomeLib_ios home_ios() {
		HomeLib_ios home_ios = new HomeLib_ios(driver);
		return home_ios;
	}

	public static LoginLib_ios login_ios() {
		LoginLib_ios login_ios = new LoginLib_ios(driver);
		return login_ios;
	}

	public static CreateanAccountLib_ios ca_ios() {
		CreateanAccountLib_ios ca_ios = new CreateanAccountLib_ios(driver);
		return ca_ios;
	}

	
	public static OrderLib_ios order_ios() {
		OrderLib_ios order_ios = new OrderLib_ios(driver);
		return order_ios;
	}
	
	public static MenusLib_ios menus_ios() {
		MenusLib_ios menus_ios = new MenusLib_ios(driver);
		return menus_ios;
	}

	public static LinkCardLib_ios card_ios() {
		LinkCardLib_ios card_ios = new LinkCardLib_ios(driver);
		return card_ios;
	}
	
	public static ReviewLib_ios review_ios() {
		ReviewLib_ios review_ios = new ReviewLib_ios(driver);
		return review_ios;
	}
}
