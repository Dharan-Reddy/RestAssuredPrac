package Day2;

import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameter {

	@Test
	void testPathAndQueryParameters() {

		given().pathParam("pathParam", "users") // pathparam needs to create variable as a key and it has to specify in
												// url
				.queryParams("page", 2) // For query param no need to create a variable and no need to specify in url
				.queryParams("id", 7).when().get("https://reqres.in/api/{pathParam}")
				.then().statusCode(200).log().all();
	}

}