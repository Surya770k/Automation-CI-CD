package TestRunners;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import apiBaseComponents.ApiBaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(apiBaseComponents.Listeners.class) 
@CucumberOptions(features = {"src\\test\\java\\api\\FeatureFiles"},tags = "@Sanity", glue = "api.StepDefinitions", monochrome = true,plugin = {"html:target/cucumber.html"})
public class ApiRunner extends AbstractTestNGCucumberTests{
	@BeforeClass
	public void beforeCalss() throws AWTException, IOException {

}

}
 
 