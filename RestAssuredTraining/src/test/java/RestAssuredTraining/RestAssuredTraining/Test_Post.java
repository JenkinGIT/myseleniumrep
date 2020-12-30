package RestAssuredTraining.RestAssuredTraining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_Post {
	@Test
	public void test_1_post() {
		
//		gson
//		jackson
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		System.out.println(request);
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}

	@Test
	public void test_2_post() {
		
//		gson
//		jackson
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		System.out.println(request);
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).log().all();
	}
	@Test
	public void test_3_delete() {
			when().
				delete("https://reqres.in/api/users/2").
			then().
				statusCode(204).
				log().
				all();
	}
}
