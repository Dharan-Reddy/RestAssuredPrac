package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DifferentWaysToCreatePostRequests {

	@Test(priority = 1)
	void testPostUsingHashMap() {

		HashMap map = new HashMap();
		map.put("name", "john");
		map.put("location", "india");
		map.put("phone", "1234567890");
		String courseArr[] = { "c", "c++" };
		map.put("courses", courseArr);

		given().contentType("application/json").body(map).when().post("url").then().statusCode(200).log().all()
				.body("name", equalTo("john")).body("location", equalTo("india")).body("phone", equalTo("1234567890"))
				.body("courses[0]", equalTo("c")).body("courses[1]", equalTo("c++"));
	}

	@Test(priority = 2)
	void testPostUsingJsonLibrary() {
		JSONObject json = new JSONObject();
		json.put("name", "scott");
		json.put("location", "us");
		json.put("phone", "12345");
		String courseArr[] = { "python", "java" };
		json.put("courses", courseArr);

		given().contentType("application/json").body(json.toString()).when().post("url").then().statusCode(200)
				.body("name", equalTo("scott")).body("location", equalTo("india")).body("phone", equalTo("12345"))
				.body("courses[0]", equalTo("python"));

	}

	@Test(priority = 3)
	void testPostUsingPojo() {

		Pojo_PostRequest pojo = new Pojo_PostRequest();

		pojo.setName("karunkar");
		pojo.setLocation("dmm");
		pojo.setPhone("16866767");
		String coursesArr[] = { "aem", "adobe" };
		pojo.setCourese(coursesArr);

		given().contentType("application/json").body(pojo).when().post("url").then().statusCode(200).body("name",
				equalTo("karunakar"));

	}

	@Test(priority = 4)
	void testPostUsingExternalJsonFile() throws FileNotFoundException {

		File f = new File(".//body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo = new JSONObject(jt);

		given().contentType("application/json").body(jo.toString()).when().post("url").then().statusCode(200)
				.body("name", equalTo("name"));

	}

}
