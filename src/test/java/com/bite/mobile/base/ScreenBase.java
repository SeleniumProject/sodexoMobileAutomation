package com.bite.mobile.base;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class ScreenBase extends TestBase {

	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;

	public void waitForElementPresent(long duration, String locator) {

		wait = new WebDriverWait(driver, duration);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
	}

	public ScreenBase(AppiumDriver<MobileElement> driver) {

		ScreenBase.driver = driver;

	}
	
	public void waitForElementNoLongerPresent(long timeout) {
		
		new WebDriverWait(driver, timeout).until(

		        ExpectedConditions.not(

		                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ProgressBar']"))));
	}
	
	public void waitForLoadingNoLongerPresent(long timeout) {
		
		new WebDriverWait(driver, timeout).until(

		        ExpectedConditions.not(

		                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Loading...']"))));
	}
	

	public void hideKeyboard() {

		driver.hideKeyboard();

	}
	
	public void IsKeyBoardShown() {
		driver.getKeyboard();

	}

	public void click(By elementLocator, String name) {
		try {
			Thread.sleep(2500);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			driver.findElement(elementLocator).click();
			test.log(LogStatus.PASS, "To Verify is User able to click on " + name, name + " clicked successfully");
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "To verify " + name + " is clickable with in provided time ",
					"An exception occurred waiting for " + name + " to enter text" + e.getMessage());

		}
	}

	public void Type(By elementLocator, String value, String name) {
		try {
			Thread.sleep(2200);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
			MobileElement ele = driver.findElement(elementLocator);
           ele.click();
           ele.clear();
            hideKeyboard();
			ele.sendKeys(value);
			test.log(LogStatus.PASS, "To Verify User able to Enter " + name, value + " Text entered successfully");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "To verify " + name + " is visible with in provided time ",
					"An exception occurred waiting for " + name + " to enter text");
		}

	}

	public void TypeWithCoordinates(int x, int y, String value, String name) {

	}

	public void keyBoardSendKeys(String value) {
		driver.switchTo().activeElement();
		driver.getKeyboard().sendKeys(value);
	}

	public void Tap(int x, int y, String name) {
		try {
			Thread.sleep(2500);
			(new TouchAction(driver)).tap(x, y).release().perform();
		} catch (Exception e) {
//			test.log(LogStatus.ERROR, "To verify " + name + " is clickable with in provided time ",
//					"An exception occurred waiting for " + name + " to enter text" + e.getMessage());
		}
	}

	public String getText(By elementLocator) {
		return driver.findElement(elementLocator).getText();
	}

	public String getAttribute(By elementLocator, String value) {
		return driver.findElement(elementLocator).getAttribute(value);
	}

	public static void LongPressButton(By elementLocator) throws InterruptedException {
		Thread.sleep(2500);
		TouchAction touchAction=new TouchAction(driver);
		touchAction.longPress(driver.findElement(elementLocator),2500).release().perform();
		}
	
	public static void LongPressWithText(MobileElement element) {
		TouchAction touchAction=new TouchAction(driver);
		touchAction.longPress(element,3000).release().perform();
	}
	
	public static void Press(By elementLocator) throws InterruptedException {
		Thread.sleep(2000);
		TouchAction touchAction=new TouchAction(driver);
		touchAction.press(driver.findElement(elementLocator)).waitAction(1500).release().perform();
		}
	
	public static void LongPressbuttonWithCooridinates(By elementLocator, int x, int y) throws InterruptedException {
		Thread.sleep(2000);
		TouchAction touchAction=new TouchAction(driver);
		touchAction.tap(driver.findElement(elementLocator),x, y).waitAction(2000).release().perform();
	}
	
	public static int convertDate() {
		String d = getTodayDateofMonth();
		int date = Integer.parseInt(d);
		return date;
	}
	public static String date() {
		Format dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");
	      String res = dateFormat.format(new Date());
	      return  res;
	}
	
	public static String  getTodayNameofTheWeek() {
		Format dateFormat = new SimpleDateFormat("EEE");
	      String res = dateFormat.format(new Date());
	      return res;
	}
	
	public static String  getTodayDateofMonth() {
		Format dateFormat = new SimpleDateFormat("dd");
	      String res = dateFormat.format(new Date());
	      return res;
	}
	
	public static String  getMonthofYear() {
		Format dateFormat = new SimpleDateFormat("MMM");
	      String res = dateFormat.format(new Date());
	    return res;
	}
//	public boolean clicked(By locator, String locatorName) throws Throwable {
//		boolean status = false;
//		try {
//			LOG.info("Click on the element:" + ""+locatorName+"");
//			if (this.testParameters.platform.equalsIgnoreCase(IFrameworkConstant.OS.ANDROID) || this.testParameters.platform.equalsIgnoreCase(IFrameworkConstant.OS.IOS)) {
//				WebDriverWait wait = new WebDriverWait(this.appiumDriver, IFrameworkConstant.EXPLICIT_WAIT_TIME);
//				wait.until(ExpectedConditions.elementToBeClickable(locator));
//				Thread.sleep(5000);
//				appiumDriver.findElement(locator).click();
//				LOG.info("Successfully clicked on the element:" + " "+locatorName+" ");
//				this.reporter.SuccessReport("Click : " + locatorName, msgClickSuccess + locatorName);
//				status = true;
//			} else {
//				WebDriverWait wait = new WebDriverWait(this.Driver, IFrameworkConstant.EXPLICIT_WAIT_TIME);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//				appiumDriver.findElement(locator).click();
//				this.reporter.SuccessReport("Click : " + locatorName, msgClickSuccess + locatorName);
//				status = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			status = false;
//			LOG.info("Failed to Click on the element:" +""+locatorName+""+"with locator:"+""+locator.toString()+"");
//			LOG.info(e.getMessage());
//			this.reporter.failureReport("Click : " + locatorName, msgClickFailure + locatorName, Driver);
//			throw e;
//		}
//		return status;
//	}

}
