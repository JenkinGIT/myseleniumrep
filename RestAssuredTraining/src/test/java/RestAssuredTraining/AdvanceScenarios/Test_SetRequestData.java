package RestAssuredTraining.AdvanceScenarios;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
public class Test_SetRequestData {

	/*
		Generally CONNECT used with HTTPS request
		refer: http://stackoverflow.com/questions/11697943/when-should-one-use-connect-and-get-http-methods-at-http-proxy-server
	*/
	@Test
	public void testConnectRequest(){
		when().
			request("CONNECT","https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	/* In Get request we can set query parameters
	*/
	@Test
	public void testQueryParameter() {
		given().
			queryParam("A", "Val A").
			queryParam("B", "Val B").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	/*
	In post request we can set form parameter
	*/
	@Test
	public void testFormParameters() {
		given().
			formParam("A", "Val A").
			formParam("B", "Val B").
		when().
			get("https://api.fonts.com/rest/json/Domains/").
		then().
			statusCode(400);
	}
	
	/*
	In post request we can set form parameter
	*/
	@Test
	public void testSetParameters() {
		given().
			param("A", "Val A").
			param("B", "Val B").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	/*
	To Set parameters- recomended way
	If request is Get then param will be treated as QueryParameter
	If request is Post then param will be treated as FormParameter
	*/
	
	@Test
	public void tesSetParameters() {
		given().
			param("A", "Val A").
			param("B", "Val B").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	/*To Set multiple value parameters
	 * We can pass list, multiple values or no values in param
	 * */	
	@Test
	public void testSetMultipleValueParameter() {
		List<String> list=new ArrayList<String>();
		list.add("One");
		list.add("Two");
		
		given().
			param("A", "Val A","Val B","Val C").
			param("B").
			param("C", list).
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
		
	}
}
