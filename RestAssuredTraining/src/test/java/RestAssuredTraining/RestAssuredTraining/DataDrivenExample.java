package RestAssuredTraining.RestAssuredTraining;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample extends dataForTest {
	
	
	@Test(dataProvider ="DataForPost" )
	public void test_1_post(String name,String job) {
		
//		gson
//		jackson
		
		JSONObject request = new JSONObject();
		request.put("name", "name");
		request.put("job", "job");
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}


}
