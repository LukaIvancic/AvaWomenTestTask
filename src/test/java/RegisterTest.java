import constants.Const;
import constants.DataProviders;
import constants.Endpoints;
import constants.Fields;
import dto.request.RegisterRequestDTO;
import dto.response.errors.ErrorDTO;
import dto.response.RegisterResponseDTO;
import dto.response.errors.ErrorSimpleDTO;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Rest;

public class RegisterTest {


	@Test
	public void RegisterNewUserTest(){

		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME,
						Const.NEW_EMAIL, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);

		RegisterResponseDTO responseBody = response.getBody().as(RegisterResponseDTO.class);
		Assert.assertEquals(responseBody.getOkMessageType(), Const.OK_MESSAGE_TYPE);
		Assert.assertEquals(responseBody.getTitle(), Const.TITLE);
		Assert.assertEquals(responseBody.getBody(), Const.BODY);


	}




	//Empty field tests

	@Test
	public void RegisterEmptyEmailTest(){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME,
						Const.EMPTY, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.EMPTY_FIELD_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.EMAIL);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), Const.EMPTY);
	}

	@Test
	public void RegisterEmptyUsernameTest(){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.EMPTY, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME, Const.NEW_EMAIL,
						Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL,Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.EMPTY_USERNAME_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.USERNAME);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), Const.EMPTY);



	}

	@Test
	public void RegisterEmptyFirstnameTest(){
		Response response = Rest.post(new RegisterRequestDTO(Const.NEW_USERNAME, Const.EMPTY, Const.NEW_LASTNAME, Const.NEW_EMAIL,
				Const.NEW_PASSWORD, Const.NEW_COUNTRY)
		,Endpoints.BASE_URL,Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.EMPTY_FIELD_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.FIRSTNAME);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), Const.EMPTY);

	}

	@Test
	public void RegisterEmptyLastnameTest(){
		Response response = Rest.post(new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.EMPTY, Const.NEW_EMAIL,
				Const.NEW_PASSWORD, Const.NEW_COUNTRY),Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.EMPTY_LASTNAME_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.LASTNAME);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), Const.EMPTY);

	}

	@Test
	public void RegisterEmptyPasswordTest(){
		Response response = Rest.post(new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME, Const.NEW_EMAIL,
				Const.EMPTY, Const.NEW_COUNTRY), Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.PASSWORD_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.PASSWORD);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), Const.INVALID_PASSWORD);


	}

	@Test
	public void RegisterEmptyCountryTest(){
		Response response = Rest.post(new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME, Const.NEW_EMAIL,
				Const.NEW_PASSWORD, Const.EMPTY), Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR);

		ErrorSimpleDTO error = response.getBody().as(ErrorSimpleDTO.class);
		Assert.assertEquals(error.getErrorMessage(), Const.COUNTRY_FIELD_ERROR);

	}

	//invaid tests

	@Test(dataProvider = "InvalidEmail", dataProviderClass = DataProviders.class)
	public void RegisterInvalidEmailTest(String invalidEmail){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME,
						invalidEmail, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.INVALID_EMAIL_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.EMAIL);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), invalidEmail);

	}

	@Test(dataProvider = "InvalidFirstnameCharacterCount", dataProviderClass = DataProviders.class)
	public void RegisterIncorrectFirstnameCharacterCountTest(String characterCount){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, characterCount, Const.NEW_LASTNAME,
						Const.NEW_EMAIL, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.INVALID_CHARACTER_COUNT_FIRSTNAME_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.FIRSTNAME);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), characterCount);

	}

	@Test(dataProvider = "InvalidFirstname", dataProviderClass = DataProviders.class)
	public void RegisterInvalidFirstnameTest(String invalidFirstname){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, invalidFirstname, Const.NEW_LASTNAME,
						Const.NEW_EMAIL, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.INVALID_FIRSTNAME_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.FIRSTNAME);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), invalidFirstname);

	}

	@Test(dataProvider = "InvalidLastname", dataProviderClass = DataProviders.class)
	public void RegisterInvalidLastnameTest(String invalidLastname){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, invalidLastname,
						Const.NEW_EMAIL, Const.NEW_PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.EMPTY_LASTNAME_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.LASTNAME);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), invalidLastname);

	}

	@Test(dataProvider = "InvalidPassword", dataProviderClass = DataProviders.class)
	public void RegisterInvalidPasswordTest(String invalidPassword){
		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME,
						Const.NEW_EMAIL, invalidPassword, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

		ErrorDTO error = response.getBody().as(ErrorDTO.class);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getErrorMessage(), Const.PASSWORD_ERROR);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getName(), Fields.PASSWORD);
		Assert.assertEquals(error.getErrorFields().get(0).getErrorField().getValue(), Const.INVALID_PASSWORD);

	}



}
