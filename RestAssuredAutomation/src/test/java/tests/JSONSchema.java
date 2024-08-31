package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class JSONSchema {
	
	@Test
	public void schemaValidator()
	{
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schemaTest.json"))
			.statusCode(200);
			
	}

}
