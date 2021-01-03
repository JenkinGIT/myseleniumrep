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

	//@Test
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
			//body(hasXPath("/data/first_name",containsString("Charles"))).
			statusCode(200).
			log().all();
	}
	
/*	Basic way to test allparameters*/
	
//	@Test
	public void testWithoutRoot() {
		given().
			get("https://reqres.in/api/users").
		then().
			body("data.first_name", is("George")).
			body("data.last_name", is("Bluth")).
			body("data.email", is("george.bluth@reqres.in")).
			statusCode(200).
			log().all();
	}
	
	/*Recomemded way to test all paramers using root*/
	
	//@Test
	public void testWithRoot() {
		given().
			get("https://reqres.in/api/users").
		then().
			root("data").
			body("first_name", is("George")).
			body("last_name", is("Bluth")).
			body("email", is("george.bluth@reqres.in")).
			statusCode(200).
			log().all();
	}
	
	/*We can detach root path in between*/
	//@Test
	public void testDetachRoot() {
		given().
			get("https://reqres.in/api/users").
		then().
			root("data").
			body("first_name", is("George")).
			body("last_name", is("Bluth")).
			detachRoot("data").
			body("email", is("george.bluth@reqres.in")).
			statusCode(200).
			log().all();
	}
	
	
	/*Read response in different ways*/
	@Test
	public void testGetResponseAsString() {
		String responseString=get("https://reqres.in/api/users").asString();
		System.out.println("My Response is:\n\n\n"+responseString);
	}
	
	
	/*Get all response as Input string*/
	@Test
	public void testGetResponseAsInputStream() throws IOException {
		InputStream stream =get("https://reqres.in/api/users").asInputStream(); 
		System.out.println("Stream Length="+stream.toString().length());
		stream.close();
	}
	
	
	/*Extract details using path*/
	@Test
	public void testExtractDetailsUsingPath() {
		String href =
		when().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			contentType(ContentType.JSON).
			body("albumId", equalTo(1)).
		extract().
			path("url");
		System.out.println(href);
		
		when().get(href).then().statusCode(200);
	}
		
	
	/*Extract details using path in one line*/
	@Test
	public void testExtractPathInOneLine() {
		//type 1:
				
		String href1 =get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
		System.out.println("Fetched URL="+href1);
		when().get(href1).then().statusCode(200);
		
		
		//type 2:
		String href2 =get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().getString("thumbnailUrl");
		System.out.println("Fetched URL="+href2);
		when().get(href2).then().statusCode(200);
	}
	
	/*Extract details as Response for further use */
	@Test
	public void testExtraDetailsUsingResponse() {
		Response response=
		when().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			extract().
			response();
		System.out.println("Content Type="+response.contentType());
		System.out.println("Href:"+response.path("url"));
		System.out.println("Status Code:"+response.statusCode());
	}
		
	/*This test will verify the response schema with predefined existing schema */
	//Path=src/test/resources/geo-schema.json
	@Test
	public void testSchema() {
//		given().
//			get("http://jsonplaceholder.typicode.com/photos/1").
//		then().assertThat().body(matchJsonSchemaInClasspath("test3_geo_schema123.json"));
		
	}	
		
		
		
		
}
