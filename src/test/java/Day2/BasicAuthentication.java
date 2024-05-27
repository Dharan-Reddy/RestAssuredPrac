package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BasicAuthentication {

	void basicAuthentication() {
		given().auth().basic("username", "password").get("https://api.example.com/resource");
//		
//		How do you handle authentication with RestAssured when dealing with OAuth or OAuth2?
//
//				RestAssured provides built-in support for OAuth and OAuth2 authentication.
//		You can use the auth() method with oauth() or oauth2() to configure OAuth or OAuth2
//		authentication respectively.
		given().auth().oauth2("access_token").get("https://api.example.com/resource");


	}

}
