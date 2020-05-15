package com.bite.mobile.screens.ios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;

public class Review_ios extends ScreenBase {
	public Review_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 120, TimeUnit.SECONDS), this);

	}

	public static By pleaserateyourexp;
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
	public static By reviewbtn;
	public static By angry;
	public static By sad;
	public static By smile;
	public static By happy;
	public static By closepopup;
	public static By donebtn;

	static {

		pleaserateyourexp = By.xpath("//*[@text='Please rate your experience:']");
		commentstxt = By.xpath("//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and (./preceding-sibling::* | ./following-sibling::*)[@class='UIAView' and ./*[@text='Tell us about your experience']] and ./parent::*[@class='UIAView']]]]");
		submitbtn = By.xpath("//*[@text='SUBMIT']");
		tellusabout = By.xpath("//android.widget.TextView[@text='Tell us about your experience']");
		backbtn = By.xpath("//*[@text='Recipe details']");
		backbntn1 = By.xpath("//*[@class='UIANavigationBar']");
		backbntn2 = By.xpath("//*[@class='UIANavigationBar']");
		reviewbtn = By.xpath("//*[@text='REVIEW']");

		angry = By.xpath("//*[@text='face angry off']");
		sad = By.xpath("//*[@text='face sad off']");

		smile = By.xpath("//*[@text='face smile off']");

		happy = By.xpath("//*[@text='face happy off']");
		closepopup = By.xpath("//*[@text='Close']");
		donebtn = By.xpath("//*[@text='Done']");

	}

	public static void backButton() throws InterruptedException {
		waitforPageLoad(5);
	
		((AppiumDriver<MobileElement>) driver).navigate().back();
		waitforPageLoad(5);
		((AppiumDriver<MobileElement>) driver).navigate().back();
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
