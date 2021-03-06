package com.bite.mobile.screens.android;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Purpose of this screen is to have all the controls properties and functions of Create An Account Screen for Android
 * @author Ramesh Kudikala
 *
 */
public class CreateAccount_android extends ScreenBase {
	
	/**
	 * Constructor of Create An Account Screen.
	 * @param driver
	 */
	public CreateAccount_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 120, TimeUnit.SECONDS), this);
	}
	
	public static By createAnaccountlbl;
	public static By emailtxt;
	public static By nextbtn;
	public static By guestSignIn;
	public static By nextletscreateanaccountlbl;
	public static By editboxes;
	public static By firstnametxt;
	public static By lastnametxt;
	public static By passwordtxt;
	public static By verifypasswordtxt;
	public static By termsconditionchkbox;
	public static By privacypolicylink;
	public static By signupbtn;
	
	public static By Monthbtn;
	public static By yearbtn;
	public static By genderbtn;
	public static By mobilenotxt;
	public static By alldonebtn;
	public static By popupoptions;
	public static By notnowlink;
	
	
	static {
		
		createAnaccountlbl = By.xpath("//android.widget.TextView[@text='Create an Account']");
		emailtxt = By.xpath("//android.widget.EditText[@content-desc='UITestEnterEmail']");
		nextbtn = By.xpath("//android.widget.Button[@content-desc='UITestNext']");
		guestSignIn = By.xpath("//*[@content-desc='UITestGuestSignIn']");
		nextletscreateanaccountlbl = By.xpath("//android.widget.TextView[@text='Next, let�s create an account:']");
		editboxes = By.xpath("//android.widget.EditText");
		firstnametxt = By.xpath("//android.widget.EditText[@content-desc='UITestFirstName']");
		lastnametxt = By.xpath("//android.widget.EditText[@content-desc='UITestLastName']");
		passwordtxt = By.xpath("//android.widget.EditText[@content-desc='UITestPassword']");
		verifypasswordtxt = By.xpath("//android.widget.EditText[@content-desc='UITestVerification']");
		termsconditionchkbox = By.xpath("//android.widget.Button[@content-desc='UITestAcceptTerms']");
		privacypolicylink = By.xpath("//android.widget.Button[@text='privacy policy']");
		signupbtn = By.xpath("//android.widget.Button[@content-desc='UITestSignUp']");
		
		Monthbtn = By.xpath("//android.widget.Button[@text='Month']");
		yearbtn = By.xpath("//android.widget.Button[@text='Year']");
		genderbtn = By.xpath("//android.widget.Button[@text='Gender']");
		mobilenotxt = By.xpath("//android.widget.EditText[@text='Mobile Number']");
		alldonebtn = By.xpath("//android.widget.Button[@content-desc='UITestDoneButton']");
		
		popupoptions = By.xpath("//android.widget.TextView[@resource-id='android:id/text1']");
		notnowlink = By.xpath("//android.widget.Button[@text='Not now']");

	}
	
	public static String RandomEmail() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		return "bitetest"+ randomInt +"@gmail.com";
	}

	public static void selectValueFromPopUp(String value, String name) {
		try {
			waitforPageLoad(5);
			TouchAction TA = new TouchAction(driver);
			List<MobileElement> options = driver.findElements(popupoptions);
			int count = options.size();
			if (count>=1) {
				for (MobileElement mobileElement : options) {
					if (mobileElement.getText().equals(value)) {
						TA.tap(mobileElement).release().perform();
						Thread.sleep(500);
						test.log(LogStatus.PASS, "To Verify is User able to click on " + name, mobileElement.getText() + " clicked successfully");
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, "To verify " + value + " is clickable with in provided time ",
					"An exception occurred waiting for " + value + " to enter text" + e.getMessage());
		}
		
	}



}
