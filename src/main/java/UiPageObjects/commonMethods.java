package UiPageObjects;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import UiBaseComponents.PropertyFileHandler;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import seleniumAppiumActions.ReusableActions;

public class commonMethods  extends ReusableActions{


	public  AndroidDriver driver;

	public commonMethods(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, webElements.class);
 
	}

	

	public void  permissiondialogs() {
		
			waitForElementToBeClickableThenClick(webElements.permission_accept__Skip);
			//waitForElementToBeClickableThenClick(webElements.permission_accept__Location);
			waitForElementToBeClickableThenClick(webElements.permission_accept__NearbyDevices);  
		
	}
 

	public String connectVirtualDevice() throws MalformedURLException {

		String deviceConnectStatus = driver.currentActivity();

		return deviceConnectStatus;
	}



	public  boolean checkAppInstallationStatus() throws InterruptedException {

		boolean IsAppInstalled = driver.isAppInstalled("net.safefleet.focus.dev");

		if(IsAppInstalled) {
			return IsAppInstalled;
		}
		else {

			System.out.println("App not installed");
			
			return false;	
			 
		}
		
	}
	

	public void openMenu() {

		new TouchAction<>(driver).press(PointOption.point(802,2332)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(0)))

		.moveTo(PointOption.point(802, 1700))

		.release().perform();

	}



	public String launchAppUsingDesiredCapabilities(Map<String, String> testData) throws InterruptedException {

		sleepMAX();

		String currentActivity = driver.currentActivity();

		System.out.println("Current activity : "+currentActivity);

		return currentActivity;
	}

	public String closeApp() throws InterruptedException {

		String appPackage = driver.getCurrentPackage();
		
		System.out.println("App package for terminate : "+appPackage);
		
		driver.terminateApp(appPackage);
		
		sleepMin();
		
		String currentActivity = driver.currentActivity();

		return currentActivity;
	}


	public void openRecentScreens(int...args) throws InterruptedException {

		new TouchAction<>(driver).press(PointOption.point(args[0],args[1])).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))

		.moveTo(PointOption.point(args[2], args[3])).release().perform();

		sleepMin();
	}


	public String killAPP(int...args) throws Exception

	{

		new TouchAction<>(driver).press(PointOption.point(args[0],args[1])).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(0)))

		.moveTo(PointOption.point(args[2], args[3])).release().perform();

		sleepMin();
		
		String currentActivity = driver.currentActivity();

		return currentActivity;
	}



	public void quiteAndroidDriver() {

		driver.quit();

	}
















}
