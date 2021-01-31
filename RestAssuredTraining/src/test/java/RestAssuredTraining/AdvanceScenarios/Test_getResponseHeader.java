package RestAssuredTraining.AdvanceScenarios;
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

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
public class Test_getResponseHeader {

/*	Get Response Header*/
	
	@Test
	public void testResponseHeader() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		
		//to get single header
		String headerCFRAY = response.getHeader("CF-RAY");
		System.out.println(">>>>>>> Header: "+headerCFRAY);
		
		System.out.println();
			
		
		// to get all header
		Headers headers = response.getHeaders();
		for(Header h: headers) {
			System.out.println(h.getName()+":"+h.getValue());
		}
		
	
		
	
	}
		
	/*Get Cookies*/
	@Test
	private void testGetCookies() {
		// TODO Auto-generated method stub
		Response response2=get("http://jsonplaceholder.typicode.com/photos");
		Map<String,String> cookies = response2.getCookies();
		
		for(Map.Entry<String, String> entry : cookies.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	
	/*Get Detailed Cookies*/
	@Test
	public void testDetailedCookies() {
		Response response3=get("http://jsonplaceholder.typicode.com/photos");
		
		Cookie a = response3.getDetailedCookie("__cfduid");
		System.out.println("Detailed:"+a.hasExpiryDate());
		System.out.println("Detailed:"+a.getExpiryDate());
		System.out.println("Detailed:"+a.hasValue());
	}
	
	/*Multiple Cookies can be set in request param
	 * todo- test example not runnable code*/
	
	@Test
	public void testSetMultiCookiesInRequest() {
		//to set multi value
		given().cookie("key","val1","val2"); // This will create 2 cookies key =val1; key =val2
		
		//to set detailed cookie
		Cookie cookie1 =new Cookie.Builder("some_cookie","some_value").setSecured(true).setComment("Some comment").build();
		Cookie cookie2 =new Cookie.Builder("some_cookie","some_value").setSecured(true).setComment("Some comment").build();
		
		Cookies cookies =new Cookies(cookie1,cookie2);
		given().cookies(cookies).when().get("/cookie").then().body(equalTo("X"));
	}
	
	/*We can pass single header, headers with multiple values and multiple headers*/
	//@Test
	public void testSetHeaders() {
		given().
			header("K","V").
			header("K2","V2","V3","V4").
			headers("k1","v1","k2","v2").
		when().get("https://api.fonts.com/rest/json/Accounts").
		then().statusCode(400);
	}
	
	/*Content type also can be set*/
	@Test
	public void testContentType() {
		given().
			contentType(ContentType.JSON).
			contentType("application/json;charset=utf-8").
		when().
			get("https://api.fonts.com/rest/json/Accounts").
		then().
			statusCode(400);
	}

}
