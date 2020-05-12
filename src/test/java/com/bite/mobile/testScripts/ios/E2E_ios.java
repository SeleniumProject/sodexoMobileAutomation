package com.bite.mobile.testScripts.ios;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.android.CreateAccountLib_android;
import com.bite.mobile.lib.android.HomeLib_android;
import com.bite.mobile.lib.android.LoginLib_android;
import com.bite.mobile.lib.android.MenusLib_android;
import com.bite.mobile.lib.iOS.CreateanAccountLib_ios;
import com.bite.mobile.lib.iOS.HomeLib_ios;
import com.bite.mobile.lib.iOS.LoginLib_ios;
import com.bite.mobile.lib.iOS.MenusLib_ios;
import com.bite.mobile.utility.TestUtil;

public class E2E_ios extends TestBase{
	
	
	HomeLib_ios home;
	LoginLib_ios login;
	CreateanAccountLib_ios signup;
	MenusLib_ios menus;
	@BeforeTest
	public void init(){
	
	   home = new HomeLib_ios(driver);
	   login = new LoginLib_ios(driver);
	   signup = new CreateanAccountLib_ios(driver);
	   menus = new MenusLib_ios(driver);
	}
	
	
	@Test(priority = 0, dataProvider="launch")
	public void LaunchBiteApp(String location) throws InterruptedException{
			test = extent.startTest("TS01_Bite App: Launch App and Search For Location");
			try {
				Thread.sleep(2500);
			home.LaunchApp("crossroads");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority =1, dataProvider = "CreateAccountData" )
	public void CreateAnAccount(String email, String createAnAccountlbl,  String nextletscreateaccountlbl, String firstName, String  lastName, String password, String verifyPwd, String  monthoption, String yearoption, String genderoption, String phoneoption ) throws Throwable
	{
		test = extent.startTest("TS02_Bite App: Create an Account");
         email = signup.SetEmail();
      
		try {
			Thread.sleep(2000);
			signup.CreateAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password, verifyPwd, monthoption, yearoption, genderoption, phoneoption);
	       	menus.selectMenu("Corporate Master Menu");
	       	menus.selectDateAndItem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name="launch")
	public static Object[][] launchData() {
		return TestUtil.getData("launch");
	}
	
	@DataProvider(name="CreateAccountData")
	public static Object[][] CreateAccountData() {
		return TestUtil.getData("createanaccount");
	}
	
	@AfterTest
	public void quit() {
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.resetApp();
		System.out.println("Ending Script....");
	}

}