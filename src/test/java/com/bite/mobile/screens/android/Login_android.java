package com.bite.mobile.screens.android;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_android extends ScreenBase {
	public Login_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 120, TimeUnit.SECONDS), this);

	}
	public static By signintitle;
	public static By pleasesigninlbl;
	public static By emailedittxt;
	public static By passwordedittxt;
	public static By signinsignupbtn;
	public static By forgotpasswordlink;
	public static By bycontinuinglbl;

	

	static {
		
		signintitle = By.xpath("//android.widget.Button[@text='SIGN IN / SIGN UP']");
		pleasesigninlbl = By.xpath("//*[@text='Please sign in with your Bite account email and password you previously set up.']");
		emailedittxt = By.xpath("//android.widget.EditText[contains(text(),'mail')]");
		passwordedittxt = By.xpath("//android.widget.EditText[@text='Password']");
		signinsignupbtn = By.xpath("//*[@text='SIGN IN / SIGN UP']");
		forgotpasswordlink = By.xpath("//*[@text='FORGOT PASSWORD']");
		forgotpasswordlink = By.xpath("//*[@text=concat('By continuing, you', \"'\", 'll be agreeing to our')]");

	}
	

	
	

}
