package Day2;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ResponseValidation {
	
	public static void main(String[] args) {

        // Base URI for RestAssured
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Get the response from the API
        Response response = RestAssured.get("/posts/1");

        // Validate the status code
        int statusCode = response.getStatusCode();
        if (statusCode != 200) {
            throw new AssertionError("Expected status code 200 but got " + statusCode);
        }

        // Validate the userId
        int userId = response.jsonPath().getInt("userId");
        if (userId != 1) {
            throw new AssertionError("Expected userId 1 but got " + userId);
        }
        
        //If userId contains String
        String userId1 = response.jsonPath().getString("userId");
        if (userId1 !="123") {
            throw new AssertionError("Expected userId 1 but got " + userId);
        }
        
//        String userId2 = response.jsonPath().getString("userId");
//        if (Assert.assertEquals("userId2", "123")) {
//            throw new AssertionError("Expected userId 1 but got " + userId);
//        }

        // Print success message
        System.out.println("Test passed with userId: " + userId + " and status code: " + statusCode);
    }

}
