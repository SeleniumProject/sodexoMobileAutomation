package com.bite.mobile.screens.android;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Review_android extends ScreenBase {
	public Review_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 120, TimeUnit.SECONDS), this);

	}
	public static By pleaserateyourexp;
	public static By emojismile;
	public static By didyouenjoy;
	public static By wasitagood;
	public static By wouldyoueat;
	public static By howlikely;
	public static By tellusabout;
	public static By commentstxt;
	public static By submitbtn;
	public static By backbtn;
	public static By backbntn1;
	public static By backbntn2;
	public static By closebtn;

	

	static {
		
		pleaserateyourexp = By.xpath("//android.widget.TextView[@text='Please rate your experience:']");
		emojismile = By.xpath("//*[@contentDescription='UITestEmojiControl']");
		commentstxt = By.xpath("//*[@text='Describe your experience']");
		submitbtn = By.xpath("//android.widget.Button[@content-desc='UITestSubmitSurvey']");
		tellusabout = By.xpath("//android.widget.TextView[@text='Tell us about your experience']");
		backbtn = By.xpath("//android.widget.ImageButton");
		backbntn1 = By.xpath("//android.widget.ImageView");
		closebtn = By.xpath("//*[@text='Close']");
	
	}
	
	
	public String getRateText() throws InterruptedException {
		waitforPageLoad(5);
		return driver.findElement(pleaserateyourexp).getText();
	}
	
	public String getTellusaboutyourexpText() throws InterruptedException {
		waitforPageLoad(5);
		return driver.findElement(pleaserateyourexp).getText();
	}
	

	
	

}
