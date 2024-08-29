package UiBaseComponents;
import java.awt.AWTException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
//import org.zaproxy.clientapi.core.ClientApiException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;



public class Listeners extends BaseTest implements ITestListener{
	
	private static ExtentReports extent;
	private List<ITestResult> passedTests = new ArrayList<>();
	private List<ITestResult> failedTests = new ArrayList<>();
	private List<ITestResult> skippedTests = new ArrayList<>();

 
	public Listeners() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	} 

	public void onTestFailure(ITestResult result) {
	

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(scenarioName +" : SKIPPED");


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		try { 
			startServerAutomatically();

			
			clearFolder(System.getProperty("user.dir") + "/Reports/ExecutionReports");

			//startTime =  getTimeStamp();
			SuperTestNG.extent= SuperTestNG.setUp();
			// to pass parameter
				

			

	        TestSetup testSetup = new TestSetup();
	        SetUpAppiumDriver.setupDriver();
	        
			FMA_Installation_Status =HandlingInstallation.FMA_Installation(TestSetup.driver); 

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void onFinish(ITestContext context) {
		try {

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		SuperTestNG.extent.flush();

		System.out.println("Server stopping now . . .");
		service.stop();
	}


}
