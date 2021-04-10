package constants;

import org.apache.commons.lang3.RandomStringUtils;
import util.Utils;

public class Const { //sve sto nemam gde, greske itd, username odgovore n stuff

	public static final String UNSUPPORTED_ERROR_MSG = ""; //dodaj error posle ( i slicne stvari)
	public static final String PHONE_TYPE = "ANDROID";

	//ovo cu negde drugde da metnem posle

	public static final String EMAIL = "humantesting69@gmail.com";
	public static final String LOGIN_PASSWORD1 = "Avawomen69!";

	public static final String FIRSTNAME1 = "Wo";
	public static final String LASTNAME = "Man";
	public static final String USERNAME = "Women";

	public static final String OK_MESSAGE_TYPE = "TYPE_AAA";
	public static final String TITLE = "Your account was created successfully.";
	public static final String BODY = "Please check your email to activate your Ava account.";



			public static final String NEW_USERNAME = "Juzer_" + RandomStringUtils.randomAlphabetic(4);
			public static final String NEW_FIRSTNAME = "Pera" + RandomStringUtils.randomAlphabetic(4);
			public static final String NEW_LASTNAME = "Peric" + RandomStringUtils.randomAlphabetic(4);
			public static final String NEW_EMAIL = Utils.emailBuilder();
			public static final String NEW_PASSWORD = "Avawomen69!";
			public static final String  NEW_COUNTRY= "Switzerland";



			public static final String EMPTY = "";

	//Errors
	public static final String LOGIN_ERROR = "Your username/email or password is\n"
			+ "incorrect. Please check and try again.";
	public static final String EMPTY_FIELD_ERROR = "Field can't be empty.";

}
