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
import com.bite.mobile.utility.Attributes;
import com.bite.mobile.utility.PageInstance;
import com.bite.mobile.utility.TestUtil;

public class E2E_android extends TestBase {

	HomeLib_android home;
	LoginLib_android login;
	CreateAccountLib_android signup;
	MenusLib_android menus;
	ReviewLib_android review;
	OrderLib_android order;
	LinkCardLib_android card;

	@Test(priority = 0, description = "Launching Bite App and Search for Location", dataProvider = "launch")
	public void LaunchBiteApp(String location) throws Throwable {
		test = extent.startTest("TS01_Bite App: Launch App and Search For Location");
		try {
			PageInstance.home().launchApp();
			PageInstance.home().searchAndSelectLocation(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = true, priority = 1, dataProvider = "login")
	public void Login(String email, String password) throws InterruptedException {
		test = extent.startTest("TS03_Bite App: Login to Bite App");
		try {
			PageInstance.createAccount().enterEmailPressNext(email);
			PageInstance.login().Login(email, password);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = false, priority = 2, dataProvider = "menuData")
	public void selectingItem(String menuType, String itemName) {
		test = extent.startTest("TS03_Bite App: Selecting menu and item");
		int day = ScreenBase.convertDate();
		try {
			PageInstance.menus().selectMenu(menuType);
			PageInstance.menus().selectDateAndItem(day, itemName);
			PageInstance.menus().ReviewButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = false, priority = 1, dataProvider = "CreateAccountData")
	public void createAnAccount(String email, String createAnAccountlbl, String nextletscreateaccountlbl,
			String firstName, String lastName, String password, String verifyPwd, String monthoption, String yearoption,
			String genderoption, String phoneoption) throws Throwable {

		test = extent.startTest("TS02_Bite App: Create an Account");
		email = PageInstance.createAccount().setEmail();
		try {
			PageInstance.createAccount().createAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName,
					lastName, password, verifyPwd, monthoption, yearoption, genderoption, phoneoption);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = false, priority = 1)
	public void continueAsGuest() {
		try {
			PageInstance.createAccount().continueAsGuest();
		} catch (Exception e) {
		}
	}

	@Test(enabled = false, priority = 2, dataProvider = "orderdata")
	public void Order(String menuType, String itemName) throws InterruptedException {
		test = extent.startTest("TS04_Bite App: Order item");
		PageInstance.menus().selectOrderTab();
		PageInstance.menus().LetsOrderButton();
		PageInstance.menus().selectMenuFromOrder(menuType);
		PageInstance.menus().selectItemFromOrderList(itemName);
		PageInstance.menus().clickAddToMyOrder();
		PageInstance.menus().clickOnReviewOrder();
	}

	@Test(enabled = false, priority = 3, dataProvider = "login")
	public void LoginFromOrder(String email, String password) throws InterruptedException {
		test = extent.startTest("TS05_Bite App: Login from order");
		PageInstance.order().clickLogin();
		Login(email, password);
	}

	@Test(enabled = false, priority = 5, dataProvider = "instructions")
	public void finalOrder(String instruction) throws InterruptedException {
		PageInstance.order().SwipDown();
		PageInstance.order().enterInstructionHere(instruction);
		PageInstance.order().placeOrder();
	}

	@Test(enabled = false, priority = 6, dataProvider = "cardDetails")
	public void LinkCard(String cardnumber, String mm, String year, String cvv, String zipcode) throws InterruptedException {
		PageInstance.order().AddPaymentMethod();
		PageInstance.card().FillCardDetails(cardnumber, mm, year, cvv, zipcode);
	}

	@Test(enabled = false, priority = 3, dataProvider = "review")
	public void reviewOrder(String reviewcomments, String menuorder) {
		test = extent.startTest("TS04_Bite App: Review Order with Rating");
		try {
			PageInstance.review().fillReview(reviewcomments);
			PageInstance.review().backToOrderMenu();
			PageInstance.menus().selectOrder(menuorder);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@DataProvider(name = "review")
	public static Object[][] review() {
		return TestUtil.getData("review");
	}
	@DataProvider(name = "launch")
	public static Object[][] launchData() {
		return TestUtil.getData("launch");
	}

	@DataProvider(name = "instructions")
	public static Object[][] instructions() {
		return TestUtil.getData("instructions");
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
	
	@DataProvider(name = "orderdata")
	public static Object[][] orderdata() {
		return TestUtil.getData("orderdata");
	}
	
	
	@DataProvider(name = "cardDetails")
	public static Object[][] cardDetails() {
		return TestUtil.getData("cardDetails");
	}
	
	@AfterTest
	public void endSession() {
		extent.endTest(test);
		extent.flush();
		extent.close();
		System.out.println("Ending Script....");
	}
}
