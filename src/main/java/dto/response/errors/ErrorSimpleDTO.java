package dto.response.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorSimpleDTO {

	private String errorMessageType;
	private String errorMessage;



}
