package com.bite.mobile.screens.android;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;

public class Menus_android extends ScreenBase {
	
	public Menus_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 120, TimeUnit.SECONDS), this);
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
	public static By letsorder;
	public static By orderItems;
	public static By addtomyorder;
	public static By revieworder;
	public static By backbtnfromorder;
	public static By backbtnfromitemdetails;
	public static By backbtnfrommenuitem;
	public static By bitepaybtn;
    
	static String  getDay = getTodayNameofTheWeek();
	

	static {
		
		backImageButtonFromLogout = By.xpath("//android.widget.ImageButton");
		backImageFromProfile = By.xpath("//android.widget.ImageButton");
		newstab = By.xpath("//*[@text='NEWS']");
		menustab = By.xpath("//*[@text='MENUS']");
		rewardstab = By.xpath("//*[@text='REWARDS']");
		ordertab = By.xpath("//*[@text='ORDER']");
		paytab = By.xpath("//*[@text='PAY']");
		menuitems = By.xpath("//*[@text='android.widget.TextView']");
		date = By.xpath("//*[@class='android.view.ViewGroup' and ./*[@text=' "+getDay+" ']]");
		item = By.xpath("//android.widget.TextView");
		reviewbtn = By.xpath("//*[@text='REVIEW']");
		nomenutxt = By.xpath("//*[@text='No menu for this day']");
		letsorder = By.xpath("android.widget.Button");
		orderItems = By.xpath("android.widget.TextView");
		addtomyorder = By.xpath("//*[@text='ADD TO MY ORDER']");
		revieworder = By.xpath("//*[@text='REVIEW ORDER']");
		backbtnfromorder= By.xpath("//*[@class='android.widget.ImageButton']");
		bitepaybtn= By.xpath("//*[@text='Bite PAY']");
		backbtnfromitemdetails= By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']]");
		backbtnfrommenuitem= By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]");
		

	}
	
	public static void clickAddToMyOrder() {
		driver.findElement(addtomyorder).click();
	}
	public static void selectItemFromOrders(String item) throws InterruptedException {
		waitforPageLoad(5);
		List<MobileElement> ele = driver.findElementsByXPath("//android.widget.TextView[@text='"+item+"']");
		ele.get(0).click();
//		
//		for (MobileElement mobileElement : ele) {
//			Thread.sleep(500);
//			if (mobileElement.getText().trim().contains(item)) {
//				TouchAction ac = new TouchAction(driver);
//				ac.press(mobileElement).release().perform();
//				break;
//			}
//		}
		
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
	
	public static void clickOnReviewOrder() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(revieworder).click();
	}
	

	public static  void selectMenuItem(String menuType) throws InterruptedException {
		waitforPageLoad(30);
		List<MobileElement> els4 = driver.findElementsByXPath("//android.widget.TextView[@text='"+menuType+"']");
		els4.get(0).click();
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
