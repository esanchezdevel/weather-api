package esanchez.devel.weather.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Jwt {

	@JsonInclude(Include.NON_NULL)
	private String token;
	
	@JsonInclude(Include.NON_DEFAULT)
	private int expirationTime;
	
	@JsonInclude(Include.NON_NULL)
	private String error;

	public Jwt(String token, int expirationTime) {
		super();
		this.token = token;
		this.expirationTime = expirationTime;
	}

	public Jwt(String error) {
		super();
		this.error = error;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(int expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Jwt [" + (token != null ? "token=" + token + ", " : "") + "expirationTime=" + expirationTime + ", "
				+ (error != null ? "error=" + error : "") + "]";
	}
}
