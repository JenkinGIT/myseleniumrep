package RestAssuredTraining.Parser;
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
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class Test_Parser {

	//@Test
	public void testDefaultParser1() {
		//Any one can be used
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.defaultParser = Parser.XML;
		RestAssured.defaultParser = Parser.HTML;
	}
	
	//@Test
	public void testDefaultParser2() {
		given().get("http://thomas-bayer.com/sqlrest/CUSTOMER/02/").then().using().defaultParser(Parser.JSON);
		given().get("http://thomas-bayer.com/sqlrest/CUSTOMER/02/").then().using().defaultParser(Parser.HTML);
	}
	
	/*Custom parser for - "application/vnd.uoml+xml" type
	 * Syntax: RestAssured.registerParser(<content-type>,<parser>);*/
	@Test
	public void testCustomParser() {
		RestAssured.registerParser("application/vnd.uoml+xml", Parser.XML);
		RestAssured.unregisterParser("application/vnd.uoml+xml");
	}
	
	
	
}
