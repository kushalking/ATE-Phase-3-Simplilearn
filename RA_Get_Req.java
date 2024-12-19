package Requests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RA_Get_Req {
	private static final Logger logger = LogManager.getLogger(RA_Get_Req.class);
	
	public static void main(String[] args) {
		String URL = "https://reqres.in/api";
		RestAssured.baseURI = URL;
		logger.info("Creating request specification");
		RequestSpecification specification = RestAssured.given();
		logger.info("Sending GET request to retrieve users (page 2)");
		Response response = specification.when().get("/users?page=2");
		logger.info("Received response with status code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());
	}
}
