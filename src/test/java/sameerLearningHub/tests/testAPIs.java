package sameerLearningHub.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class testAPIs {
	
	@Test
	public void getAccessToken() {
		String endpoint = "https://api.stage.canoesoftware.com/v1/tokens";
		String response = given().body().when.post(endpoint).then();
	}

}
