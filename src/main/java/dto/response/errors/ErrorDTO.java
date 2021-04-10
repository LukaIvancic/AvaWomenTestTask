package dto.response.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

	private String errorMessageType;
	private List<ErrorFieldsItem> errorFields;

}