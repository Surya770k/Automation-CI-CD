package UiPageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class  webElements {


	//-Login Page

	@FindBy(id="net.safefleet.focus.dev:id/buttonDismissNotification")
	public static WebElement Login_Page_DismissNoInternetNotification;

	@FindBy(id="net.safefleet.focus.dev:id/editTextOfficerId")
	public static WebElement Login_Page_OfficerIdTextBox;

	@FindBy(id="net.safefleet.focus.dev:id/buttonContinue")
	public static WebElement Login_Page_Continue;

	@FindBy(id="net.safefleet.focus.dev:id/editTextDevicePassword")
	public static WebElement Login_Page_DevicePasswordTextBox;

	@FindBy(id="net.safefleet.focus.dev:id/buttonConnect")
	public static WebElement Login_Page_Connect;

	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout")
	public static WebElement Login_Page_SelectWifi;
	
	@FindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	public static WebElement Login_Page_Connect_to_Wifi;
	


	@FindBy(id="net.safefleet.focus.dev:id/textViewCustomSnackBarResult")
	public static WebElement Login_Page_RetryPopup;
	
	@FindBy(id="net.safefleet.focus.dev:id/textViewOfficerId")
	public static WebElement Login_Page_OfficerID;

	@FindBy(id="net.safefleet.focus.dev:id/retrySnackBarButton")
	public static WebElement Login_Page_RetryButton;

	@FindBy(id="net.safefleet.focus.dev:id/textViewOfficerId")
	public static WebElement Login_Page_OfficerIdText;
	
	//Permission Dialogs
	
	@FindBy(id="net.safefleet.focus.dev:id/textViewSkip")
	public static  WebElement permission_accept__Skip;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public static WebElement permission_accept__Location;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public static WebElement permission_accept__NearbyDevices;
	
	
	
	
	//DashBoardPage
	
	@FindBy(id="net.safefleet.focus.dev:id/textLiveViewSwitch")
	public static WebElement DashBoardPage_LiveView_Text;
	
	@FindBy(id="net.safefleet.focus.dev:id/textViewBatteryPercent")
	public static WebElement DashBoardPage_BatteryPercent;
	
	@FindBy(id="net.safefleet.focus.dev:id/textViewStorageLevels")
	public static WebElement DashBoardPage_ViewStorageLevels;
	
	@FindBy(id="net.safefleet.focus.dev:id/imageViewCustomSnapshot")
	public static WebElement DashBoardPage_TakeSnapshot;
	
	@FindBy(id="net.safefleet.focus.dev:id/textViewCustomSnackBarResult")
	public static WebElement DashBoardPage_SnapshotSnackBarMessage;
	
	@FindBy(id="net.safefleet.focus.dev:id/imageButtonArrowHide")
	public static WebElement DashBoardPage_DownArrow;
	
	@FindBy(id="net.safefleet.focus.dev:id/imageButtonCovertMode")
	public static WebElement DashBoardPage_CovertModeIcon;
	
	@FindBy(id="net.safefleet.focus.dev:id/imageButtonBluetooth")
	public static WebElement DashBoardPage_BluetoothIcon;
	
	@FindBy(id="net.safefleet.focus.dev:id/imageViewCustomRecord")
	public static WebElement DashBoardPage_TakeVideo;
	
	@FindBy(id="net.safefleet.focus.dev:id/textLiveViewRecording")
	public static WebElement DashBoardPage_VideoRecordingText;

	
	//HamburgerMenu

	@FindBy(id="net.safefleet.focus.dev:id/closeMenu")
	public static WebElement  Hamburger_CloseMenu; 
	
	@FindBy(id="net.safefleet.focus.dev:id/buttonMenu")
	public static WebElement Hamburger_OpenHamburgerMenu;

	@FindBy(id="net.safefleet.focus.dev:id/imageButton")
	public static WebElement Hamburger_Logout;

	@FindBy(id="net.safefleet.focus.dev:id/buttonPositive")
	public static WebElement Hamburger_LogoutAccept;
	
	@FindBy(id="net.safefleet.focus.dev:id/textViewMessage")
	public static WebElement Hamburger_LogoutMessage;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
	public static List<WebElement> Hamburger_Values;
	
	
	//-Notification Page
	@FindBy(id="net.safefleet.focus.dev:id/buttonNotification")
	public static WebElement NotificationPage_NotificationBellIcon;
	
	@FindBy(id="net.safefleet.focus.dev:id/textViewTitle")
	public static WebElement NotificationPage_NotificationPageTitle;

	@FindBy(id="net.safefleet.focus.dev:id/imageButtonBackArrow")
	public static WebElement NotificationPage_BackArrow;
	

 
 
 
	//-Snap Shot Page Page
	@FindBy(id="net.safefleet.focus.dev:id/buttonSnapshotList")
	public static WebElement ViewSnapShotsButton;
 
	@FindBy(id="net.safefleet.focus.dev:id/textViewTitle")
	public static WebElement SnapShotPageTitle;
	
	
 
	//-videos Page
	@FindBy(id="net.safefleet.focus.dev:id/buttonVideoList")
	public static WebElement videosPage_ViewVideosButton; 
 
	@FindBy(id="net.safefleet.focus.dev:id/textViewTitle")
	public static WebElement videosPage_VideosPageTitle;
	
	
	//Body Camera Diagnosis
	
	@FindBy(id="net.safefleet.focus.dev:id/text_view_diagnose")
	public static WebElement Body_Camera_Diagnosis_Click; 
 
	@FindBy(id="net.safefleet.focus.dev:id/buttonStartDiagnosis")
	public static WebElement Body_Camera_Diagnosis_Start;
	
	@FindBy(id="net.safefleet.focus.dev:id/textTitleDiagnosis")
	public static WebElement Body_Camera_Diagnosis_SuccessMessgae; 
 
	@FindBy(id="net.safefleet.focus.dev:id/textDescriptionDiagnosis")
	public static WebElement Body_Camera_Diagnosis_DescriptionMessage;
	
	@FindBy(id="net.safefleet.focus.dev:id/imageButtonBackArrow")
	public static WebElement Body_Camera_Diagnosis_Close;
	
	

	
	

	

}
