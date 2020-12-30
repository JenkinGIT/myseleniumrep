package RestAssuredTraining.RestAssuredTraining;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

import org.testng.annotations.Parameters;

public class Test_Delete {
	@Parameters({"userID"})
	@Test
	public void test_3_delete() {
//			when().
//				delete("https://reqres.in/api/users/"+userID).
//			then().
//				statusCode(204).
//				log().
//				all();
	}
	
}
