			package com.bite.mobile.testScripts.ios;
			
			import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
			import org.testng.annotations.DataProvider;
			import org.testng.annotations.Test;
			import com.bite.mobile.base.TestBase;
			import com.bite.mobile.lib.iOS.CreateanAccountLib_ios;
			import com.bite.mobile.lib.iOS.HomeLib_ios;
			import com.bite.mobile.lib.iOS.LinkCardLib_ios;
			import com.bite.mobile.lib.iOS.LoginLib_ios;
			import com.bite.mobile.lib.iOS.MenusLib_ios;
			import com.bite.mobile.lib.iOS.OrderLib_ios;
			import com.bite.mobile.utility.Attributes;
			import com.bite.mobile.utility.PageInstance;
			import com.bite.mobile.utility.TestUtil;
import com.gargoylesoftware.htmlunit.Page;
			
			public class E2E_ios extends TestBase {
			
				HomeLib_ios home;
				LoginLib_ios login;
				CreateanAccountLib_ios ca_ios;
				MenusLib_ios menus;
				OrderLib_ios order;
				LinkCardLib_ios card;
			
				@BeforeTest
				public void init() {
			             //  resetApp();
				}
			
				@Attributes(Category = "Regression", State = "Ready")
				@Test(priority = 0, dataProvider = "launch")
				public void LaunchBiteApp(String location) throws InterruptedException {
					test = extent.startTest("Bite App: Launch App and Search For Location");
					try {
						PageInstance.home_ios().LaunchApp(location);
//						PageInstance.home_ios().continueAsGuest();
					} catch (Throwable e) {
			
						e.printStackTrace();
					}
				}
			
				@Attributes(Category = "Regression", State = "Ready")
				@Test(enabled = true, priority = 1, dataProvider = "login")
				public void Login(String email, String password) throws InterruptedException {
					test = extent.startTest("Bite App: Login to Bite App");
					try {
						PageInstance.ca_ios().enterEmailPressNext(email);
						PageInstance.login_ios().Login(email, password);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			
				@Attributes(Category = "Regression", State = "Ready")
				@Test(enabled = true, priority = 2, dataProvider = "menuData")
				public void selectingItem(String menuType, String itemName) {
					test = extent.startTest("Bite App: Selecting menu and item");
					// int day = ScreenBase.convertDate();
					try {
						PageInstance.menus_ios().selectMenu(menuType);
						Thread.sleep(2000);
						PageInstance.menus_ios().selectDate("16");
						Thread.sleep(2000);
						PageInstance.review_ios().clickReview();
						Thread.sleep(2000);
						PageInstance.review_ios().clickSmileEmoji();
						PageInstance.review_ios().EnterExperienceComments("Food is good");
						PageInstance.review_ios().submitReview();
						PageInstance.review_ios().closePopUP();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
				@Test(enabled = true, priority = 3)
				public void Order() throws Throwable {
					test = extent.startTest("Bite App: Order item");
					PageInstance.menus_ios().selectOrderTab();
					// menus.LetsOrderButton();
					PageInstance.menus_ios().AddToMyOrder();
					PageInstance.menus_ios().OnReviewOrder();
					PageInstance.menus_ios().Login();
					PageInstance.ca_ios().enterEmailPressNext("bitetest34@gmail.com");
					PageInstance.login_ios().Login("bitetest34@gmail.com", "Gmail123");
					
					PageInstance.menus().selectPayTab();
					PageInstance.menus().clickBitePay();
					PageInstance.card().AddPaymentMethod();
					PageInstance.card().FillCardDetails("5399999999999999", "12", "2023", "999", "98760");
					
				}
			
				@Attributes(Category = "Regression", State = "Ready")
				@Test(enabled = false, priority = 3, dataProvider = "login")
				public void LoginFromOrder(String email, String password) throws Throwable {
					test = extent.startTest("Bite App: Login from Order Screen");
					PageInstance.order_ios().Login(email, password);
				}
			
				@Attributes(Category = "Regression", State = "NotReady")
				@Test(enabled = false, priority = 4, dataProvider = "pickupdata")
				public void PickUpDetailsAndPlaceOrder(String place, String time, String phoneNumber, String nameoncard,
						String cardnum, String MM, String YY, String cvv) throws InterruptedException {
					test = extent.startTest("Bite App: Login from Order Screen");
					PageInstance.order_ios().EnterPickUpPlace(place);
					PageInstance.order_ios().PickUpTime(time);
					PageInstance.order_ios().PhoneNumber(phoneNumber);
					PageInstance.order_ios().clickPayByCard();
					PageInstance.card_ios().FillCardDetails(nameoncard, cardnum, MM, YY, cvv);
			
				}
			
				@Test(enabled = false, priority = 1, dataProvider = "CreateAccountData")
				public void CreateAnAccount(String email, String createAnAccountlbl, String nextletscreateaccountlbl,
						String firstName, String lastName, String password, String verifyPwd, String monthoption, String yearoption,
						String genderoption, String phoneoption) throws Throwable {
					test = extent.startTest("Bite App: Create an Account");
					email = PageInstance.ca_ios().SetEmail();
			
					try {
						Thread.sleep(2000);
						PageInstance.ca_ios().CreateAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password,
								verifyPwd, monthoption, yearoption, genderoption, phoneoption);
						menus.selectMenu("Corporate Master Menu");
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
			
				@DataProvider(name = "CreateAccountData")
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
				@DataProvider(name = "orderdata_ios")
				public static Object[][] orderdata_ios() {
					return TestUtil.getData("orderdata_ios");
				}
				
				
				@AfterTest
				public void endSession() {
					extent.endTest(test);
					extent.flush();
					extent.close();
					System.out.println("Ending Script....");
				}
			}
