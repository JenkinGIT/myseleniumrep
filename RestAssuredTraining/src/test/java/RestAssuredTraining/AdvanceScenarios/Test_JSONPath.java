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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
public class Test_JSONPath {
	
/*Extract details as a String and Fetching further details w/o using json path*/	
	//@Test
	public void testJsonPath1() {
		String responseAsString=
		when().
			get("http://jsonplaceholder.typicode.com/photos").
		then().
			extract().asString();
		List<Integer> albumIds = from(responseAsString).get("id");
		System.out.println(albumIds.size());
	}
	
	
	/*Extract details as a String and Fetching further details w/o using json path*/	
	@Test
	public void testJsonPath2() {
		String json=
		when().
			get("http://jsonplaceholder.typicode.com/photos").
		then().
			extract().asString();
		System.out.println(json);
		//@SuppressWarnings("deprecation")
		JsonPath jsonPath =new JsonPath(json).setRoot("RestResponse.result");
		List<String> list = jsonPath.get("id");
		System.out.println("Total size is="+list.size());
	}

}
