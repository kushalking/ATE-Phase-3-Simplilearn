package Requests;
import org.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class RA_Post_Req {
	private static final Logger logger = LogManager.getLogger(RA_Post_Req.class);
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		logger.info("Setting up user object with name: {} and role: {}", "Isabella", "SDE");
		JSONObject userObject = setJsonObject("Isabella", "SDE");
		logger.info("Sending POST request to create user");
		Response response = RestAssured
				.given()
				.body(userObject.toString())
				.contentType("application/json")
				.when()
				.post("/api/users");
		 logger.info("Printing response status code: {}", response.getStatusCode());
	     logger.info("Printing response body: {}", response.getBody().asString());
	}
	public static JSONObject setJsonObject(String name, String role) {
		JSONObject userjson = new JSONObject();
		userjson.put("name", name);
		userjson.put("job", role);
		return userjson;
	}
}
