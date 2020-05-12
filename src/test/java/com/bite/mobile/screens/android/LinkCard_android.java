package com.bite.mobile.screens.android;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class LinkCard_android extends ScreenBase {
	public LinkCard_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 120, TimeUnit.SECONDS), this);

	}
	public static By linkcard;
	public static By cardNumber;
	public static By month;
	public static By year;
	public static By cvv;
	public static By zipcode;
	public static By linkcardbtn;
	

	

	static {
		
		linkcard = By.xpath("android.widget.Button[@text='LINK CARD']");
		cardNumber = By.xpath("//android.widget.EditText[@text='Card Number']");
		month = By.xpath("//android.widget.Button[@text='MM']");
		year = By.xpath("//android.widget.Button[@text='YYYY']");
		cvv = By.xpath("//android.widget.EditText[@text='CVV']");
		zipcode = By.xpath("//android.widget.EditText[@text='Zip code']");
		linkcardbtn = By.id("//android.widget.Button[@text='LINK CARD']");
	}	


	public static void clickLinkCard() {
		List<MobileElement> els2 =driver.findElementsByXPath("//android.widget.Button[@text='LINK CARD']");
		TouchAction tc = new TouchAction(driver);
		tc.longPress(els2.get(0)).waitAction(2000).release().perform();
	}
	
	
}
