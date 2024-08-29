package UiBaseComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import UiPageObjects.commonMethods;
import io.appium.java_client.android.Activity;

//import DemoWebShop.componentgroups.ResponseTags;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class HandlingInstallation{


	public   AndroidDriver driver; 



   
	public static boolean FMA_Installation(AndroidDriver driver) throws Exception {
	    Properties properties = new Properties();
	    PropertyFileHandler.readProperties(properties);

	    String installationStatus = properties.getProperty("APP_Installation_Required");

	    if (installationStatus.equalsIgnoreCase("YES")) {
	        commonMethods cc = new commonMethods(driver);
	        boolean status = cc.checkAppInstallationStatus();
	        if (status) {
	            System.out.println("App already installed. Trying to uninstall...");
	            driver.removeApp(properties.getProperty("Dev"));
	            Thread.sleep(2000);
	            System.out.println("Trying to install the required version of the app...");
	            driver.installApp(System.getProperty("user.dir") + properties.getProperty("Path_of_Andriod_Apk"));
	            System.out.println("Trying to launch the app...");
	            driver.activateApp(properties.getProperty("Dev"));
	            commonMethods cm = new commonMethods(driver);
	            cm.permissiondialogs();
	            return true;
	        } else {
	            System.out.println("Trying to install the required version of the app...");
	            driver.installApp(System.getProperty("user.dir") + properties.getProperty("Path_of_Andriod_Apk"));
	            System.out.println("Trying to launch the app...");
	            driver.activateApp(properties.getProperty("Dev"));
	            commonMethods cm = new commonMethods(driver);
	            cm.permissiondialogs();
	            return true; 
	        }
	    } else if (installationStatus.equalsIgnoreCase("NO")) {
	        System.out.println("App installation not required as per user.");
	        System.out.println("Trying to launch the app...");
	        driver.activateApp(properties.getProperty("Dev"));
	        return false;
	    }

	    return false;
	}

	
		



	}

	
	



	
	


