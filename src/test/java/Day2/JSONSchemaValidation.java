package Day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

	@Test
	void jsonSchemaValidation() {
		given().pathParam("path", "users").queryParam("page", 2)
		.when().get("https://reqres.in/api/{path}")
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getlistusers.json"));
		
	}

}
