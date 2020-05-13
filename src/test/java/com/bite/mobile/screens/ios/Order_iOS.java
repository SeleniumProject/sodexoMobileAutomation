package com.bite.mobile.screens.ios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Order_iOS extends ScreenBase {
	public Order_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);

	}
	
	public static By loginbtn;
	public static By place;
	public static By time;
	public static By phonenumber;
	public static By donebtn;
	public static By paybycard;
	public static By payatpickup;

	static {
		loginbtn = By.xpath("//*[@text='LOGIN']");
		place = By.xpath("//*[@placeholder='Choose your pickup spot']");
		time = By.xpath("//*[@text='LOGIN']");
		phonenumber = By.xpath("//*[@text='LOGIN']");
		donebtn = By.xpath("//*[@text='Done']");
		paybycard = By.xpath("//*[@text='PAY BY CARD']");
		payatpickup = By.xpath("//*[@text='PAY AT PICKUP']");
	}
	
	public static void clickDone() {
		waitForElementpresent(donebtn);
		driver.findElement(donebtn).click();
	}
}
