package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class PutPatchDelete {
	
	@Test
	public void putMethod()
	{
		baseURI ="https://reqres.in/api";
		
		JSONObject req = new JSONObject();
		req.put("Akshay", "26");
		
		given().
			header("Content-Type","application/json").
			body(req.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
		
	}

	@Test
	public void patchMethod()
	{
		baseURI ="https://reqres.in/api";
		
		JSONObject req = new JSONObject();
		req.put("Akshay", "25");
		
		given().
			header("Content-Type","application/json").
			body(req.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void deleteMethod()
	{
		baseURI ="https://reqres.in/api";
		given().
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
		
	}
}
