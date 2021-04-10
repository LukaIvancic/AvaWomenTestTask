import constants.Const;
import constants.DataProviders;
import constants.Endpoints;
import dto.response.LoginResponseDTO;
import dto.response.errors.ErrorSimpleDTO;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HeaderUtil;
import util.Rest;

public class LoginTest {


	@Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
	public void LoginTestPositive(String email, String password){
		Response response = Rest.post
				(HeaderUtil.getLoginHeader(email, password),
						Endpoints.BASE_URL,
						Endpoints.LOGIN);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

		LoginResponseDTO responseBody = response.getBody().as(LoginResponseDTO.class);
		Assert.assertEquals(responseBody.getUserData().getEmail(), Const.EMAIL);
		Assert.assertEquals(responseBody.getUserData().getFirstName(), Const.FIRSTNAME1);
		Assert.assertEquals(responseBody.getUserData().getLastName(), Const.LASTNAME);
		Assert.assertEquals(responseBody.getUserData().getUsername(), Const.USERNAME);

	}

	@Test(dataProvider = "LoginNegative", dataProviderClass = DataProviders.class)
	public void LoginTestNegative(String email, String password){

		Response response = Rest.post
				(HeaderUtil.getLoginHeader(email, password),
						Endpoints.BASE_URL,
						Endpoints.LOGIN);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
		ErrorSimpleDTO error = response.getBody().as(ErrorSimpleDTO.class);
		Assert.assertEquals(error.getErrorMessage(), Const.LOGIN_ERROR); //procitao sam body responsea i izmapirao ga

	}
}
