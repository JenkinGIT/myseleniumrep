package RestAssuredTraining.RestAssuredTraining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestGet {
	
	@Test
	public void test_1() {
		given().
			get("https://reqres.in/api/users").
		then().
			statusCode(200).
			body("data.id[1]",equalTo(2)).
			body("data.first_name",hasItems("George","Janet","Emma")).
			log().all();
	}
	

}
