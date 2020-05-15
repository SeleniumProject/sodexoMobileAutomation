package com.bite.mobile.screens.ios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_iOS extends ScreenBase {
	public Login_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);

	}
	
	public static By SigninSignupbtn;
	public static By emailtxt;
	public static By passwordtxt;
	public static By signinbtn;

	static {
		SigninSignupbtn = By.xpath("//*[@text='SIGN IN / SIGN UP']");
		emailtxt = By.xpath("//*[@placeholder='Email Address']");
		passwordtxt = By.xpath("//*[@placeholder='Password']");
		signinbtn = By.xpath("//*[@text='SIGN IN']");
	}
}
