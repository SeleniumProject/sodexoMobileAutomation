package com.bite.mobile.lib.android;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.LoginScreen_android;
import com.bite.mobile.screens.android.MenusScreen_android;
import com.bite.mobile.screens.android.ReviewScreen_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ReviewScreenLib_android extends ScreenBase{

	/**
	 * author : Ramesh K
	 * Name of the Elements in the Page or Screen
	 */
	public String pleaserateyourexp ="Pease rate your experience";
	public String emoji ="Emoji";
	public String didyouenjoy= "Did you enjoy this dish?";
	public String wasitagood;
	public String wouldyoueat;
	public String howlikely;
	public String tellusabout ="Tell us about your experience";
	public String commentstxt ="Describe your experience";
	public String submitbtn ="Survey button";
	public String backbuttonfromreview ="Back Arrow";
	public String backfromreceipedetails ="Back Arrow";
	public String backfromdateitem ="Back Arrow";
	
	public ReviewScreenLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);

	}

	public void fillReview(String comment) throws InterruptedException {
		Thread.sleep(2000);
		Type(ReviewScreen_android.commentstxt, comment, commentstxt);
		Thread.sleep(2000);
		click(ReviewScreen_android.submitbtn, submitbtn);
	}

	public void backToOrderMenu() {
		click(ReviewScreen_android.backbtn, submitbtn);
		click(ReviewScreen_android.backbntn1, backfromreceipedetails);
		click(ReviewScreen_android.backbntn2, backfromdateitem);
		
	}
}
