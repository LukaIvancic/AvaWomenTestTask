import constants.Const;
import constants.Endpoints;
import dto.request.RegisterRequestDTO;
import dto.response.RegisterResponseDTO;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailInboxPage;
import page.GmailLoginPage;
import page.RecoveryPage;
import util.Rest;

import java.sql.Driver;

public class E2ETest {

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

		//pozivacu metode za gmail
		GmailLoginPage gmailLoginPage = new GmailLoginPage();
		gmailLoginPage.provideEmail(Const.NEW_EMAIL);
		gmailLoginPage.clickOnNextButton();
		gmailLoginPage.clickOnNextNextButton();

		RecoveryPage recoveryPage = new RecoveryPage();
		recoveryPage.clickOnConfirmButton();

		GmailInboxPage gmailInboxPage = new GmailInboxPage();
		gmailInboxPage.searchByEmail(Const.NEW_EMAIL);

		//na kraju copy/paste pozitivan test za login






	}

}
