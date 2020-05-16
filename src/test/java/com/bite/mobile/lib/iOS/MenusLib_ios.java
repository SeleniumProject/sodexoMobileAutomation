package com.bite.mobile.lib.iOS;

import java.util.List;

import org.openqa.selenium.By;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Menus_android;
import com.bite.mobile.screens.ios.Menus_iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class MenusLib_ios extends ScreenBase{

	public static String backImageButtonFromLogout ="Back Arrow";
	public static String backImageFromProfile ="Back Arrow";
	public static String newstab ="NEWS Tab";
	public static String menustab= "MENUS tab";
	public static  String rewardstab =" REWARDS tab";
	public static String ordertab ="ORDER tab";
	public static String paytab="PAY tab";
	public static String letsorder="PAY tab";
	public static String menuitem="Menu ITem";
	
	public MenusLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public void selectOrderTab() throws InterruptedException {
		waitforPageLoad(10);
		LongPressButton(Menus_iOS.ordertab);
		waitforPageLoad(10);

	}
	
	public void selectMenuFromOrder() throws InterruptedException {
		waitForElementpresent(Menus_iOS.menuitems);
		LongPressButton(Menus_iOS.menuitems);
	}
	
	public void selectItemFromOrderList(String itemName) throws InterruptedException {
		waitforPageLoad(5);
		Menus_iOS.selectItemFromOrders(itemName);
	}
	
	public void SelectItemFromItemDetails(String meatname, String breadname) throws InterruptedException {
		waitforPageLoad(5);
		List<MobileElement> chk = driver.findElements(By.xpath("//*[@text='icn_radio_blue_off' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='"+meatname+"']]]]"));
		chk.get(0).click();
		waitforPageLoad(3);
		List<MobileElement> rdb = driver.findElements(By.xpath("//*[@text='checkbox_off' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[contains(text(),'"+breadname+"')]]]]"));
		chk.get(0).click();
		waitforPageLoad(3);
		
	}
	
	public void AddToMyOrder() throws InterruptedException {
		waitforPageLoad(10);
		LongPressButton(Menus_iOS.addtomyorder);
		waitforPageLoad(5);
		LongPressButton(Menus_iOS.addtomyorder);
	}
	public void LetsOrderButton() throws InterruptedException {
		waitforPageLoad(5);
		(new TouchAction(driver)).tap(639, 2415).perform();

//		LongPressButton(MenusScreen_android.letsorder);
	}
	public void OnReviewOrder() throws InterruptedException {
		waitforPageLoad(5);
		LongPressButton(Menus_iOS.revieworder);
		waitforPageLoad(5);
		
	}
	
	public void Login() throws InterruptedException {
		waitforPageLoad(5);
		LongPressButton(Menus_iOS.loginbtn);
	}
	public  void selectMenu(String menuType) throws InterruptedException {
		waitforPageLoad(5);
		waitForElementpresent(Menus_iOS.menustab);
		LongPressButton(Menus_iOS.menustab);
		waitforPageLoad(30);
		
		//Menus_iOS.selectMenuItem(menuType);
	}
	public void selectDate(String date) throws InterruptedException {
		waitforPageLoad(5);
		Menus_iOS.selectDate(date);
		
	}

	
	
}
