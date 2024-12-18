package RA_Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DummyApiTests {
    
    @BeforeClass
    public void setup() {
        // Disable SSL certificate validation
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void getAllEmployees() throws InterruptedException {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        
        RequestSpecification request = given()
            .header("Accept", "application/json")
            .header("Accept-Encoding", "gzip, deflate, br, zstd")
            .header("Accept-Language", "en-US,en;q=0.9")
            .header("Cache-Control", "max-age=0")
            .header("Cookie", "humans_21909=1; XSRF-TOKEN=<your-token>; laravel_session=<your-session>")
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
            .header("Referer", "https://dummy.restapiexample.com/");

        Response response = request.get("/employees");
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);

        Thread.sleep(60000); // Wait for 1 minute
    }

    @Test
    public void getEmployeeById() throws InterruptedException {
        int employeeId = 1;

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        Response response = given()
            .header("Accept", "application/json")
            .header("Accept-Encoding", "gzip, deflate, br, zstd")
            .header("Accept-Language", "en-US,en;q=0.9")
            .header("Cache-Control", "max-age=0")
            .header("Cookie", "humans_21909=1; XSRF-TOKEN=<your-token>; laravel_session=<your-session>")
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
            .header("Referer", "https://dummy.restapiexample.com/")
            .get("/employee/" + employeeId);

        System.out.println("Response Body: " + response.getBody().asString());
        response.then().statusCode(200).body("data.id", equalTo(employeeId));

        Thread.sleep(60000); // Wait for 1 minute
    }

    @Test
    public void updateEmployee() throws InterruptedException {
        int employeeId = 1;
        String updatedName = "Updated Name";

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        Response response = given()
            .header("Accept", "application/json")
            .header("Accept-Encoding", "gzip, deflate, br, zstd")
            .header("Accept-Language", "en-US,en;q=0.9")
            .header("Cache-Control", "max-age=0")
            .header("Cookie", "humans_21909=1; XSRF-TOKEN=<your-token>; laravel_session=<your-session>")
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
            .header("Referer", "https://dummy.restapiexample.com/")
            .body("{ \"name\": \"" + updatedName + "\", \"salary\": \"123456\", \"age\": \"30\" }")
            .put("/update/" + employeeId);

        System.out.println("Response Body: " + response.getBody().asString());
        response.then().statusCode(200).body("status", equalTo("success"));

        Thread.sleep(60000); // Wait for 1 minute
    }

    @Test
    public void deleteEmployee() throws InterruptedException {
        int employeeId = 1;

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        Response response = given()
            .header("Accept", "application/json")
            .header("Accept-Encoding", "gzip, deflate, br, zstd")
            .header("Accept-Language", "en-US,en;q=0.9")
            .header("Cache-Control", "max-age=0")
            .header("Cookie", "humans_21909=1; XSRF-TOKEN=<your-token>; laravel_session=<your-session>")
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
            .header("Referer", "https://dummy.restapiexample.com/")
            .delete("/delete/" + employeeId);

        System.out.println("Response Body: " + response.getBody().asString());
        response.then().statusCode(200);

        Thread.sleep(60000); // Wait for 1 minute
    }
}