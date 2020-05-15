package com.bite.mobile.testScripts.android;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.android.CreateAccountLib_android;
import com.bite.mobile.lib.android.HomeLib_android;
import com.bite.mobile.lib.android.LinkCardLib_android;
import com.bite.mobile.lib.android.LoginLib_android;
import com.bite.mobile.lib.android.MenusLib_android;
import com.bite.mobile.lib.android.OrderLib_android;
import com.bite.mobile.lib.android.ReviewLib_android;
import com.bite.mobile.utility.PageInstance;
import com.bite.mobile.utility.TestUtil;

public class EndToEndScript extends TestBase {

	HomeLib_android home;
	LoginLib_android login;
	CreateAccountLib_android signup;
	MenusLib_android menus;
	ReviewLib_android review;
	OrderLib_android order;
	LinkCardLib_android card;

	@Test(enabled = true,priority = 0, description = "Launching Bite App and Search for Location", dataProvider = "endtoend")
	public void BiteEndToEnd(String location, String email, String createAnAccountlbl, String nextletscreateaccountlbl, String firstName,
			String lastName, String password, String verifyPwd, String month,String year, String gender, 
			String phone, String menuType, String itemName, String reviewcomments, 
			 String cardNum, String MM, String YYYY, String cvv, String zipcode) throws Throwable {
		test = extent.startTest("TS01_Bite App: Launch App and Search For Location");
		try {
			PageInstance.home().launchApp();
			PageInstance.home().searchAndSelectLocation(location);
			email = PageInstance.createAccount().setEmail();
			PageInstance.createAccount().createAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName,
						lastName, password, verifyPwd, month, year, gender, phone);
			PageInstance.menus().selectMenu(menuType);
			int day = ScreenBase.convertDate();
			PageInstance.menus().selectDateAndItem(day, itemName);
			PageInstance.menus().ReviewButton();
			
			PageInstance.review().fillReview(reviewcomments);
			PageInstance.review().backToOrderMenu();
			PageInstance.menus().selectOrderTab();
			PageInstance.menus().selectMenuFromOrder(menuType);
			PageInstance.menus().selectItemFromOrderList(itemName);
			PageInstance.menus().clickAddToMyOrder();
			PageInstance.menus().clickOnReviewOrder();
			PageInstance.menus().backToMainScreen();
			PageInstance.menus().selectPayTab();
			PageInstance.menus().clickBitePay();
			PageInstance.card().AddPaymentMethod();
			PageInstance.card().FillCardDetails(cardNum, MM, YYYY, cvv, zipcode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name = "endtoend")
	public static Object[][] endtoend() {
		return TestUtil.getData("endtoend");
	}
	
	@AfterTest
	public void endSession() {
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.closeApp();
		System.out.println("Ending Script....");
	}
}
