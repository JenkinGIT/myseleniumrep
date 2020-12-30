package RestAssuredTraining.AdvanceScenarios;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


import org.testng.annotations.Test;

public class Test1_BasicFeatures {
	
	/*
		Simple checking Status code
	*/
	@Test
	public void testStatusCode() {
		given().
			get("http://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200);
	}
	
	/*
		Simple checking Status code and printing complete response log
	*/
	
	@Test
	public void testLogging() {
		given().
			get("http://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200).
			log().all();
	}

	

	/*
		Verifying single content using org.hamcrest.Matchers library's equalTo method
	*/
	
	@Test
	public void testEqualToFunction() {
		given().
			get("http://jsonplaceholder.typicode.com/posts/3").
		then().
			body("id", equalTo(3)).
			statusCode(200).
			log().all();
	}

	/*
		Verifying multiple content using org.hamcrest.Matchers library's equalTo method
	*/
	
	@Test
	public void testhasItemsFunction() {
		given().
			get("https://reqres.in/api/users").
		then().
			body("data.first_name", hasItems("Charles","Tracey")).
			statusCode(200).
			log().all();
	}
	
	/*
		Test parameters and headers
	 */
	
	@Test
	public void testParametersAndHeaders() {
		given().
//			param("Key1", "Val1").
//			header("headA","headVal").
		when().
			get("https://reqres.in/api/users").
		then().
			body("data.first_name", hasItems("Charles","Tracey")).
			statusCode(200).
			log().all();
	}
	
	/*
		using And to increase readablity. Generally used when writting in one line xpath style
	 */

	@Test
	public void testAndFeatureForReadablity() {
		given().param("Key1", "Val1").and().header("headA","headVal").when().get("https://reqres.in/api/users").then().body("data.first_name", hasItems("Charles","Tracey")).statusCode(200).log().all();
	}

/*	Xpath is also used to find values
*/	
	@Test
	public void testUsingXpath1() {
		given().
			get("https://reqres.in/api/users").
		then().
			//body("data.first_name", hasItems("Charles","Tracey")).
			body(hasXPath("/data/first_name",containsString("Charles"))).
			statusCode(200).
			log().all();
	}
}
