package esanchez.devel.weather.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom Exception for manage microservice errors
 * 
 * @author Enrique Sanchez Jordan
 *
 */
public class WeatherException extends Exception {

	private static final long serialVersionUID = -1406663132520712391L;
	
	private String error;
	private String detail;
	private String code;
	private HttpStatus statusCode;

	public WeatherException(String error, String code, String detail, HttpStatus statusCode) {
		this.error = error;
		this.code = code;
		this.detail = detail;
		this.statusCode = statusCode;
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

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
}