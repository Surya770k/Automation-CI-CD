package seleniumAppiumActions;

import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

//repetitive in nature such as waits, actions, capturing screenshots, accessing excels, sending email, etc.,

public class ReusableActions {
	
    public static  AndroidDriver driver;
	
	public static int SLEEP_MIN=1500;
	public static int SLEEP_AVG=3000;
	public static int SLEEP_MAX=5000;


	public ReusableActions(AndroidDriver driver) {
		this.driver = driver;
	}
	
//	
//	public  void waitForElementToAppear(By findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
//	}
	
	public String waitForElementToAppear(WebElement webElement) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	   String text = wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
		return text;
	}

	// Note: I corrected the usage of visibilityOfElementLocated and removed the incorrect `.gettext` part.


	public   void waitForElementToBeClickableThenClick(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();

	}
	
	public   void waitForElementToBeClickableThenClickFMA_LoginPage(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();

	}

	public void waitForElementToBeClickableThenClick(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();

	}

	public void waitForElementToBeClickableThenSendkeys(WebElement webElement, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(data);

	}
	
	public void waitForElementToBeClickableThenSendkeysFMA_LoginPage(WebElement webElement, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(data);
		// driver.findElement((By) webElement).sendKeys(data);
	}

	public void waitForElementToBeClickableThenClearThenSendkeys(WebElement webElement, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(data);
		// driver.findElement((By) webElement).sendKeys(data);
	}

	public void waitForElementToBeClickableThenSendkeys(By findBy, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).sendKeys(data);
		;

	}

	public String waitForPresenceOfElementThenGettext(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String text = wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement)).getText();
		return text;
	}

	public String waitForPresenceOfElementThenGettext(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
		return driver.findElement(findBy).getText();
	}

	public String getWebelementText(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOf(ele)).getText();
	}
	
	public String getWebelementTextPopup(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(ele)).getText();
	}
	
	public boolean waitForPresenceOfElement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement retryPopup = wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement));
		return retryPopup.isEnabled();
	}

	public void getAlertText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("alert was not present");
		} else {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert Text "+alert.getText());
			alert.accept();
			System.out.println("alert was present and accepted");
		}

		
	}

//	// Angular method to wait
//	public NgWebDriver getNGDriver() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		return (new NgWebDriver(js));
//	}
//
//	public void waitForAngularRequestsToFinish() {
//		try {
//			getNGDriver().waitForAngularRequestsToFinish();
//		} catch (Exception e) {
//			System.out.println("Failed :" + e);
//		}
//
//	}

	public String encodeData(String data) {
		String basicBase64format = Base64.getEncoder().encodeToString(data.getBytes());
		return basicBase64format;
	}

	public String decodeData(String encodedData) {
		byte[] actualByte = Base64.getDecoder().decode(encodedData);

		String actualString = new String(actualByte);
		return actualString;
	}
	public static void sleepMin() throws InterruptedException {
		Thread.sleep(SLEEP_MIN);
	}
	public static void sleepAvg() throws InterruptedException {
		Thread.sleep(SLEEP_AVG);
	}
	public static void sleepMAX() throws InterruptedException {
		Thread.sleep(SLEEP_MAX);
	}
	
	public void scrollToElement(String xpath) {
		String javascript = "arguments[0].scrollIntoView()";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		try {
			jsExecutor.executeScript(javascript, driver.findElement(By.xpath(xpath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void selectListByVisibleText(WebElement obj,String item)
	{
		try{

			Select select = new Select(obj);
			select.selectByVisibleText(item);
		}catch(Exception e)
		{

		}
	}

	public static void selectListByValue(WebElement obj,String item)
	{
		try{

			Select select = new Select(obj);
			select.selectByValue(item);
		}catch(Exception e)
		{

		}
	}

	public static void selectListByIndex(WebElement obj,int item)
	{
		try{

			Select select = new Select(obj);
			select.selectByIndex(item);
		}catch(Exception e)
		{

		}
	}

}
