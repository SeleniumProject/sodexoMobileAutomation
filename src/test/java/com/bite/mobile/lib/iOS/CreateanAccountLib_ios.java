package com.bite.mobile.lib.iOS;

import org.testng.Assert;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.ios.CreateAccount_iOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CreateanAccountLib_ios extends ScreenBase{

	public String  createAnaccountlable ="Create an Account";
	public String  emailtxt ="Email";
	public String  nextbtn="Next";
	public String  guestSignIn = "Continue as Guest";
	public String  nextletscreateanaccountlbl = "Next, Let's create an Account";
	public String  editboxes="Edit boxes";
	public String  firstnametxt ="First Name";
	public String  lastnametxt ="LastName";
	public String  passwordtx= "Password";
	public String  verifypassword="Verify Password";
	public String  termsconditionchkbox= "Terms check box";
	public String  privacypolicylink = "Privacy policy link";
	public String  signupbtn="SIGN UP";
	
	public String month ="Month";
	public String year ="Year";
	public String gender ="Gender";
	public String phonenumber ="Phone Number";
	public String allDonebtn ="ALL DONE !";
	public String notnowlink ="Not Now link";
	
	public CreateanAccountLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	public void CreateAnAccount(String email, String createAnAccountlbl, String nextletscreateaccountlbl, String firstName, String lastName,
			String password, String verifyPwd, String monthoption, String yearoption, String genderoption, String phoneoption) throws Throwable {
		try {
			   Thread.sleep(2500);
			String actualText = getText(CreateAccount_iOS.createAnaccountlbl);
			System.out.println(actualText +" Create Account lable");
		     Assert.assertEquals(actualText, createAnAccountlbl);
		     Type(CreateAccount_iOS.emailtxt, email, emailtxt);
		     click(CreateAccount_iOS.nextbtn, nextbtn);
		     Thread.sleep(2500);
		     String text = getText(CreateAccount_iOS.nextletscreateanaccountlbl);
		     System.out.println(text +"next lets create ");
		     Assert.assertEquals(text, nextletscreateaccountlbl);
		     Type(CreateAccount_iOS.firstnametxt, firstName, firstnametxt);
		     Type(CreateAccount_iOS.lastnametxt, lastName, lastnametxt);
		     Type(CreateAccount_iOS.passwordtxt, password, passwordtx);
		     Type(CreateAccount_iOS.verifypasswordtxt, verifyPwd, verifypassword);
		     click(CreateAccount_iOS.termsconditionchkbox, termsconditionchkbox);
		     click(CreateAccount_iOS.signupbtn, signupbtn);
		     Thread.sleep(2500);
		     LongPressButton(CreateAccount_iOS.Monthbtn);
		     
		     CreateAccount_iOS.selectValueFromPopUp(monthoption, month);
		    // LongPressButton(CreateAccountScreen.yearbtn);
		     Tap(799, 907, year);
		     CreateAccount_iOS.selectValueFromPopUp(yearoption, year);
		     Tap(248, 1113, gender);
//		     LongPressButton(CreateAccountScreen.genderbtn);
		     CreateAccount_iOS.selectValueFromPopUp(genderoption, gender);
		     Tap(154, 1290, phonenumber);
		     Type(CreateAccount_iOS.mobilenotxt, "+1 301-987-4772", phonenumber);
		     click(CreateAccount_iOS.alldonebtn, allDonebtn);
		     click(CreateAccount_iOS.notnowlink, notnowlink);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
    
	
	}
	public String SetEmail() {
		String email = CreateAccount_iOS.RandomEmail();
		return email;
	}
	
}
