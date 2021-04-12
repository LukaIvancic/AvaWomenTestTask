package util;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {


	public static String TESTING_EMAIL = "humantesting69";
	public static String TESTING_EMAIL_DOMAIN = "@gmail.com";

	public static String emailBuilder(){

		String generatedstring= RandomStringUtils.randomAlphabetic(8);

		return TESTING_EMAIL + "+" + generatedstring + TESTING_EMAIL_DOMAIN;
	}
}
