package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.response.Response;

public class ParsingJsonResponseData {
	@Test(priority = 1)
	void testjsonResponse() {

		given().contentType("aaplication.json").pathParam("pathParam", "users").queryParams("page", 2).when()
				.get("https://reqres.in/api/{pathParam}").then().statusCode(200)
				.body("data[4].last_name", equalTo("Edwards"));
	}

	@Test(priority = 2)
	void testJsonResponseWay2() {

		Response res = given().contentType("aaplication.json").pathParam("pathParam", "users").queryParams("page", 2)

				.when().get("https://reqres.in/api/{pathParam}");
		Assert.assertEquals(res.getStatusCode(), 200);

		String lname = res.jsonPath().getString("data[4].last_name").toString();
		Assert.assertEquals(lname, "Edwards");

	}

	@Test(priority = 3)
	void testJsonResponseBody() {

		Response res = given().contentType("aaplication.json").pathParam("pathParam", "users").queryParams("page", 2)
				.when().get("https://reqres.in/api/{pathParam}");

		JSONObject jo = new JSONObject(res.asString());
		for (int i = 0; i <= jo.getJSONArray("data").length(); i++) {
			String lname = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.println(lname);
		}

	}
}
