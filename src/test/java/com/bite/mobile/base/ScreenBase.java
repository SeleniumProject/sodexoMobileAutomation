package com.bite.mobile.base;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

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

	public static void waitforPageLoad(long timeout) throws InterruptedException {
		try {
			Thread.sleep(timeout*500);
		} catch (Exception e) {
			new SkipException("Unable to click / Type / select with in the Specified Time in"+ (timeout*1000) + " sec");
		}
		     
	}
	public void waitForElementNoLongerPresent(long timeout) {

		new WebDriverWait(driver, timeout).until(

				ExpectedConditions.not(

						ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ProgressBar']"))));
	}

	public void waitForLoadingNoLongerPresent(long timeout) {

		new WebDriverWait(driver, timeout).until(

				ExpectedConditions.not(

						ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//android.widget.TextView[@text='Loading...']"))));
	}

	public void hideKeyboard() {

		driver.hideKeyboard();

	}

	public void IsKeyBoardShown() {
		driver.getKeyboard();

	}
	public static void waitForElementpresent(By elementLocator) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		} catch (Exception e) {
			// TODO: handle exception
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		}
		
	}

	public void click(By elementLocator, String name) {
		try {
			waitForElementpresent(elementLocator);
//			WebDriverWait wait = new WebDriverWait(driver, 60);
//			wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
//			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			driver.findElement(elementLocator).click();
			test.log(LogStatus.PASS, "To Verify is User able to click on " + name, name + " clicked successfully");
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "To verify " + name + " is clickable with in provided time ",
					"An exception occurred waiting for " + name + " to enter text" + e.getMessage());

		}
	}


	public void Type(By elementLocator, String value, String name) {
		try {
			waitForElementpresent(elementLocator);
			MobileElement ele = driver.findElement(elementLocator);
			ele.click();
			ele.clear();
			ele.sendKeys(value);
			hideKeyboard();
			test.log(LogStatus.PASS, "To Verify User able to Enter " + name, value + " Text entered successfully");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "To verify " + name + " is visible with in provided time ",
					"An exception occurred waiting for " + name + " to enter text");
		}

	}

	/*
	 * don't forget that it's "natural scroll" where fromY is the point where you
	 * press the and toY where you release it
	 */
	public static void scroll(int fromX, int fromY, int toX, int toY) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();
	}

	public  void scrollDown() {
		// if pressX was zero it didn't work for me
		int pressX = driver.manage().window().getSize().width / 2;
		// 4/5 of the screen as the bottom finger-press point
		int bottomY = driver.manage().window().getSize().height * 4 / 5;
		// just non zero point, as it didn't scroll to zero normally
		int topY = driver.manage().window().getSize().height / 8;
		// scroll with TouchAction by itself
		scroll(pressX, bottomY, pressX, topY);
	}

	public void TypeWithCoordinates(int x, int y, String value, String name) {

	}

	public static void ScrollDown(By by) {
		MobileElement abc = driver.findElement(by);
		int x = abc.getLocation().getX();
	    int y = abc.getLocation().getY();
         System.out.println("X Value "+ x);
         System.out.println("Y Value "+ y);
         System.out.println("X plus Value "+ x+90);
	    TouchAction action = new TouchAction(driver);
	    action.press(x,y).moveTo(x+90,y).release().perform(); 
	}
	
	public void keyBoardSendKeys(String value) {
		driver.switchTo().activeElement();
		driver.getKeyboard().sendKeys(value);
	}

	public void Tap(int x, int y, String name) {
		try {
			waitforPageLoad(5);
			(new TouchAction(driver)).tap(x, y).release().perform();
		} catch (Exception e) {
//			test.log(LogStatus.ERROR, "To verify " + name + " is clickable with in provided time ",
//					"An exception occurred waiting for " + name + " to enter text" + e.getMessage());
		}
	}

	public void TapElement(MobileElement me) {
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(me).waitAction(2500).release().perform();
	}
	public String getText(By elementLocator) {
		return driver.findElement(elementLocator).getText();
	}

	public String getAttribute(By elementLocator, String value) {
		return driver.findElement(elementLocator).getAttribute(value);
	}

	public static void LongPressButton(By elementLocator) throws InterruptedException {
		waitForElementpresent(elementLocator);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(driver.findElement(elementLocator), 2500).release().perform();
	}

	public void swipeTo(String action) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", action);
		js.executeScript("mobile: scroll", scrollObject);
	}

	public static void LongPressWithText(MobileElement element) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(element, 3000).release().perform();
	}

	public static void Press(By elementLocator) throws InterruptedException {
		waitforPageLoad(5);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(driver.findElement(elementLocator)).waitAction(1500).release().perform();
	}

	public static void LongPressbuttonWithCooridinates(By elementLocator, int x, int y) throws InterruptedException {
		waitforPageLoad(5);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(driver.findElement(elementLocator), x, y).waitAction(2000).release().perform();
	}

	public static int convertDate() {
		String d = getTodayDateofMonth();
		int date = Integer.parseInt(d);
		return date;
	}

	public static String date() {
		Format dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");
		String res = dateFormat.format(new Date());
		return res;
	}

	public static String getTodayNameofTheWeek() {
		Format dateFormat = new SimpleDateFormat("EEE");
		String res = dateFormat.format(new Date());
		return res;
	}

	public static String getTodayDateofMonth() {
		Format dateFormat = new SimpleDateFormat("dd");
		String res = dateFormat.format(new Date());
		return res;
	}

	public static String getMonthofYear() {
		Format dateFormat = new SimpleDateFormat("MMM");
		String res = dateFormat.format(new Date());
		return res;
	}
	
	public void scrollToView(By elementLocator) {
		MobileElement element = driver.findElement(elementLocator);
		driver.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void scrollUp() throws Exception {
		

	    //The viewing size of the device
	    Dimension size = driver.manage().window().getSize();

	    //Starting y location set to 20% of the height (near bottom)
	    int starty = (int) (size.height * 0.20);
	    //Ending y location set to 80% of the height (near top)
	    int endy = (int) (size.height * 0.80);
	    //x position set to mid-screen horizontally
	    int startx = size.width / 2;

	    scroll(startx, starty, startx, endy);
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
