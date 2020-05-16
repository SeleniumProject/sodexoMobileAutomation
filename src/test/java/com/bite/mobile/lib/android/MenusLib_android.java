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
	public static String backbtn1="back arrow button from order screen";
	public static String backbtn2="back arrow button from Item details screen";
	public static String backbtn3="back arrow button from menuitem screen";
	
	public MenusLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public  void selectMenu(String menuType) throws InterruptedException {
		waitforPageLoad(5);		
		waitForElementpresent(Menus_android.menustab);
		LongPressButton(Menus_android.menustab);
		
		Menus_android.selectMenuItem(menuType);
	}
	
	public void selectOrder(String menutype) {
		try {
			LongPressButton(Menus_android.ordertab);
			waitforPageLoad(5);
			Menus_android.selectMenuItem(menutype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	public void selectMenuFromOrder(String menuItem) throws InterruptedException {
		waitforPageLoad(5);
		Menus_android.selectMenuItem(menuItem);
	}
	
	public void clickOnReviewOrder() throws InterruptedException {
		waitforPageLoad(5);
		Menus_android.clickOnReviewOrder();
		waitforPageLoad(5);
		
	}
	
	public void backToMainScreen() throws InterruptedException {
		waitforPageLoad(5);
		click(Menus_android.backbtnfromorder, backbtn1);
		waitforPageLoad(5);
		click(Menus_android.backbtnfromitemdetails, backbtn2);
		waitforPageLoad(5);
		click(Menus_android.backbtnfrommenuitem, backbtn3);
	}
	public void clickAddToMyOrder() throws InterruptedException {
		waitforPageLoad(5);
		Menus_android.clickAddToMyOrder();
		waitforPageLoad(5);
		Menus_android.clickAddToMyOrder();
	}
	public void selectItemFromOrderList(String item) throws InterruptedException {
		waitforPageLoad(5);
		Menus_android.selectItemFromOrders(item);
	}
	public void selectOrderTab() throws InterruptedException {
		waitForElementpresent(Menus_android.ordertab);
		LongPressButton(Menus_android.ordertab);
		waitforPageLoad(5);

	}
	
	public void selectPayTab() throws InterruptedException {
		waitforPageLoad(5);
		waitForElementpresent(Menus_android.paytab);
		LongPressButton(Menus_android.paytab);
		waitforPageLoad(5);
	}
	
	public void clickBitePay() throws InterruptedException {
		waitforPageLoad(5);
		LongPressButton(Menus_android.bitepaybtn);
	}
	public void LetsOrderButton() throws InterruptedException {
		waitforPageLoad(5);
		(new TouchAction(driver)).tap(639, 2415).perform();

//		LongPressButton(MenusScreen_android.letsorder);
	}
	public void selectDateAndItem(int day, String itemName) {
		try {
			waitforPageLoad(5);
			if (Menus_android.nomenutextdisplayed().isDisplayed()) {
				Menus_android.selectDate(day+1);
			} else {
				Menus_android.selectDate(day);
			}
			waitforPageLoad(5);
			Menus_android.selectMenuItem(itemName);
			waitforPageLoad(5);
		
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
