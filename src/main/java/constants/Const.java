package constants;

import org.apache.commons.lang3.RandomStringUtils;
import util.Utils;

public class Const {

	public static final String GMAIL_EMAIL = "humantesting69";
	public static final String GMAIL_PASSWORD = "Humanity2019";

	public static final String PHONE_TYPE = "ANDROID";


	public static final String EMAIL = "humantesting69@gmail.com";

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
	public static final String NEW_COUNTRY = "Switzerland";

	public static final String EMPTY = "";
	public static final String INVALID_PASSWORD = null;

	//Errors

	public static final String LOGIN_ERROR = "Your email or password is incorrect. Please check and try again.";
	public static final String EMPTY_FIELD_ERROR = "Field can't be empty.";
	public static final String EMPTY_USERNAME_ERROR = "Allowed capital letters, small letters, separators(dot, underscore, dash)";
	public static final String EMPTY_LASTNAME_ERROR = "Please use letters, space, dot, apostrophe and/or dash. Should not begin or end with a blank space.";
	public static final String PASSWORD_ERROR = "(Minimum 10 characters with upper & lower-case letters, numbers and symbols. Should not begin or end with a blank space)";
	public static final String COUNTRY_FIELD_ERROR = "Selected country isn't supported yet.";

	public static final String INVALID_EMAIL_ERROR = "Email address is invalid.";
	public static final String INVALID_CHARACTER_COUNT_FIRSTNAME_ERROR = "Value must be between 2 and 60 characters long.";
	public static final String INVALID_FIRSTNAME_ERROR = "Please use letters, space, dot, apostrophe and/or dash. Should not begin or end with a blank space.";

	//Gmail setup
	public static final String EMAIL_SUBJECT = "Just one more tap to get started with Ava";
	public static final String VERIFICATION_CONFIRMATION = "Your account has been verified!";

	public static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	public static final String PORT ="995";
	public static final String PROTOCOL ="pop3";
	public static final String HOST ="pop.gmail.com";
	public static final String MAIL_PORT="mail.pop3.port";
	public static final String SOCKET_FACTORY_PORT = "mail.pop3.socketFactory.port";
	public static final String SOCKET_FACTORY_FALLBACK = "mail.pop3.socketFactory.port";
	public static final String SOCKET_FACTORY_CLASS = "mail.pop3.socketFactory.class";

}
