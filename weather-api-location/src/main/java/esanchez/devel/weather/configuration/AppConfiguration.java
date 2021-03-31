package esanchez.devel.weather.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfiguration {

	private String jwtId;
	private String jwtIssuer;
	private String jwtTimeToLive;
	private String jwtSecretKey;

	public String getJwtId() {
		return jwtId;
	}

	public void setJwtId(String jwtId) {
		this.jwtId = jwtId;
	}

	public String getJwtIssuer() {
		return jwtIssuer;
	}

	public void setJwtIssuer(String jwtIssuer) {
		this.jwtIssuer = jwtIssuer;
	}

	public String getJwtTimeToLive() {
		return jwtTimeToLive;
	}

	public void setJwtTimeToLive(String jwtTimeToLive) {
		this.jwtTimeToLive = jwtTimeToLive;
	}

	public String getJwtSecretKey() {
		return jwtSecretKey;
	}

	public void setJwtSecretKey(String jwtSecretKey) {
		this.jwtSecretKey = jwtSecretKey;
	}
}
