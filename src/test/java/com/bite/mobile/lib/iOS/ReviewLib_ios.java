package com.bite.mobile.lib.iOS;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Login_android;
import com.bite.mobile.screens.android.Menus_android;
import com.bite.mobile.screens.android.Review_android;
import com.bite.mobile.screens.ios.Order_iOS;
import com.bite.mobile.screens.ios.Review_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;

public class ReviewLib_ios extends ScreenBase{

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
	public String reviewbtn ="REVIEW button";
	public String angryemoji ="Angry";
	public String sademoji ="Sad";
	public String smileemoji ="Smile";
	public String happyemoji ="Happy";
	
	
	
	public ReviewLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);

	}

	public void submitReview() throws InterruptedException {
//		LongPressButton(Review_ios.donebtn);
		waitforPageLoad(5);
		LongPressButton(Review_ios.submitbtn);
		
	}
	
	public void clickSmileEmoji() throws InterruptedException {
		waitforPageLoad(5);
		LongPressButton(Review_ios.smile);
	}
	
	public void closePopUP() throws InterruptedException {
		waitforPageLoad(5);
		waitForElementpresent(Review_ios.closepopup);
		LongPressButton(Review_ios.closepopup);
	}
	public void EnterExperienceComments(String value) throws InterruptedException {
		waitforPageLoad(5);
		Type(Review_ios.commentstxt, value, commentstxt);
		waitforPageLoad(5);
		((IOSDriver<MobileElement>) driver).hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE); // Done can change to whatever valid on our screen
		
	}
	public void pleaseRateYourExperience() throws InterruptedException {
		waitForElementpresent(Review_ios.smile);
		LongPressButton(Review_ios.smile);
	}
	public void clickReview() {
		waitForElementpresent(Review_ios.reviewbtn);
		click(Review_ios.reviewbtn, reviewbtn);
	}


	public void backToOrderMenu() throws InterruptedException {
		
		waitForElementpresent(Review_ios.backbtn);
		click(Review_ios.backbtn, backbuttonfromreview);
		waitforPageLoad(5);
		Review_ios.backButton();
		
	}
}
