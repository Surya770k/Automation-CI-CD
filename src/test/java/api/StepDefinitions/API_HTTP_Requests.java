package api.StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONObject;
import org.json.simple.JSONArray;

import com.itextpdf.text.log.SysoCounter;

import UiBaseComponents.BaseTest;
import UiBaseComponents.PropertyFileHandler;
import UiBaseComponents.TestSetup;
import UiPageObjects.PageTitels;
import apiBaseComponents.ApiBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import seleniumAppiumActions.ReusableActions;

import org.json.JSONObject;  
  


public class API_HTTP_Requests extends ApiBaseClass {

	public static Response response = null;
	public static String resString = null;
		


	public API_HTTP_Requests( ) throws IOException {
		super();
	} 
	
	@Given("I hit the Reqres API with a GET request")
	public void i_hit_api_reqres_website() {
		test = logInfo.get().createNode("I hit API reqres Website");

		response = given().relaxedHTTPSValidation().baseUri(baseURI).and().when().
				get("users/1").then().extract().response();
		
	//	System.out.println(response);
		resString =response.asPrettyString();
		//System.out.println(resString);
		reportPayload(response.asPrettyString());
		if(response!=null)
			reportPass("Status", "Pass", "Pass");
		else
			reportFail("Status", "Request Not sent", "Request Not sent");
	
	}
	
	@Then("I verify the status code as {string}")
	public void i_verify_the_status_code_a(String string) {
		try {
			test = logInfo.get().createNode("I verify the status code as "+string);
			reportInfo("Status Code "+response.statusCode());
			validateField("Status Code", "200", String.valueOf(response.statusCode()));
		}
		catch (Exception e) {
			testStepHandle("FAIL", test, e);
		}

	}
	
	@Then("I Validate the User ID in the Response")
	public void i_validate_the_response() {
	    try {
	        test = logInfo.get().createNode("I Validate the User ID in the Response");
	        JsonPath js = new JsonPath(resString);
	        String userId = js.getString("data.id");
	     //   System.out.println(js);
	        
	        if (userId != null && userId.equals("1")) {
	            reportPass("User ID", userId, userId);
	        } else {
	            reportFail("User ID", "not found or does not match", "not found or does not match");
	        }
	    } catch (Exception e) {
	        testStepHandle("FAIL", test, e);
	    }
	}
	
//	@Then("I get the All User ID and Associated Emails")
//	public void i_get_the_all_user_id_and_associated_emails() {
//		
//		System.out.println("EXE");
//		
//		test = logInfo.get().createNode("I hit API reqres Website");
//
//		response = given().relaxedHTTPSValidation().baseUri(baseURI).and().when().
//				get("users").then().extract().response();
//	
//		String jsonDataString = "{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"image\":{\"url\":\"images/0001.jpg\",\"width\":200,\"height\":200},\"thumbnail\":{\"url\":\"images/thumbnails/0001.jpg\",\"width\":32,\"height\":32}}";
//
//				 //"{userInfo : [{username:abc123}, {username:xyz123},{username:pqr123},   {username:mno123},{username:jkl123}]}";
//	      JSONObject jsonObject = new JSONObject(jsonDataString);
//	      List<String> list = new ArrayList<String>();
//	      org.json.JSONArray jsonArray = jsonObject.getJSONArray("id");
//	      
//	      
//	        // Iterate jsonArray using for loop   
//	        for (int i = 0; i < jsonArray.length(); i++) {  
//	              
//	            // store each object in JSONObject  
//	            JSONObject explrObject = jsonArray.getJSONObject(i);  
//	              
//	            // get field value from JSONObject using get() method  
//	            System.out.println(explrObject.get("width"));  
//	            System.out.println(explrObject.get("height"));  
//	        } 
//	 
//	
////		 // convert JSON string into JSON Object using JSONObject() method  
////        JSONObject json = new JSONObject(response);   
////        System.out.println(json);
////          
////        // get locations array from the JSON Object and store it into JSONArray  
////       
////        // get locations array from the JSON Object and store it into JSONArray  
////        org.json.JSONArray jsonArray = json.getJSONArray("data");  
////          
////        // Iterate jsonArray using for loop   
////        for (int i = 0; i < jsonArray.length(); i++) {  
////              
////            // store each object in JSONObject  
////            JSONObject explrObject = jsonArray.getJSONObject(i);  
////              
////            // get field value from JSONObject using get() method  
////            System.out.println(explrObject.get("id"));  
////            System.out.println(explrObject.get("email"));  
////            
////            reportPayload((explrObject.get("id")));
////            reportPayload((explrObject.get("email")));
////         
////
////
////		
////	
////	}
//	        ReusableActions obj = new ReusableActions(null);
//	        response = obj.executePost("baseuri","path","quary");
//	        response = obj.executeDelete("baseuri","path","quary","path to jsonfile");
//
//	}
	

}



		
	  
	











