package com.bite.mobile.testScripts.android;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
import com.bite.mobile.utility.TestUtil;

import io.appium.java_client.SwipeElementDirection;

public class E2E_android extends TestBase {

	HomeLib_android home;
	LoginLib_android login;
	CreateAccountLib_android signup;
	MenusLib_android menus;
	ReviewLib_android review;
	OrderLib_android order;
	LinkCardLib_android card;

	@BeforeTest
	public void init() {

		home = new HomeLib_android(driver);
		login = new LoginLib_android(driver);
		signup = new CreateAccountLib_android(driver);
		menus = new MenusLib_android(driver);
		review = new ReviewLib_android(driver);
		order = new OrderLib_android(driver);
		card = new LinkCardLib_android(driver);
	}

	@Test(priority = 0, dataProvider = "launch")
	public void LaunchBiteApp(String location) throws Throwable {
		test = extent.startTest("TS01_Bite App: Launch App and Search For Location");
		try {
			home.launchApp();
			home.searchAndSelectLocation(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = false, priority = 1, dataProvider = "CreateAccountData")
	public void createAnAccount(String email, String createAnAccountlbl, String nextletscreateaccountlbl,
			String firstName, String lastName, String password, String verifyPwd, String monthoption, String yearoption,
			String genderoption, String phoneoption) throws Throwable {
		test = extent.startTest("TS02_Bite App: Create an Account");
		email = signup.setEmail();
		try {
			signup.createAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password,
					verifyPwd, monthoption, yearoption, genderoption, phoneoption);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void continueAsGuest() {
		try {
			signup.continueAsGuest();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test(enabled = false, priority = 2, dataProvider = "menuData")
	public void selectingItem(String menuType, String itemName) {
		test = extent.startTest("TS03_Bite App: Selecting menu and item");
		int day = ScreenBase.convertDate();
		try {
			menus.selectMenu(menuType);
			menus.selectDateAndItem(day, itemName);
			menus.ReviewButton();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void Order() throws InterruptedException {
		test = extent.startTest("TS04_Bite App: Order item");
		menus.selectOrderTab();
		menus.LetsOrderButton();
		menus.selectMenuFromOrder();
		menus.selectItemFromOrderList("Bacon");
		menus.clickAddToMyOrder();
		menus.clickOnReviewOrder();
	}

	@Test(priority = 3, dataProvider = "login")
	public void LoginFromOrder(String email, String password) throws InterruptedException {
		test = extent.startTest("TS05_Bite App: Login from order");
		order.clickLogin();
		Login(email, password);

	}

	@Test(enabled = false,priority = 4, dataProvider = "login")
	public void Login(String email, String password) throws InterruptedException {
		test = extent.startTest("TS03_Bite App: Login to Bite App");
		Thread.sleep(2000);
		try {
			signup.enterEmailPressNext(email);
			login.Login(email, password);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void finalOrder() throws InterruptedException {
		Thread.sleep(2000);
		// order.setTimeSlot();
		order.SwipDown();
		Thread.sleep(2000);
		System.out.println("Swip up done");
		order.enterInstructionHere("Food is good");
		System.out.println("Entered INstrcutions");
		order.placeOrder();
		System.out.println("click PLace order");

	}

	@Test(priority = 6)
	public void LinkCard() throws InterruptedException {
		System.out.println("CLick on Add Payment Method");
		order.AddPaymentMethod();
		System.out.println("Trying to enter Card Details");
		card.FillCardDetails("5399999999999999", "11", "2023", "999", "98760");
		Thread.sleep(2000);

	}

	@Test(enabled = false, priority = 3)
	public void reviewOrder() {
		test = extent.startTest("TS04_Bite App: Review Order with Rating");

		try {
			review.fillReview("Good menu");
			review.backToOrderMenu();
			menus.selectOrder("HBO");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@DataProvider(name = "launch")
	public static Object[][] launchData() {
		return TestUtil.getData("launch");
	}

	@DataProvider(name = "login")
	public static Object[][] login() {
		return TestUtil.getData("login");
	}

	@DataProvider(name = "CreateAccountData")
	public static Object[][] CreateAccountData() {
		return TestUtil.getData("createanaccount");
	}

	@DataProvider(name = "menuData")
	public static Object[][] menuData() {
		return TestUtil.getData("menuData");
	}

	@AfterTest
	public void quit() {
		extent.endTest(test);
		extent.flush();
		extent.close();
		System.out.println("Ending Script....");
	}

}
