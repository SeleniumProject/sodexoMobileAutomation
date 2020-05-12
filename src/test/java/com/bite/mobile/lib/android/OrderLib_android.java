package com.bite.mobile.lib.android;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.Order_android;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
public class OrderLib_android extends ScreenBase{

	/**
	 * author : Ramesh K
	 * Name of the Elements in the Page or Screen
	 */
	
	public String pleaseloginlbl="Please login if you want to submit an order.";
	public String loginbtn ="LOGIN";
	public String phonenumber ="Phone Number";
	public String timeslot ="Time is not available yet";
	public String pickuplbl="PICK UP";
	public String orderlbl ="ORDER";
	public String enterspecialinstructiontxt ="Enter Special Instructions here";
	public String placeorder ="PLACE ORDER";
	
	public OrderLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);

	}

	public void clickLogin() throws InterruptedException {
		Thread.sleep(3000);
		click(Order_android.loginbtn, loginbtn);
	}
	
	public void setTimeSlot() throws InterruptedException {
		Order_android.selectTimeSlot();
	}
	
	public void SwipDown() throws InterruptedException {
		Thread.sleep(2000);
		ScrollDown(Order_android.enterspecialinstructiontxt);
	}
	
	public void enterInstructionHere(String value) throws InterruptedException {
		Thread.sleep(2000);
		Type(Order_android.enterspecialinstructiontxt, value, enterspecialinstructiontxt);
	}
	
	public void placeOrder() throws InterruptedException {
		Thread.sleep(2000);
		LongPressButton(Order_android.placeorderbtn);
	}
	
	public void AddPaymentMethod() throws InterruptedException {
		Thread.sleep(2500);
		TouchAction ac = new TouchAction(driver);
		ac.press(Order_android.addPaymentMethod()).waitAction(3500).release().perform();
		Thread.sleep(2500);
	}
	
}
