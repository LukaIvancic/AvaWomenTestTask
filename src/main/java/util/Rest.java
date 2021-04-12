package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class Rest {

	public static <T> Response post( T body, String baseURI, String endpoint){

		return RestAssured.given()
				.baseUri(baseURI)
				.body(body)
				.contentType("application/json")
				.log()
				.all()
				.when()
				.post(endpoint);

	}

	public static Response post(Map<String, String> header, String baseURI, String endpoint){

		return RestAssured.given()
				.baseUri(baseURI)
				.headers(header)
				.contentType("application/json")
				.log()
				.all()
				.when()
				.post(endpoint);

	}


}
