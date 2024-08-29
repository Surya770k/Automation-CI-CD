package UiBaseComponents;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


import java.net.URL;
import java.sql.Driver;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

//import Focus_MobileApp_ComponentGroups.ReusableLibrary;

public class SetUpAppiumDriver {

	public static void setupDriver( ) throws Exception {
        
        Properties properties = new Properties(); 

	    PropertyFileHandler.readProperties(properties);
	    String platform = properties.getProperty("platform_Name"); 

        // Initialize driver based on the platform    
        AppiumDriver driver;
        
        
        if (platform.equalsIgnoreCase("Android")) {
        	TestSetup testSetup = new TestSetup();
            driver = initializeAndroidDriver(testSetup);
        } 
        
        else if (platform.equalsIgnoreCase("iOS")) {
        	TestSetup testSetup = new TestSetup();
            driver = initializeiOSDriver(testSetup);
        } 
        
        else {
            throw new IllegalArgumentException("Invalid platform name");
        }

  
    }

    public static AndroidDriver initializeAndroidDriver(TestSetup testSetup) {
  
        AndroidDriver driver;
        try {
        	Properties properties = new Properties();
        	PropertyFileHandler.readProperties(properties);
        	System.out.println("Connected with device (" +properties.getProperty("Android_Device_Id")+ ") Trying to initializing Android Driver");
        	 
  	        DesiredCapabilities Ds = new DesiredCapabilities();
  	          
  	        Ds.setCapability("deviceName", properties.getProperty("Android_Device_Id"));
  	      	Ds.setCapability("platformName", "Android");
  	      	Ds.setCapability("platformVersion",properties.getProperty("Android_Platform_Version"));
  	      	  	        
   	       URL url = new URL("http://127.0.0.1:4723/wd/hub");
   	       driver = new AndroidDriver(url, Ds);
           testSetup.setDriver(driver);
          
           System.out.println("Initialized "+driver + "Sucessfully");
           
           TestSetup.pageObjectManager = new PageObjectManager(driver);
           
          // TestSetup.reusableLibrary = new ReusableLibrary(driver); 
 
          
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Android driver: " + e.getMessage());
        }
        return driver;
    }
    
    
    public static IOSDriver initializeiOSDriver(TestSetup testSetup) {
    	   
        IOSDriver driver;
        try {
        	System.out.println("initializing");
        	
        	DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "14.0"); // iOS version
            capabilities.setCapability("deviceName", "iPhone Simulator"); // Device name or UDID
            capabilities.setCapability("automationName", "XCUITest"); // Use XCUITest for iOS
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new IOSDriver(url, capabilities);
        
            System.out.println("Initialized "+driver);

        } 
        catch (Exception e) {
            throw new RuntimeException("Failed to initialize iOS driver: " + e.getMessage());
        }
        return driver;
    }
    
    


}
