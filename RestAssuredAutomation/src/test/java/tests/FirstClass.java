package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FirstClass {
	
	@Test
	public void basicMethod()
	{
		String url="https://reqres.in/api/users?page=2";
		Response res=RestAssured.get(url);// NON static import and usage
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
	}
	
	@Test
	public void staticImportFuntion()
	{
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200);//status code validation
		
		given().get("/users?page=2").then().body("data[0].first_name", equalTo("Michael"));//validate a node in the json
		
		
	}

}
