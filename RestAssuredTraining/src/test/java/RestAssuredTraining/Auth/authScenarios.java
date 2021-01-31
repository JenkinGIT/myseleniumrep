package RestAssuredTraining.Auth;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class authScenarios {
//	Basic + Digestive Auth
	/*  Type1:  Challenged Basic Authentication - Credential will not passed to server before, when server will ask explicitly than credentials will be passed to server.*/	
	//@Test
	public void testBasicChallangeAuth() {
		given().
			auth().
			basic("userName", "password").
		when().
			get("http://services.groupkt.com/country/get/all").
		then().
			statusCode(200);
	}
	
	
	/*  Type2:  Preemptive: Basic Authentication - Credential will be passed to server before it asked.*/	
	@Test
	public void testBasicPreemptiveAuthentication() {
		given().
			auth().
			preemptive().
			basic("userName", "password").
		when().
			get("http://services.groupkt.com/country/get/all").
		then().
			statusCode(200);
	}
	
	/*  Type3:  Authentication set for all call.*/	
	@Test
	public void testBasicAuthentication() {
		RestAssured.authentication = basic("userName", "password");
		
		given().
		when().
			get("http://services.groupkt.com/country/get/all").
		then().
			statusCode(200);
	}
	
	
	/*  Type4:  Challenged digest authentication i,e min two request response  combination required
	 * 	Digest authentication is more secure than basic authentacion as it involve a new Digestive key.
	 *   
	 *   */	
	@Test
	public void testDigestiveAuthentication() {
		given().
		auth().
		digest("userName", "password").
	when().
		get("http://services.groupkt.com/country/get/all").
	then().
		statusCode(200);	
	
	
	}
	
	
}
