package com.bite.mobile.screens.ios;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Menus_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Menus_iOS extends ScreenBase {
	public Menus_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);

	}
	public static By backImageButtonFromLogout;
	public static By backImageFromProfile;
	public static By newstab;
	public static By menustab;
	public static By rewardstab;
	public static By ordertab;
	public static By paytab;
	public static By menuitems;
	public static By date;
	public static By item;
	public static By reviewbtn;
	public static By addtomyorder;
	public static By revieworder;
	public static By loginbtn;

	

	static {
		
		//backImageButtonFromLogout = By.xpath("//android.widget.ImageButton");
		//backImageFromProfile = By.xpath("//android.widget.ImageButton");
		newstab = By.xpath("//*[@text='NEWS']");
		menustab = By.xpath("//*[@text='MENUS']");
		rewardstab = By.xpath("//*[@text='REWARDS']");
		ordertab = By.xpath("//*[@text='ORDER']");
		paytab = By.xpath("//*[@text='PAY']");
		menuitems = By.xpath("//*[@text='UITestOutletsList']");
		reviewbtn = By.xpath("//*[@text='REVIEW']");
		addtomyorder = By.xpath("//*[@text='ADD TO MY ORDER']");
		revieworder = By.xpath("//*[@text='REVIEW ORDER']");
		loginbtn = By.xpath("//*[@text='LOGIN']");
	}
	
	public void selectPayTab() throws InterruptedException {
		waitForElementpresent(Menus_android.paytab);
		LongPressButton(Menus_android.paytab);
		waitforPageLoad(5);
	}
	
	public static void selectDate(String date) throws InterruptedException {
		waitforPageLoad(5);
		driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='"+date+"']]")).click();;
	}
	
	public static  void selectMenuItem(String menuType) throws InterruptedException {
		waitForElementpresent(menuitems);
		System.out.println(driver.getSettings());
		System.out.println(driver.getContext());
		System.out.println(driver.getAppStringMap());
		waitforPageLoad(5);
		LongPressButton(menuitems);
		}
	public static void clickOnReviewOrder() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(revieworder).click();
	}
	
	
	public static void clickAddToMyOrder() {
		driver.findElement(addtomyorder).click();
	}
	public static void selectItemFromOrders(String item) throws InterruptedException {
	waitforPageLoad(5);
	List<MobileElement> ele = driver.findElementsByXPath("//*[@text='"+item+"']");
	ele.get(0).click();
	}
	}
