package esanchez.devel.weather.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * Class used for standarize the error responses of the microservice
 * 
 * @author Enrique Sanchez Jordan
 *
 */

public class StandarizedApiExceptionResponse {

	@ApiModelProperty(notes = "A brief human-readable message about the error", name = "error", required = true, example = "The user does not have authorization")
	private String error;

	@ApiModelProperty(notes = "The unique errorCode", name = "code", required = true, example = "192")
	private String code;

	@ApiModelProperty(notes = "A human-readable explanation of the error", name = "detail", required = true, example = "The user does not have the propertly permissions to access the resource")
	private String detail;

	public StandarizedApiExceptionResponse(String error, String code, String detail) {
		super();
		this.error = error;
		this.code = code;
		this.detail = detail;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
