package util;

import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class Rest { //cupamo metode koje cu koristiti

	public static <T> Response post( T body, String baseURI, String endpoint){

		return RestAssured.given()
				.baseUri(baseURI)
				.body(body)
				.contentType("application/json")
				.log()
				.all()//kao builder, puni obj koji je napravio nekim propertijima koji su bitni za request(u sebi ima i http klijenta i sve sto mu trebad a posalje request)
				.when()
				.post(endpoint);

	}

	public static Response post(Map<String, String> header, String baseURI, String endpoint){

		return RestAssured.given()
				.baseUri(baseURI)
				.headers(header)
				.contentType("application/json")
				.log()
				.all()//kao builder, puni obj koji je napravio nekim propertijima koji su bitni za request(u sebi ima i http klijenta i sve sto mu trebad a posalje request)
				.when()
				.post(endpoint);

	}


}
