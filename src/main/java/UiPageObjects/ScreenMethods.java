package UiPageObjects;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class ScreenMethods  extends ReusableActions{

	AndroidDriver driver;

	public ScreenMethods(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		PageFactory.initElements(driver, webElements.class);
	} 

	
	//LoginPage
	
	public boolean ValidateOfficerScreenText() throws InterruptedException {
		
		Properties properties = new Properties();
    	PropertyFileHandler.readProperties(properties);
    	waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_DismissNoInternetNotification);
		
		  String status = getWebelementText(webElements.Login_Page_OfficerIdText);
		  
		  if (status.equals(PageTitels.OFFICER_ID_PAGE)) {
			 
			  return true;
		  }else {
			  return false;
		  }
	}
	
	public boolean retryPopUpPresent() {	  
		  String status = getWebelementText(webElements.Login_Page_RetryPopup);
		  
		  if (status!=null) {
			  return true;
		  }else {
			  return false;
		  }
		
	}
	
	public void LoginToFocusMobileApp() throws Exception {

		Properties properties = new Properties();
		PropertyFileHandler.readProperties(properties);

		String Flow=properties.getProperty("Flow");
		if(Flow.equals("SSO-FLOW-Nexus")) {


		}
		else if(Flow.equals("DEFAULT-FLOW-Nexus")){

		//	waitForElementToBeClickableThenClickFMA_LoginPage(DismissNoInternetNotification);
			waitForElementToBeClickableThenSendkeysFMA_LoginPage(webElements.Login_Page_OfficerIdTextBox, properties.getProperty("NX_OFFICER_ID"));
			waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_Continue);
			Thread.sleep(20000);
			
			 try {
			  if (retryPopUpPresent()==true) {
	                // Retry logic
	                waitForElementToBeClickableThenClick(webElements.Login_Page_RetryButton);
	                waitForElementToBeClickableThenSendkeysFMA_LoginPage(webElements.Login_Page_DevicePasswordTextBox, properties.getProperty("NX_OFFICER_PASSWORD"));;
	    			waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_Connect);
	            } else {
	                // Successful login
	               // handleSuccessfulLogin();
	            	System.out.println("successfull login");
	            	waitForElementToBeClickableThenSendkeysFMA_LoginPage(webElements.Login_Page_DevicePasswordTextBox, properties.getProperty("NX_OFFICER_PASSWORD"));;
	    			waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_Connect);
	            }}catch (Exception e) {
	                // Handle any unexpected exceptions
	            	//System.out.println("successfull login");
	            	waitForElementToBeClickableThenSendkeysFMA_LoginPage(webElements.Login_Page_DevicePasswordTextBox, properties.getProperty("NX_OFFICER_PASSWORD"));;
	    			waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_Connect);
	            } 
			

			try {

				//waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_SelectWifi);
				waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_Connect_to_Wifi);
			} catch (StaleElementReferenceException e) {
				//waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_SelectWifi);
				waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_Connect_to_Wifi);
			}


		}

	}
	
	public String ValidateOfficerScreenAfterLogout() {
		waitForElementToBeClickableThenClickFMA_LoginPage(webElements.Login_Page_DismissNoInternetNotification);
		String Status=getWebelementText(webElements.Login_Page_OfficerIdText);
		return Status;
		
	}
	
	
	
	
	//DashBoardPage
	
	public String ValidateFocusMobileAppLogin() {

		String ValidateFMALoginText = getWebelementText(webElements.DashBoardPage_LiveView_Text);
		return ValidateFMALoginText;

	}
	
	public void TakeSnapshot() throws InterruptedException {
	
		
		waitForElementToBeClickableThenClick(webElements.DashBoardPage_TakeSnapshot);

//		try {
//
//			String message =waitForElementToAppear(webElements.DashBoardPage_SnapshotSnackBarMessage);
//			return message;
//		} catch (StaleElementReferenceException e) {
//			getWebelementText(webElements.DashBoardPage_SnapshotSnackBarMessage);String message =	getWebelementText(webElements.DashBoardPage_SnapshotSnackBarMessage);
//			return message;
//		}
	}
	
	
	public void TakeVideo() throws InterruptedException {
	
		waitForElementToBeClickableThenClick(webElements.DashBoardPage_TakeVideo);;
		System.out.println("Video Recording");

	}
	
	
	public String ValidateVideoRecording() throws InterruptedException {

		String RecordingText = getWebelementText(webElements.DashBoardPage_VideoRecordingText);
		waitForElementToBeClickableThenClick(webElements.DashBoardPage_TakeVideo);
		System.out.println("Video Recording Ended");
		return RecordingText;

	}
	
	
	
	
	
	public String CaptureBodyCameraBatteryPercentage() {
		String BatteryPercentage = getWebelementText(webElements.DashBoardPage_BatteryPercent);
		return BatteryPercentage;
		
	}
	
    public String CaptureBodyCameraStorageLevel() {
    	String BatteryLevel =getWebelementText(webElements.DashBoardPage_ViewStorageLevels);
    	return BatteryLevel;
		
	}
    
    public void ValidateBodyCameraSettings() {
    	waitForElementToBeClickableThenClick(webElements.DashBoardPage_DownArrow);
    	waitForElementToBeClickableThenClick(webElements.DashBoardPage_CovertModeIcon);
    	waitForElementToBeClickableThenClick(webElements.DashBoardPage_BluetoothIcon); 
    	
    	boolean covertstatus1 = driver.findElement(By.id("net.safefleet.focus.dev:id/imageButtonCovertMode")).isDisplayed();
    	System.out.println("covertstatus for is displayed"+covertstatus1);
    	
    	boolean covertstatus2 = driver.findElement(By.id("net.safefleet.focus.dev:id/imageButtonCovertMode")).isEnabled();
    	System.out.println("covertstatus for is enabled"+covertstatus2);
    	

    	boolean covertstatus3 = driver.findElement(By.id("net.safefleet.focus.dev:id/imageButtonCovertMode")).isSelected();
    	System.out.println("covertstatus for is selected"+covertstatus3);
    	
    	boolean Bluetoothstatus1 = driver.findElement(By.id("net.safefleet.focus.dev:id/imageButtonBluetooth")).isDisplayed();
    	System.out.println("Bluetoothstatus for is displayed"+covertstatus1);
    	
    	boolean Bluetoothstatus2 = driver.findElement(By.id("net.safefleet.focus.dev:id/imageButtonBluetooth")).isEnabled();
    	System.out.println("Bluetoothstatus for is enabled"+Bluetoothstatus2);
    	

    	boolean Bluetoothstatus3 = driver.findElement(By.id("net.safefleet.focus.dev:id/imageButtonBluetooth")).isSelected();
    	System.out.println("Bluetoothstatus for is selected"+Bluetoothstatus3);
    	
    }
	
	
	
	//HamburgerMenu
	

	public void SelectHamburgerMenu() throws InterruptedException {
		waitForElementToBeClickableThenClick(webElements.Hamburger_OpenHamburgerMenu);
		
		
	}
	
	public void CloseHamburgerMenu() throws InterruptedException {
		 waitForElementToBeClickableThenClick(webElements.Hamburger_CloseMenu);
		 Thread.sleep(1000);
	}
	
	public void CloseBodyCameraDiagonis() throws InterruptedException {
		 waitForElementToBeClickableThenClick(webElements.Body_Camera_Diagnosis_Close);
	}

	

	public void ClickLogout() throws InterruptedException {
		waitForElementToBeClickableThenClick(webElements.Hamburger_Logout);
		waitForElementToBeClickableThenClick(webElements.Hamburger_LogoutAccept);

		
	}
	
	public void ClickAccept() {
		waitForElementToBeClickableThenClick(webElements.Hamburger_LogoutAccept);
	
	}


	public void SelectHamburgerMenuAndLogout() throws InterruptedException {

		waitForElementToBeClickableThenClick(webElements.Hamburger_OpenHamburgerMenu);
		Thread.sleep(3000);

		waitForElementToBeClickableThenClick(webElements.Hamburger_Logout);
		Thread.sleep(3000);

		waitForElementToBeClickableThenClick(webElements.Hamburger_LogoutAccept);


	}
	
	
	
	public String validateHamburgerMenuValues() throws InterruptedException {
	    List<String> expectedValues = new ArrayList<>();


		
	    String ActualValues = PageTitels.HAMBURGER_MENU_OPTIONS;
	    String[] valuesArray = ActualValues.split(",");
	    expectedValues = new ArrayList<>(Arrays.asList(valuesArray));

	    List<WebElement> actualElements = webElements.Hamburger_Values;

	    // Check if actualElements list is not empty before accessing its last element
	    if (actualElements.isEmpty()) {
	        System.out.println("Actual elements list is empty!");
	        return "Actual elements list is empty!";
	    }

	    // Preprocess actual elements list to remove numbers
	    List<String> processedActualValues = new ArrayList<>();
	    for (WebElement element : actualElements) {
	        String text = element.getText().replaceAll("\\d", ""); // Remove any digits
	        processedActualValues.add(text.trim().toLowerCase()); // Add the processed text to the list
	    }

	    // Validate that the sizes of the lists match
	    if (expectedValues.size() != processedActualValues.size()) {
	        System.out.println("The sizes of the lists do not match!");
	        System.out.println("exp size" + expectedValues.size());
	        System.out.println("Act Size" + processedActualValues.size());
	        return "List Size Not Matched";
	    }

	    // Validate that each element in the actual list matches the corresponding element in the expected list
	    for (int i = 0; i < expectedValues.size(); i++) {
	        String expectedValue = expectedValues.get(i).trim().toLowerCase(); // Normalize expected value
	        String actualValue = processedActualValues.get(i); // Use processed actual value

	        if (!expectedValue.equals(actualValue)) {
	            System.out.println("Value " + (i + 1) + " does not match! Expected: " + expectedValue + ", Actual: " + actualValue);
	            return "Options Not Matched";
	        }
	    }

	    // If all elements match, return matched
	    return "Options Matched";
	}






	public void ClickBodyCameraDiagonis() {
		
		waitForElementToBeClickableThenClick(webElements.Body_Camera_Diagnosis_Click);
	
		
	}
	
	
	public String ValidateBodyCameraDiagonis() {
		
		waitForElementToBeClickableThenClick(webElements.Body_Camera_Diagnosis_Start);
		String BodyCameraDiagnosisSuccessMessgae=getWebelementText(webElements.Body_Camera_Diagnosis_SuccessMessgae);
		return BodyCameraDiagnosisSuccessMessgae;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



//	//-Login Page
//
//	@FindBy(id="net.safefleet.focus.dev:id/buttonDismissNotification")
//	WebElement DismissNoInternetNotification;
//
//	@FindBy(id="net.safefleet.focus.dev:id/editTextOfficerId")
//	WebElement OfficerIdTextBox;
//
//	@FindBy(id="net.safefleet.focus.dev:id/buttonContinue")
//	WebElement Continue;
//
//	@FindBy(id="net.safefleet.focus.dev:id/editTextDevicePassword")
//	WebElement DevicePasswordTextBox;
//
//	@FindBy(id="net.safefleet.focus.dev:id/buttonConnect")
//	WebElement Connect;
//
//	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout")
//	WebElement SelectWifi;
//
//	@FindBy(id="net.safefleet.focus.dev:id/textLiveViewSwitch")
//	WebElement ValidateFMALogin;
//
//	@FindBy(id="net.safefleet.focus.dev:id/textViewOfficerId")
//	WebElement OfficerIdText;
//	
//
//	@FindBy(id="net.safefleet.focus.dev:id/textViewCustomSnackBarResult")
//	WebElement RetryPopup;
//	
//	@FindBy(id="net.safefleet.focus.dev:id/textViewOfficerId")
//	WebElement OfficerID;
//	
//	
//
//	@FindBy(id="net.safefleet.focus.dev:id/retrySnackBarButton")
//	WebElement RetryButton;
//	
//
//
//	public void LoginToFocusMobileApp() throws Exception {
//
//		Properties properties = new Properties();
//		PropertyFileHandler.readProperties(properties);
//
//		String Flow=properties.getProperty("Flow");
//		if(Flow.equals("SSO-FLOW-Nexus")) {
//
//
//		}
//		else if(Flow.equals("DEFAULT-FLOW-Nexus")){
//
//		//	waitForElementToBeClickableThenClickFMA_LoginPage(DismissNoInternetNotification);
//			waitForElementToBeClickableThenSendkeysFMA_LoginPage(OfficerIdTextBox, properties.getProperty("NX_OFFICER_ID"));
//			waitForElementToBeClickableThenClickFMA_LoginPage(Continue);
//			Thread.sleep(30000);
//			
//			 try {
//			  if (retryPopUpPresent()) {
//	                // Retry logic
//	                waitForElementToBeClickableThenClick(RetryButton);
//	                waitForElementToBeClickableThenSendkeysFMA_LoginPage(DevicePasswordTextBox, properties.getProperty("NX_OFFICER_PASSWORD"));;
//	    			waitForElementToBeClickableThenClickFMA_LoginPage(Connect);
//	            } else {
//	                // Successful login
//	               // handleSuccessfulLogin();
//	            	System.out.println("successfull login");
//	            	waitForElementToBeClickableThenSendkeysFMA_LoginPage(DevicePasswordTextBox, properties.getProperty("NX_OFFICER_PASSWORD"));;
//	    			waitForElementToBeClickableThenClickFMA_LoginPage(Connect);
//	            }}catch (Exception e) {
//	                // Handle any unexpected exceptions
//	            	//System.out.println("successfull login");
//	            	waitForElementToBeClickableThenSendkeysFMA_LoginPage(DevicePasswordTextBox, properties.getProperty("NX_OFFICER_PASSWORD"));;
//	    			waitForElementToBeClickableThenClickFMA_LoginPage(Connect);
//	            } 
//			
//
//			try {
//
//				waitForElementToBeClickableThenClickFMA_LoginPage(SelectWifi);
//			} catch (StaleElementReferenceException e) {
//				waitForElementToBeClickableThenClickFMA_LoginPage(SelectWifi);
//			}
//
//
//		}
//
//	}
//
//	
//	public boolean retryPopUpPresent() {	  
//		  String status = getWebelementText(RetryPopup);
//		  
//		  if (status!=null) {
//			  return true;
//		  }else {
//			  return false;
//		  }
//		
//	}
//	
//	
//	public boolean ValidateOfficerScreenText() {
//		
//		Properties properties = new Properties();
//    	PropertyFileHandler.readProperties(properties);
//    	waitForElementToBeClickableThenClickFMA_LoginPage(DismissNoInternetNotification);
//		
//		  String status = getWebelementText(OfficerIdText);
//		  
//		  if (status.equals(APPCOMPONENTS.OFFICER_ID_PAGE)) {
//			 
//			  return true;
//		  }else {
//			  return false;
//		  }
//	}
//	
//	//DashBoardPage
//	
//	public String ValidateFocusMobileAppLogin() {
//
//		String ValidateFMALoginText = getWebelementText(ValidateFMALogin);
//		return ValidateFMALoginText;
//
//	}
//	
//	//HamburgerMenu
//
//
//	@FindBy(id="net.safefleet.focus.dev:id/buttonMenu")
//	WebElement HamburgerMenu;
//
//	@FindBy(id="net.safefleet.focus.dev:id/imageButton")
//	WebElement Logout;
//
//	@FindBy(id="net.safefleet.focus.dev:id/buttonPositive")
//	WebElement LogoutAccept;
//	
//	@FindBy(id="net.safefleet.focus.dev:id/textViewMessage")
//	WebElement LogoutMessage;
//	
//	@FindBy(id="net.safefleet.focus.dev:id/textViewOfficerId")
//	WebElement EnterOfficerIdText;
//
//	
//	@FindBy(id="net.safefleet.focus.dev:id/closeMenu")
//	WebElement CloseMenu;
//	
//	
//	public void SelectHamburgerMenu() {
//		waitForElementToBeClickableThenClick(HamburgerMenu);
//		
//		
//	}
//	
//	public void CloseHamburgerMenu() throws InterruptedException {
//		 waitForElementToBeClickableThenClick(FMA_webElements.Hamburger_CloseMenu);
//	}
//
//	
//
//	public void ClickLogout() throws InterruptedException {
//		waitForElementToBeClickableThenClick(Logout);
//		Thread.sleep(1000);
//
//		
//	}
//	
//	public void ClickAccept() {
//		waitForElementToBeClickableThenClick(LogoutAccept);
//	
//	}
//
//
//	public void SelectHamburgerMenuAndLogout() throws InterruptedException {
//
//		waitForElementToBeClickableThenClick(HamburgerMenu);
//		Thread.sleep(3000);
//
//		waitForElementToBeClickableThenClick(Logout);
//		Thread.sleep(3000);
//
//		waitForElementToBeClickableThenClick(LogoutAccept);
//
//
//	}
//	
//	public String ValidateOfficerScreenAfterLogout() {
//		waitForElementToBeClickableThenClickFMA_LoginPage(DismissNoInternetNotification);
//		String Status=getWebelementText(OfficerIdText);
//		return Status;
//		
//	}
//	
//	
	
	
	
	
	
	

}
