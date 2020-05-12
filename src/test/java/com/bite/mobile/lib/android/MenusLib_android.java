package com.bite.mobile.lib.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Menus_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class MenusLib_android extends ScreenBase{

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
	
	public MenusLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public  void selectMenu(String menuType) throws InterruptedException {
		Thread.sleep(2000);
		
		LongPressButton(Menus_android.menustab);
//		waitForElementNoLongerPresent(60);
//		waitForLoadingNoLongerPresent(60);
		Menus_android.selectMenuItem(menuType);
	}
	
	public void selectOrder(String menutype) {
		try {
			LongPressButton(Menus_android.ordertab);
			Thread.sleep(3500);
//			waitForElementNoLongerPresent(60);
			Menus_android.selectMenuItem(menutype);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void selectMenuFromOrder() throws InterruptedException {
		Thread.sleep(7500);
		Menus_android.selectMenuItem("HBO Cafe Grill");
	}
	
	public void clickOnReviewOrder() throws InterruptedException {
		Thread.sleep(3000);
		Menus_android.clickOnReviewOrder();
		Thread.sleep(12000);
		
	}
	public void clickAddToMyOrder() throws InterruptedException {
		Thread.sleep(4000);
		Menus_android.clickAddToMyOrder();
		Thread.sleep(3000);
		Menus_android.clickAddToMyOrder();
	}
	public void selectItemFromOrderList(String item) throws InterruptedException {
		Thread.sleep(2000);
		Menus_android.selectItemFromOrders(item);
	}
	public void selectOrderTab() throws InterruptedException {
		Thread.sleep(3000);
		LongPressButton(Menus_android.ordertab);
		Thread.sleep(3500);

	}
	
	public void LetsOrderButton() throws InterruptedException {
		Thread.sleep(2000);
		(new TouchAction(driver)).tap(639, 2415).perform();

//		LongPressButton(MenusScreen_android.letsorder);
	}
	public void selectDateAndItem(int day, String itemName) {
		try {
			Thread.sleep(2000);
			if (Menus_android.nomenutextdisplayed().isDisplayed()) {
				Menus_android.selectDate(day+1);
			} else {
				Menus_android.selectDate(day);
			}
			Thread.sleep(2000);
			Menus_android.selectMenuItem(itemName);
			Thread.sleep(2000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void ReviewButton() {
		try {
			LongPressButton(Menus_android.reviewbtn);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

	
	
}
