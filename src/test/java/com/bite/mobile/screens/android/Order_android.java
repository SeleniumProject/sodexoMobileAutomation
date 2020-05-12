package com.bite.mobile.screens.android;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Order_android extends ScreenBase {
	public Order_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 120, TimeUnit.SECONDS), this);

	}
	public static By pleaseloginlbl;
	public static By loginbtn;
	public static By phonenumber;
	public static By timeslot;
	public static By pickuplbl;
	public static By orderlbl;
	public static By placeorderbtn;
	public static By totalamt;
	public static By enterspecialinstructiontxt;
	public static By addpaymentMethod;
	public static By addpaymentMethod1;
	
	static {
		
		pleaseloginlbl = By.xpath("//*[@text='Please login if you want to submit an order.']");
		loginbtn = By.xpath("//android.widget.Button[@text='LOGIN']");
		phonenumber = By.xpath("//android.widget.EditText[@text='Phone number']");
		timeslot = By.xpath("android.widget.Button");
		pickuplbl = By.xpath("//android.widget.TextView[@text='PICKUP TIME']");
		orderlbl = By.xpath("//android.widget.TextView[@text='ORDER']");
		placeorderbtn = By.xpath("//android.widget.Button[@text='PLACE ORDER']");
		totalamt = By.xpath("//android.widget.TextView[@text='ORDER']");
		enterspecialinstructiontxt = By.xpath("//android.widget.EditText[@text='Enter Special Instructions Here']");
		addpaymentMethod = By.xpath("//android.widget.Button[@text='ADD PAYMENT METHOD']");
		addpaymentMethod1 = By.id("android:id/button1");
	}	

	public static  MobileElement addPaymentMethod() {
		return driver.findElement(addpaymentMethod1);
	}
	public static void selectTimeSlot() throws InterruptedException {
		waitforPageLoad(5);
		List<MobileElement> btn = driver.findElementsByXPath("android.widget.Button");
		List<MobileElement> text = driver.findElementsByXPath("android.widget.TextView");
		waitforPageLoad(5);
		btn.get(0).click();
		waitforPageLoad(5);
		text.get(5).click();
		waitforPageLoad(5);
	}
	
	public static void swipUp() throws InterruptedException {
//		TouchAction tc = new TouchAction(driver);
//		tc.press(491, 2197).moveTo(603, 776).waitAction(3000).release().perform();

	}
	public static void AddPaymentDetails() {
		MobileElement el1 = (MobileElement) driver.findElementById("android:id/button1");
		el1.click();
	}
	
}
