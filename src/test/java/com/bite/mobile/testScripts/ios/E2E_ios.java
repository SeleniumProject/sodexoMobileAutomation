package com.bite.mobile.testScripts.ios;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.iOS.CreateanAccountLib_ios;
import com.bite.mobile.lib.iOS.HomeLib_ios;
import com.bite.mobile.lib.iOS.LinkCardLib_ios;
import com.bite.mobile.lib.iOS.LoginLib_ios;
import com.bite.mobile.lib.iOS.MenusLib_ios;
import com.bite.mobile.lib.iOS.OrderLib_ios;
import com.bite.mobile.utility.Attributes;
import com.bite.mobile.utility.TestUtil;
public class E2E_ios extends TestBase{
	
	
	HomeLib_ios home;
	LoginLib_ios login;
	CreateanAccountLib_ios signup;
	MenusLib_ios menus;
	OrderLib_ios order;
	LinkCardLib_ios card;
	@BeforeTest
	public void init(){
	
	   home = new HomeLib_ios(driver);
	   login = new LoginLib_ios(driver);
	   signup = new CreateanAccountLib_ios(driver);
	   menus = new MenusLib_ios(driver);
	   order = new OrderLib_ios(driver);
	   card = new LinkCardLib_ios(driver);
	}
	
	@Attributes(Category = "Regression", State = "Ready")
	@Test(priority = 0, dataProvider="launch")
	public void LaunchBiteApp(String location) throws InterruptedException{
			test = extent.startTest("Bite App: Launch App and Search For Location");
			try {
				Thread.sleep(7000);
			home.LaunchApp("crossroads");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
	
	@Attributes(Category = "Regression", State = "Ready")
	@Test(enabled = true, priority = 1, dataProvider = "login")
	public void Login(String email, String password) throws InterruptedException {
		test = extent.startTest("Bite App: Login to Bite App");
		try {
			signup.enterEmailPressNext(email);
			login.Login(email, password);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@Attributes(Category = "Regression", State = "Ready")
	@Test(enabled = false, priority = 2, dataProvider = "menuData")
	public void selectingItem(String menuType, String itemName) {
		test = extent.startTest("Bite App: Selecting menu and item");
		int day = ScreenBase.convertDate();
		try {
			menus.selectMenu(menuType);
			menus.selectDateAndItem("16");
//			menus.ReviewButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Attributes(Category = "Regression", State = "Ready")
	@Test(enabled = true, priority = 2, dataProvider = "orderdata_ios")
	public void Order(String menuType, String itemName) throws InterruptedException {
		test = extent.startTest("Bite App: Order item");
		menus.selectOrderTab();
		
	   // menus.LetsOrderButton();
		menus.selectMenuFromOrder();
		menus.selectItemFromOrderList(itemName);
		menus.SelectItemFromItemDetails("White", "Double");
        menus.clickAddToMyOrder();
       menus.clickOnReviewOrder();
	}
	@Attributes(Category = "Regression", State = "Ready")
	@Test(enabled = true, priority = 3, dataProvider = "login")
	public void LoginFromOrder(String email, String password) throws Throwable {
		test = extent.startTest("Bite App: Login from Order Screen");
		order.Login(email, password);
	}
	@Attributes(Category = "Regression", State = "NotReady")
	@Test(enabled = true, priority = 4, dataProvider = "pickupdata")
	public void PickUpDetailsAndPlaceOrder(String place, String time, String phoneNumber, String nameoncard, String cardnum, String MM, String YY, String cvv) throws InterruptedException {
		test = extent.startTest("Bite App: Login from Order Screen");
		order.EnterPickUpPlace(place);
		order.PickUpTime(time);
		order.PhoneNumber(phoneNumber);
		order.clickPayByCard();
		card.FillCardDetails(nameoncard, cardnum, MM, YY, cvv);
		
	}
	@Test(enabled = false,priority =1, dataProvider = "CreateAccountData" )
	public void CreateAnAccount(String email, String createAnAccountlbl,  String nextletscreateaccountlbl, String firstName, String  lastName, String password, String verifyPwd, String  monthoption, String yearoption, String genderoption, String phoneoption ) throws Throwable
	{
		test = extent.startTest("Bite App: Create an Account");
         email = signup.SetEmail();
      
		try {
			Thread.sleep(2000);
			signup.CreateAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password, verifyPwd, monthoption, yearoption, genderoption, phoneoption);
	       	menus.selectMenu("Corporate Master Menu");
//	       	menus.selectDateAndItem();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	@DataProvider(name = "menuData")
	public static Object[][] menuData() {
		return TestUtil.getData("menuData");
	}
	
	@DataProvider(name="CreateAccountData")
	public static Object[][] CreateAccountData() {
		return TestUtil.getData("createanaccount");
	}
	
	@DataProvider(name = "orderdata")
	public static Object[][] orderdata() {
		return TestUtil.getData("orderdata");
	}
	
	@DataProvider(name = "cardDetails")
	public static Object[][] cardDetails() {
		return TestUtil.getData("cardDetails");
	}
	

}
