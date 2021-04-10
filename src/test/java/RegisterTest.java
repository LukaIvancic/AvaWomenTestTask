import constants.Const;
import constants.Endpoints;
import dto.request.RegisterRequestDTO;
import dto.response.errors.ErrorDTO;
import dto.response.RegisterResponseDTO;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Rest;

import static io.restassured.RestAssured.given;

public class RegisterTest {


	@Test
	public void RegisterNewUserTest(){

		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME,
						Const.NEW_EMAIL, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);

		RegisterResponseDTO responseBody = response.getBody().as(RegisterResponseDTO.class); //response isparsiram u objekat sa tim vrednostima
		Assert.assertEquals(responseBody.getOkMessageType(), Const.OK_MESSAGE_TYPE);
		Assert.assertEquals(responseBody.getTitle(), Const.TITLE);
		Assert.assertEquals(responseBody.getBody(), Const.BODY);


	}

	@Test
	public void RegisterAlreadyRegisteredUser(){

		 final String CURRENT_USERNAME = Const.NEW_USERNAME;
		 final String CURRENT_FIRSTNAME = Const.NEW_FIRSTNAME;
		 final String CURRENT_LASTNAME = Const.NEW_LASTNAME;
		 final String CURRENT_EMAIL = Const.NEW_EMAIL;
		 final String CURRENT_PASSWORD = Const.NEW_PASSWORD;
		 final String CURRENT_COUNTRY = Const.NEW_COUNTRY;

//		Response response1 = Rest.post(
//				new RegisterRequestDTO(CURRENT_USERNAME, CURRENT_FIRSTNAME, CURRENT_LASTNAME,
//						CURRENT_EMAIL, CURRENT_PASSWORD, CURRENT_COUNTRY),
//				Endpoints.BASE_URL, Endpoints.REGISTER);
//
//		Assert.assertEquals(response1.getStatusCode(), HttpStatus.SC_CREATED);

//		Response response2 = Rest.post(
//				new RegisterRequestDTO(CURRENT_USERNAME, CURRENT_FIRSTNAME, CURRENT_LASTNAME,
//						CURRENT_EMAIL, CURRENT_PASSWORD, CURRENT_COUNTRY),
//				Endpoints.BASE_URL, Endpoints.REGISTER);

		Response response2 = Rest.post(
				new RegisterRequestDTO("Juzer_YlfB", "PeravDtc", "PericzVqh",
						"humantesting69+CABcjWVtgmail.com", "Avawomen69!", "Switzerland"),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response2.getStatusCode(), HttpStatus.SC_BAD_REQUEST);





	}
//
//	@Test
//	public void oneMoreTest(){
//		String URI = Endpoints.BASE_URL;
//		RequestSpecBuilder builder = new RequestSpecBuilder();
//		builder.setBody(RegisterRequestDTO.getRequestBody());
//		RequestSpecification requestSpec = builder.build();
//		Response response = given().spec(requestSpec).when().post(URI);
//
//
//
//	}


	@Test
	public void RegisterEmptyEmailTest(){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME,
						Const.EMPTY, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.EMPTY_FIELD_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), "email"); //napravi const sa imenom polja
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), Const.EMPTY); //prosledjen value polja
	}




}
