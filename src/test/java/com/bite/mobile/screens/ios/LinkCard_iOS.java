package com.bite.mobile.screens.ios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LinkCard_iOS extends ScreenBase {
	public LinkCard_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);

	}
	
	public static By nameoncard;
	public static By cardNumber;
	public static By month;
	public static By year;
	public static By cvv;
	public static By submit;
	public static By linkcardbtn;
	

	

	static {
		
		cardNumber = By.xpath("//*[@placeholder='Enter card number']");
		nameoncard = By.xpath("//*[@placeholder='Enter name on card']");
		month = By.xpath("//*[@placeholder='MM']");
		year = By.xpath("//*[@placeholder='YY']");
		cvv = By.xpath("//*[@placeholder='CVV Number']");
		submit = By.xpath("//*[@text='Submit']");
	}	

}
