package UiBaseComponents;

import org.openqa.selenium.remote.RemoteWebDriver;

import UiPageObjects.ScreenMethods;
import UiPageObjects.commonMethods;
import UiPageObjects.webElements;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {
	
	
	public AndroidDriver driver;
	
	public commonMethods sd;
	public ScreenMethods LP;
	public webElements Fs;

	

	
	
	
	
	
	public PageObjectManager(AndroidDriver driver) {
		this.driver=driver;
	}

	public commonMethods CommonMethods() { 
		sd = new commonMethods(driver);
		return sd;
	}
	

	public ScreenMethods methods() { 
		LP = new ScreenMethods(driver);
		return LP;
	}
	
//	public FMA_webElements FMA_webElements() { 
//		Fs = new FMA_webElements(driver);
//		return Fs;
//	}

	

	
}
