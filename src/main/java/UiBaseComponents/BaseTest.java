package UiBaseComponents;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;

//import DemoWebShop.componentgroups.ResponseTags;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class BaseTest extends SuperTestNG{



	public AndroidDriver driver;
	


	public BaseTest() throws IOException {

	} 
	 
	
	public void driverQuit(AndroidDriver driver ) {
		driver.quit();
	}




	
	public void startServerAutomatically() {
 

        // Set the desired logging level (e.g., info, warn, error, debug)
        String logLevel = "error"; // Adjust as needed
        
        System.out.println("Trying to Start appium server Programattically. . .");
        
      
        // Build the Appium service
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(NodeExePath))
                .withAppiumJS(new File(NodeJSMainPath))
                .withIPAddress(ServerAddress)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(() -> "--log-level", logLevel) 
                .usingPort(Port));

        // Start the Appium server
        service.start();

        System.out.println("Appium server started on port :"+Port);

    }
	
	public void closeBrowser() {
		driver.close();
	}

	
	
    
    public void startActivity() {
    	driver.executeScript("mobile: startActivity", 
                "{\"appPackage\":\"" + "net.safefleet.focus.dev" + "\",\"appActivity\":\"" + "com.lawmobile.presentation.ui.splash.SplashActivity" + "\"}");
    }
    

 

	public String getScreenshot(String testCaseName, AndroidDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}



	public static void zoomOut(int s) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < s; i++) {

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public static void zoomIn(int s) throws AWTException { 
		Robot robot = new Robot();
		for (int i = 0; i < s; i++) {

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}


	public void reportInfo(String msg) {
		test.pass(msg);
	}

	public void reportPass(String title, String exp, String act) {
		String message = "<b>" + "Expected " + title + " : " + "</b>" + "<font color=" + "green>" + exp + "</font>"
				+ "\t" + "<b>" + "Actual " + title + " : " + "</b>" + "<font color=" + "green>" + act + "</font>";
		test.pass(message);
	}

	public void reportFail(String title, String exp, String act) {
		String message = "<b>" + "Expected " + title + " : " + "</b>" + "<font color=" + "red>" + exp + "</font>" + "\t"
				+ "<b>" + "Actual " + title + " : " + "</b>" + "<font color=" + "red>" + act + "</font>";
		test.fail(message);
		softAssert.assertEquals(exp, act);
	}

	public void reportPayload(String msg) {
		Markup m = MarkupHelper.createCodeBlock(msg, CodeLanguage.JSON);
		test.info(m);
	}

	public void validateField(String title, String expected, String actual) {

		if (expected.equals(actual))
			reportPass(title, expected, actual);
		else
			reportFail(title, expected, actual);
	}

	public void validateNullValues(String title, String actual) {

		if (actual == null)
			reportPass(title, "shold have null ", "contain null");
		else
			reportFail(title, "shold have null ", "contain null");
	}

	public void reportScreenshot(String status, String exp, String act, AndroidDriver driver) throws IOException {

		String message = "<b>" + "Expected : " + "</font>" + "</b>" + exp + "\t" + "<b>" + "Actual : " + "</b>" + act;
		if (status.equals("PASS"))
			test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		else if (status.equals("FAIL"))
			test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		else if (status.equals("INFO"))
			test.info(message, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
	}

	public void reportScreenshot(AndroidDriver driver) throws IOException {

		test.info("<b>" + "<font color=" + "orange>" + "Screenshot" + "</b>",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
	}

	public String captureScreenShot(AndroidDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		// String dest = System.getProperty("user.dir")+"\\" +"AutomationReports"+"\\" +folderName+ "\\" + getcurrentdateandtime() + ".jpg";
		String dest = System.getProperty("user.dir")+"\\" +"Reports"+ "\\" +"ExecutionReports"+"\\"+ getcurrentdateandtime() + ".jpg";


		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}
	
	

	private static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}

	public void testStepHandle(String teststatus, AndroidDriver driver, ExtentTest extenttest, Throwable throwable) {
		switch (teststatus) {
		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
			extenttest.log(Status.FAIL, throwable.fillInStackTrace());

			try {
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
			} catch (IOException e) {
				// e.printStackTrace();
			}
			softAssert.fail();
			//VideoRecorder.stopRecording();
			break;

		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
			break;

		default:
			break;
		}
	}




	//Random String Generator

	public String randomStringGenerator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		String timestamp = sdf.format(date);
		String randomString = "testauto" + timestamp;
		return randomString;
	}

	//Random Integer Generator
	public String randomIntGenerator() {

		Random rand = new Random();
		int num = rand.nextInt((int) Math.pow(10, 10));
		return String.valueOf(num);

	}

	//// Random Email Generator

	public String randomEmailGenerator() {

		String[] emailProviders = {"gmail.com", "yahoo.com", "hotmail.com", "aol.com", "outlook.com"};
		Random random = new Random();
		String randomString = "testauto";
		for (int i = 0; i < 4; i++) {
			char c = (char) (random.nextInt(26) + 'a');
			randomString += c;
		}
		return randomString + "@" + emailProviders[random.nextInt(emailProviders.length)];

	}

	public static String getRamdomMAcAddress() {
		Random rand = new Random();
		return String.format("%02x-%02x-%02x-%02x-%02x", rand.nextInt(256), 0x5e, rand.nextInt(256), 0x53, 0xaf);
	}




}
