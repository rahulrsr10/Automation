package automationdemopack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITesting {

	@Test
	public void testSinglePageResponse() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET);
		JsonPath jsonPathEvaluator = response.jsonPath();
		String page = jsonPathEvaluator.get("data[0].email");
		System.out.println(page);
		ValidationMethods.statusValidation(response.getStatusCode(), 200, response.statusLine().split(" ")[2], "OK");
	}

	@Test
	public void testSingleUser() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET);
		ValidationMethods.statusValidation(response.getStatusCode(), 200, response.statusLine().split(" ")[2], "OK");
	}

	@Test
	public void testSingleUserNotFound() {
		RestAssured.baseURI = "https://reqres.in/api/users/23";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET);
		ValidationMethods.statusValidation(response.getStatusCode(), 404,
				response.statusLine().split(" ")[2] + " " + response.statusLine().split(" ")[3], "Not Found");
	}

	@Test
	public void testCreateUser() throws IOException {
		RestAssured.baseURI = "https://reqres.in/api/users";
		String result;
		result = new String(
				Files.readAllBytes(Paths.get("C:\\Users\\HP\\eclipse-workspace\\AutomationDemo\\file.json")));
		RequestSpecification request = RestAssured.given().body(result);
		request.header("Content-Type", "application/json");
		Response response = request.request(Method.POST);
		ValidationMethods.statusValidation(response.getStatusCode(), 201, response.statusLine().split(" ")[2],
				"Created");
	}
	
}
