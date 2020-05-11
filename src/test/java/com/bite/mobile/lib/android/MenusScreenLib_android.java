package com.bite.mobile.lib.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.MenusScreen_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MenusScreenLib_android extends ScreenBase{

	/**
	 * author : Ramesh K
	 * Name of the Elements in the Page or Screen
	 */
	public static String backImageButtonFromLogout ="Back Arrow";
	public static String backImageFromProfile ="Back Arrow";
	public static String newstab ="NEWS Tab";
	public static String menustab= "MENUS tab";
	public static  String rewardstab =" REWARDS tab";
	public static String ordertab ="ORDER tab";
	public static String paytab="PAY tab";
	public static String nomenufortheday="No menu for this day";
	
	public MenusScreenLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public  void selectMenu(String menuType) throws InterruptedException {
		Thread.sleep(2000);
		
		LongPressButton(MenusScreen_android.menustab);
//		waitForElementNoLongerPresent(60);
//		waitForLoadingNoLongerPresent(60);
		MenusScreen_android.selectMenuItem(menuType);
	}
	
	public void selectOrder(String menutype) {
		try {
			LongPressButton(MenusScreen_android.ordertab);
			Thread.sleep(3500);
//			waitForElementNoLongerPresent(60);
			MenusScreen_android.selectMenuItem(menutype);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void selectDateAndItem(int day, String itemName) {
		try {
			Thread.sleep(2000);
			if (MenusScreen_android.nomenutextdisplayed().isDisplayed()) {
				MenusScreen_android.selectDate(day+1);
			} else {
				MenusScreen_android.selectDate(day);
			}
			Thread.sleep(2000);
			MenusScreen_android.selectMenuItem(itemName);
			Thread.sleep(2000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void ReviewButton() {
		try {
			LongPressButton(MenusScreen_android.reviewbtn);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

	
	
}
