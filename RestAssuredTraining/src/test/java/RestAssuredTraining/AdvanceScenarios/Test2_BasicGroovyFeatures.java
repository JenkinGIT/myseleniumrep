package RestAssuredTraining.AdvanceScenarios;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
public class Test2_BasicGroovyFeatures {

	
/*	Verify some expected names are present in the list or not*/
	
	@Test
	public void testPresenceOfElements() {
		given().
			get("https://reqres.in/api/users").
		then().
			body("data.first_name", hasItems("George","Janet","Emma","Eve","Charles","Tracey")).
			log().
			all();
	}
	
	
/*	Verify adding length of all alpha2 code coming in response*/
	//Restassured implemented Groovy and hence Groovy advantage should be taken.
	//@Test
	public void testLengthOfResponse() {
		given().
			get("http://services.groupkt.com/country/search?text=islands").
		then().
			body("RestResponse.result.alpha3_code*.length().sum()", greaterThan(50)).log().all();
	}
}

