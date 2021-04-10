package util;

import constants.Const;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {

	public static Map<String, String> getLoginHeader (String authUsername, String authPassword){

		Map<String, String> header = new HashMap<>();
		header.put("X-Auth-Username", authUsername);
		header.put("X-Auth-Password", authPassword);
		header.put("Push-Token", "null");
		header.put("Phone-Type", Const.PHONE_TYPE);
		return header;

	}


}
