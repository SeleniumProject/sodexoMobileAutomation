package com.bite.mobile.lib.iOS;

import org.openqa.selenium.Point;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Home_android;
import com.bite.mobile.screens.ios.Home_iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeLib_ios extends ScreenBase{

	public String LetsStartbtn = "Lets Start ";
	public String LetsStart = "Lets Start ";
	public String allowbtn = "Allow";
	public String okbtn = "OK";
	public String searchLocationtxt = "Search Location";
	public String searchbtn = "Search Icon";
	public String locationList = "Location List";
	
	public HomeLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	/**
	 * This function used to launch the Bite Application, Search for Location and Select the Location
	 * @param location
	 * @throws Throwable
	 */
	public void LaunchApp(String location) throws Throwable {
		try {
			//Tap(639, 2230, LetsStart);
			//Tap(665, 2434, LetsStart);
//			click(HomeScreen_iOS.allowbtn, allowbtn);
//			LongPressButton(Home_iOS.okbtn);
//			 if(Home_iOS.isOkPopUpDisplayed().isDisplayed()) {
//				
//				
//				LongPressButton(Home_iOS.okbtn);
//					}
//			 else if (Home_iOS.isNewsElementDisplayed().isDisplayed()) {
//				Home_iOS.clickOnExistingLocation();
//				waitforPageLoad(5);
//				LongPressButton(Home_iOS.findnewlocation);
//				waitforPageLoad(5);				
//			}
//			else if (Home_iOS.isLetsStartDisplayed().isDisplayed()) {
//				waitforPageLoad(5);	
//				LongPressButton(Home_iOS.LetsStart);
//				waitforPageLoad(5);	
//				LongPressButton(Home_iOS.allowbtn);
//				waitforPageLoad(5);	
//			}
			Home_iOS.clickOnExistingLocation();
			waitforPageLoad(5);		
			Type(Home_iOS.searchlocationnametext, location, searchLocationtxt);
			Thread.sleep(3000);
			LongPressButton(Home_iOS.searchButton);
			waitforPageLoad(5);		
			LongPressButton(Home_iOS.iconlocationhistory);
			waitforPageLoad(5);	
           Home_iOS.clickPreviousLocation("CROSSROADS CAFE");
//			click(HomeScreen_iOS.searchButton, searchbtn);
			waitforPageLoad(5);		
			
//			HomeScreen_iOS.selectLocation();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
