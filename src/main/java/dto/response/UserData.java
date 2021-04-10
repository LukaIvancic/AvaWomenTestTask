package dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

	String firstName;
	String lastName;
	String country;
	boolean csAccess;
	String email;
	String username;
	ArrayList<String> userPermissions;
}
