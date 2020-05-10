package com.bite.mobile.testScripts.android;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.android.CreateanAccountLib_android;
import com.bite.mobile.lib.android.HomeScreenLib_android;
import com.bite.mobile.lib.android.LoginScreenLib_android;
import com.bite.mobile.lib.android.MenusScreenLib_android;
import com.bite.mobile.lib.android.ReviewScreenLib_android;
import com.bite.mobile.utility.TestUtil;

public class EndToEndScript_android extends TestBase{
	
	
	HomeScreenLib_android home;
	LoginScreenLib_android login;
	CreateanAccountLib_android signup;
	MenusScreenLib_android menus;
	ReviewScreenLib_android review;
	@BeforeTest
	public void init(){
	
	   home = new HomeScreenLib_android(driver);
	   login = new LoginScreenLib_android(driver);
	   signup = new CreateanAccountLib_android(driver);
	   menus = new MenusScreenLib_android(driver);
	   review = new ReviewScreenLib_android(driver);
	}
	
	
	@Test(priority = 0, dataProvider="launch")
	public void LaunchBiteApp(String location) throws Throwable{
			test = extent.startTest("TS01_Bite App: Launch App and Search For Location");
			try {
			home.launchApp();
			home.searchAndSelectLocation(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = false, priority =1, dataProvider = "CreateAccountData" )
	public void createAnAccount(String email, String createAnAccountlbl,  String nextletscreateaccountlbl, String firstName, String  lastName, String password, String verifyPwd, String  monthoption, String yearoption, String genderoption, String phoneoption ) throws Throwable
	{
		test = extent.startTest("TS02_Bite App: Create an Account");
        email = signup.setEmail();
		try {
			signup.createAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password, verifyPwd, monthoption, yearoption, genderoption, phoneoption);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority =1, dataProvider = "login" )
	public void Login(String email, String password) {
		test = extent.startTest("TS03_Bite App: Login to Bite App");
				
			try {
				signup.enterEmailPressNext(email);
				login.Login(email, password);
			} catch (Throwable e) {
				e.printStackTrace();
			}		
	}
	
	@Test(priority =2, dataProvider = "menuData" )
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
	@Test(priority = 3)
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
	
	@DataProvider(name="launch")
	public static Object[][] launchData() {
		return TestUtil.getData("launch");
	}
	
	@DataProvider(name="login")
	public static Object[][] login() {
		return TestUtil.getData("login");
	}
	
	@DataProvider(name="CreateAccountData")
	public static Object[][] CreateAccountData() {
		return TestUtil.getData("createanaccount");
	}
	
	@DataProvider(name="menuData")
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
