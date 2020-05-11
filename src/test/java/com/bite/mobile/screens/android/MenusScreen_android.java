package com.bite.mobile.screens.android;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenusScreen_android extends ScreenBase {
	public MenusScreen_android(AppiumDriver<MobileElement> driver) {
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
	public static By nomenutxt;
    
	static String  getDay = getTodayNameofTheWeek();
	

	static {
		
		backImageButtonFromLogout = By.xpath("//android.widget.ImageButton");
		backImageFromProfile = By.xpath("//android.widget.ImageButton");
		newstab = By.xpath("//android.widget.TextView[@text='NEWS']");
		menustab = By.xpath("//android.widget.TextView[@text='MENUS']");
		rewardstab = By.xpath("//android.widget.TextView[@text='REWARDS']");
		ordertab = By.xpath("//android.widget.TextView[@text='ORDER']");
		paytab = By.xpath("//android.widget.TextView[@text='PAY']");
		menuitems = By.xpath("//android.widget.TextView[@text='android.widget.TextView']");
		date = By.xpath("//*[@class='android.view.ViewGroup' and ./*[@text=' "+getDay+" ']]");
		item = By.xpath("//android.widget.TextView");
		reviewbtn = By.xpath("//android.widget.Button[@text='REVIEW']");
		nomenutxt = By.xpath("//android.widget.TextView[@text='No menu for this day']");

	}
	
	public static boolean getnomenutext(String value) {
		String text = driver.findElement(nomenutxt).getText();
		if (text.contains(value)) {
			return true;
		}
		return true;
	}
	public static WebElement nomenutextdisplayed() {
		return driver.findElement(nomenutxt);
	}
	public static void selectDate(int day) throws InterruptedException {
		Thread.sleep(2000);
		List<MobileElement> days = driver.findElementsByXPath("//*[@class='android.view.ViewGroup' and ./*[@text='"+day+"']]");
		Thread.sleep(2000);
		System.out.println(days);
		days.get(0).click();
	}
	public static  void selectMenuItem(String menuType) throws InterruptedException {
		Thread.sleep(13000);
		List<MobileElement> els4 = driver.findElementsByXPath("//android.widget.TextView[@text='HBO Cafe']");
		els4.get(0).click();
		
		Thread.sleep(3500);
//		List<MobileElement> menuitems = driver.findElementsByXPath("//android.widget.TextView[@text='"+menuType+"']");
//		int count = menuitems.size();
//		if (count>=1) {
//			for (MobileElement mobileElement : menuitems) {
//				System.out.println("Menu Item is : " + mobileElement.getText());
//				if (mobileElement.getText().trim().contains(menuType)) {
//					Thread.sleep(500);
//					LongPressWithText(mobileElement);
//				     break;
//				}
//			}
		}
	
	

}
