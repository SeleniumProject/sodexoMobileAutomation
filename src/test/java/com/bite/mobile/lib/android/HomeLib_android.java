package com.bite.mobile.lib.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Home_android;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeLib_android extends ScreenBase{

	/**
	 * author : Ramesh K
	 * Name of the Elements in the Page or Screen
	 */
	public String LetsStartbtn = "Lets Start ";
	public String LetsStart = "Lets Start ";
	public String allowbtn = "Allow";
	public String okbtn = "OK";
	public String searchLocationtxt = "Search Location";
	public String searchbtn = "Search Icon";
	public String locationList = "Location List";
	
	public HomeLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	/**
	 * This function used to launch the Bite Application, Search for Location and Select the Location
	 * @param location
	 * @throws Throwable
	 */
	public void launchApp() throws Throwable {
		try {
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "To Verify is User able to Tap on " + LetsStart, LetsStart + " Tapped successfully");
			Tap(639, 2230, LetsStart);
			Thread.sleep(200);
			Tap(665, 2434, LetsStart);
			Thread.sleep(2000);
			click(Home_android.allowbtn, allowbtn);
			Thread.sleep(2000);
			click(Home_android.okbtn, okbtn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	public void searchAndSelectLocation(String location) throws InterruptedException {
		
		Type(Home_android.searchlocationnametext, location, searchLocationtxt);
		Thread.sleep(2000);
		click(Home_android.searchButton, searchbtn);
		try {
			test.log(LogStatus.PASS, "To Verify is User able to click on on " + locationList, location + " Tapped successfully");
			Home_android.selectLocation(location, locationList);;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
