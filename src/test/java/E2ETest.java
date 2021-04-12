import constants.Const;
import constants.Endpoints;
import dto.request.RegisterRequestDTO;
import dto.response.LoginResponseDTO;
import dto.response.RegisterResponseDTO;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MailPage;
import util.HeaderUtil;
import util.MailServiceUtil;
import util.Rest;

public class E2ETest {

	private MailServiceUtil mailServiceUtil;
	private MailPage mailPage;

	@Test
	public void RegisterActivateLoginTest() throws Exception {

		final String EMAIL = Const.NEW_EMAIL;
		final String PASSWORD = Const.NEW_PASSWORD;

		Response response = Rest.post(
				new RegisterRequestDTO(Const.NEW_USERNAME, Const.NEW_FIRSTNAME, Const.NEW_LASTNAME,
						EMAIL, PASSWORD, Const.NEW_COUNTRY),
				Endpoints.BASE_URL, Endpoints.REGISTER);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);

		RegisterResponseDTO responseBody = response.getBody().as(RegisterResponseDTO.class); //response isparsiram u objekat sa tim vrednostima
		Assert.assertEquals(responseBody.getOkMessageType(), Const.OK_MESSAGE_TYPE);
		Assert.assertEquals(responseBody.getTitle(), Const.TITLE);
		Assert.assertEquals(responseBody.getBody(), Const.BODY);

		mailServiceUtil = new MailServiceUtil();
		mailServiceUtil.setUserCredentials(Const.GMAIL_EMAIL, Const.GMAIL_PASSWORD);
		mailServiceUtil.connect();
		String validationLink = mailServiceUtil.getLinkFromEmail(Const.EMAIL_SUBJECT, EMAIL);

		mailPage = new MailPage();

		mailPage.goToUrl(validationLink);
		Assert.assertEquals(mailPage.getText(), Const.VERIFICATION_CONFIRMATION);

		Response response2 = Rest.post
				(HeaderUtil.getLoginHeader(EMAIL, PASSWORD),
						Endpoints.BASE_URL,
						Endpoints.LOGIN);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

		LoginResponseDTO responseBody2 = response2.getBody().as(LoginResponseDTO.class);
		Assert.assertEquals(responseBody2.getUserData().getEmail(), Const.EMAIL);
		Assert.assertEquals(responseBody2.getUserData().getFirstName(), Const.FIRSTNAME1);
		Assert.assertEquals(responseBody2.getUserData().getLastName(), Const.LASTNAME);
		Assert.assertEquals(responseBody2.getUserData().getUsername(), Const.USERNAME);

	}

}
