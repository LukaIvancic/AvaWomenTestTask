package dto.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.annotations.Test;
import util.Utils;

//@JsonInclude(JsonInclude.Include.NON_NULL)
////@JsonPropertyOrder({
////		"username",
////		"firstName",
////		"lastName",
////		"email",
////		"password",
////		"country"
////})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
		private String username;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private String country;






//
//	@JsonProperty("usern_ame")
//	private String username;
//	@JsonProperty("firstName")
//	private String firstName;
//	@JsonProperty("lastName")
//	private String lastName;
//	@JsonProperty("email")
//	private String email;
//	@JsonProperty("password")
//	private String password;
//	@JsonProperty("country")
//	private String country;
//	@JsonIgnore
//	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//	@JsonProperty("username")
//	public String getUsername() {
//		return username;
//	}
//
//	@JsonProperty("username")
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	@JsonProperty("firstName")
//	public String getFirstName() {
//		return firstName;
//	}
//
//	@JsonProperty("firstName")
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	@JsonProperty("lastName")
//	public String getLastName() {
//		return lastName;
//	}
//
//	@JsonProperty("lastName")
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	@JsonProperty("email")
//	public String getEmail() {
//		return email;
//	}
//
//	@JsonProperty("email")
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@JsonProperty("password")
//	public String getPassword() {
//		return password;
//	}
//
//	@JsonProperty("password")
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@JsonProperty("country")
//	public String getCountry() {
//		return country;
//	}
//
//	@JsonProperty("country")
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	@JsonAnyGetter
//	public Map<String, Object> getAdditionalProperties() {
//		return this.additionalProperties;
//	}
//
//	@JsonAnySetter
//	public void setAdditionalProperty(String name, Object value) {
//		this.additionalProperties.put(name, value);
//	}
//
//	public RegisterRequestDTO createRegObj(){
//		RegisterRequestDTO newObj = new RegisterRequestDTO();
//		newObj.setUsername("Juzer");
//		newObj.setFirstName("Pera");
//		newObj.setLastName("Peric");
//		newObj.setEmail(Utils.emailBuilder());
//		newObj.setPassword("Avawomen69!");
//		newObj.setCountry("Switzerland");
//		return newObj;
//
//
//	}
//
//	public static Map<String, String> getRequestBody (){
//
//		Map<String, String> body = new HashMap<>();
//		body.put("username", "Juzer");
//		body.put("firstName", "Pera");
//		body.put("lastName", "Peric");
//		body.put("email", Utils.emailBuilder());
//		body.put("password", "Avawomen69!");
//		body.put("country", "Switzerland");
//		return body;
//
//	}
}