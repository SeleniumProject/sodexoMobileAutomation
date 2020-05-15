package com.bite.mobile.lib.android;
import org.testng.Assert;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.CreateAccount_android;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CreateAccountLib_android extends ScreenBase{

	/**
	 * author : Ramesh K
	 * Name of the Elements in the Page or Screen
	 */
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
	
	/***
	 * Constructor of CreateAccount Library
	 * @param driver
	 */
	public CreateAccountLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	public void continueAsGuest() {
		click(CreateAccount_android.guestSignIn, guestSignIn);
	}
	public void createAnAccount(String email, String createAnAccountlbl, String nextletscreateaccountlbl, String firstName, String lastName,
			String password, String verifyPwd, String monthoption, String yearoption, String genderoption, String phoneoption) throws Throwable {
		try {
			waitforPageLoad(5);
			 String actualText = getText(CreateAccount_android.createAnaccountlbl);
			 System.out.println(actualText +" Create Account lable");
		     Assert.assertEquals(actualText, createAnAccountlbl);
		     Type(CreateAccount_android.emailtxt, email, emailtxt);
		     click(CreateAccount_android.nextbtn, nextbtn);
		 	 waitforPageLoad(5);
		     String text = getText(CreateAccount_android.nextletscreateanaccountlbl);
		     System.out.println(text +"next lets create ");
		     Assert.assertEquals(text, nextletscreateaccountlbl);
		     Type(CreateAccount_android.firstnametxt, firstName, firstnametxt);
		     Type(CreateAccount_android.lastnametxt, lastName, lastnametxt);
		     Type(CreateAccount_android.passwordtxt, password, passwordtx);
		     Type(CreateAccount_android.verifypasswordtxt, verifyPwd, verifypassword);
		     click(CreateAccount_android.termsconditionchkbox, termsconditionchkbox);
		     click(CreateAccount_android.signupbtn, signupbtn);
		 	 waitforPageLoad(5);
		     LongPressButton(CreateAccount_android.Monthbtn);
		     
		     CreateAccount_android.selectValueFromPopUp(monthoption, month);
		     Tap(799, 907, year);
		     CreateAccount_android.selectValueFromPopUp(yearoption, year);
		     Tap(248, 1113, gender);
		     CreateAccount_android.selectValueFromPopUp(genderoption, gender);
		     Tap(154, 1290, phonenumber);
		     Type(CreateAccount_android.mobilenotxt, "+1 301-987-4772", phonenumber);
		     click(CreateAccount_android.alldonebtn, allDonebtn);
		     click(CreateAccount_android.notnowlink, notnowlink);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
    
	
	}
	
	public void enterEmailPressNext(String email) {
	     Type(CreateAccount_android.emailtxt, email, emailtxt);
	     click(CreateAccount_android.nextbtn, nextbtn);
	}
	public String setEmail() {
		String email = CreateAccount_android.RandomEmail();
		return email;
	}
	
}
