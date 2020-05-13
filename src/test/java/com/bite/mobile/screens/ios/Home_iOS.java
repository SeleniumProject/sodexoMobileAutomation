package com.bite.mobile.screens.ios;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Home_iOS extends ScreenBase {
	public Home_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);

	}
	public static By LetsStart;
	public static By LetsStartbtn;
	public static By allowbtn;
	public static By allowbtn_1;
	public static By searchlocationnametext;
	public static By searchButton;
	public static By springvaleoption;
	public static By okbtn;
	public static By locationList;
	public static By newstab;
	public static By existingsearchlocation;
	public static By findnewlocation;
	public static By iconlocationhistory;
	public static By locationFrompreviouslocation;


	static {
		
		LetsStart = By.xpath("//*[@name='UITestStartButton']");
		allowbtn = By.xpath("//*[@name='Always Allow']");
		searchlocationnametext = By.xpath("//*[@placeholder='Search location name']");
		existingsearchlocation = By.xpath("//*[@class='UIAStaticText']");
		searchButton = By.xpath("//*[@text='icn search']");
		okbtn = By.xpath("//*[@text='OK']");
		locationList =By.xpath("//*[@text='UITestLocationsList']");
		newstab =By.xpath("//*[@text='NEWS']");
		findnewlocation =By.xpath("//*[@text='Find new location...']");
		iconlocationhistory =By.xpath("//*[@text='icn location history']");
		iconlocationhistory =By.xpath("//*[@text='icn location history']");
	}
	
	public static MobileElement isLetsStartDisplayed() {
		return driver.findElement(LetsStart);
	}
	
	public static MobileElement isOkPopUpDisplayed() {
		return driver.findElement(okbtn);
	}
	public static void clickOnExistingLocation() {
		List<MobileElement> ele = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
				ele.get(0).click();
	}

	public static void clickPreviousLocation(String name) {
		List<MobileElement> ele = driver.findElementsByXPath("//*[contains(text(),'"+name+"')]") ;
		ele.get(0).click();;
	}
public static MobileElement isNewsElementDisplayed() {
	return driver.findElement(newstab);
}

	public static void selectLocation() throws InterruptedException{
		System.out.println("Started clicking for location list");
		String getText11=null;
		try {
			Thread.sleep(1000);
		List<MobileElement> locationsList = driver.findElementsByXPath("//[@name='UITestLocationsList']");
		System.out.println("finding one location");
		int count = locationsList.size();
		for (int i = 1; i < count; i++) {
			if (i>=1) {
//				getText11 = locationsList.get(0).getTagName();
				Thread.sleep(1000);
				locationsList.get(0).click();
				//test.log(LogStatus.PASS, "To Verify is User able to click on " + getText11, getText11 + " clicked successfully");
				break;
			}
		}
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "To verify " + getText11 + " is clickable with in provided time ",
					"An exception occurred waiting for " + getText11 + " to enter text" + e.getMessage());

		}
	}
	
	

}
