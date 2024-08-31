package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetAndPost {
	
	@Test
	public void getTest()
	{
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[0].first_name", equalTo("Michael")).
			body("data.first_name",hasItems("Michael","Lindsay")).
			log().all();
		
	}
	
	@Test
	public void postMethod()
	{
		baseURI="https://reqres.in/api";
		
		JSONObject reqbody = new JSONObject();
		reqbody.put("name", "Akshay");
		reqbody.put("age", "27");
		
		given().
			header("Content-Type","application/json").
			body(reqbody.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}

}
