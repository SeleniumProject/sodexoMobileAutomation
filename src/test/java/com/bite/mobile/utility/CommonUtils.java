package com.bite.mobile.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String BASE_PKG;
	public static String APP_PATH;
	public static String APP_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APPIUM_PORT;
	public static URL serverUrl;
	public static String UDID;
	public static String BUNDLE_ID;
	public static String APP;
	public static String AUTOMATION_INSTRUMENTATION;
	private static String reportDirectory = "reports";
	private static String reportFormat = "html";
	private static String testName = "Bite App Test Automation";
	private static Properties prop = new Properties();
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	
	private static AppiumDriver<MobileElement> driver;

	// loadAndroidConfProp

	public static void loadAndroidConfProp(String propertyFileName) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/" + propertyFileName);
		prop.load(fis);

		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		APP_PATH = prop.getProperty("application.path");
		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		//BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		APPIUM_PORT = prop.getProperty("appium.server.port");

	}
	
	// loadIOSConfProp
	
	public static void loadIOSConfProp(String propertyFileName) throws IOException
	 {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+propertyFileName);
		prop.load(fis);
		
		EXPLICIT_WAIT_TIME = Integer
				.parseInt(prop.getProperty("explicit.wait"));
		IMPLICIT_WAIT_TIME = Integer
				.parseInt(prop.getProperty("implicit.wait"));
		//APPLICATION_NAME = prop.getProperty("application.path");
		UDID = prop.getProperty("udid");
		APP = prop.getProperty("application.app");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		AUTOMATION_INSTRUMENTATION=prop.getProperty("automation.instumentation");
		DEVICE_NAME=prop.getProperty("device.name");
		//BROWSER_NAME=prop.getProperty("browser.name");
		PLATFORM_NAME=prop.getProperty("platform.name");
		PLATFORM_VERSION=prop.getProperty("platform.version");
		BUNDLE_ID = prop.getProperty("bundle.id");

}
	public static void setIOSCapabilities() {
		capabilities.setCapability("reportDirectory", reportDirectory);
		capabilities.setCapability("reportFormat", reportFormat);
		capabilities.setCapability("testName", testName);
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
				CommonUtils.BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				CommonUtils.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				CommonUtils.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				CommonUtils.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				CommonUtils.AUTOMATION_INSTRUMENTATION);
//		capabilities.setCapability("resetOnSessionStartOnly",true);
		capabilities.setCapability("ios.native",true);
		capabilities.setCapability("installOnlyForUpdate", true);
//		capabilities.setCapability("unicodeKeyboard", "true");                                     
		capabilities.setCapability("resetKeyboard", "true");
//		capabilities.setCapability("applicationClearData",true);
		capabilities.setCapability("instrumentApp", true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//		capabilities.setCapability(MobileCapabilityType.NO_RESET, "True");

		//capabilities.setCapability(MobileCapabilityType.APP, CommonUtils.APPLICATION_NAME);
	
		capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,
				CommonUtils.BUNDLE_ID);
		capabilities.setCapability(MobileCapabilityType.UDID,
				CommonUtils.UDID);
		
		 
	}
	
	// setAndroidCap

	public static void setAndroidCapabilities() {
		capabilities.setCapability("reportDirectory", reportDirectory);
		capabilities.setCapability("reportFormat", reportFormat);
		capabilities.setCapability("testName", testName);
		
		File filePath = new File(System.getProperty("user.dir"));
		File appDir = new File(filePath, "src\\test\\resources\\app");
		File app = new File(appDir, "com.sodexo.noram.stage.com.apk");
		
		//File app = new File(path+"\\src\\test\\resources\\app\\com.sodexo.noram.stage.com.apk");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		// capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
		// PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
//		capabilities.setCapability("resetKeyboard", true);
//		capabilities.setCapability("unicodeKeyboard", true);
//		capabilities.setCapability("auto	ceptAlerts", true);
//		capabilities.setCapability("autoDismissAlerts", true);
//		 capabilities.setCapability("skipUnlock","true");
//		capabilities.setCapability("testdroid_testTimeout", 1200);
		capabilities.setCapability("noReset", "false");
//		capabilities.setCapability("fullReset","true");
		capabilities.setCapability("takesScreenshot", true);
		capabilities.setCapability("dataReset", true);
//		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("app", app.getAbsolutePath());
//		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
//		

	}
	
	// setIOSCap
	
	

	// getAndroidDriver

	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {

//		serverUrl = new URL("http://127.0.0.1:" + APPIUM_PORT + "/wd/hub");
		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
//        driver.resetApp();
		return driver;

	}

	// getIOSDriver
	public static AppiumDriver<MobileElement> getIOSDriver() throws MalformedURLException {

		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		driver = new IOSDriver<MobileElement>(serverUrl, capabilities);
//        driver.resetApp();
		return driver;

	}

}
