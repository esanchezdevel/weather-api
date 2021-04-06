package esanchez.devel.weather.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import esanchez.devel.weather.configuration.AppConfiguration;
import esanchez.devel.weather.configuration.Credentials;
import esanchez.devel.weather.configuration.Jwt;
import esanchez.devel.weather.configuration.JwtService;
import esanchez.devel.weather.configuration.JwtToken;
import esanchez.devel.weather.cryptography.Cryptography;
import esanchez.devel.weather.entity.ApiUser;
import esanchez.devel.weather.repository.ApiUserRepository;

@Component
public class AuthenticationModel {
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private ApiUserRepository apiUserRepository;

	@Autowired
	private AppConfiguration configuration;

	public Jwt execute(Credentials credentials) {
		
		if (validCredentials(credentials)) {

			JwtToken jwtToken = new JwtToken();
			jwtToken.setId(configuration.getJwtId());
			jwtToken.setIssuer(configuration.getJwtIssuer());
			jwtToken.setSubject(credentials.getUsername());
			jwtToken.setTimeToLive(Integer.parseInt(configuration.getJwtTimeToLive()));

			String jwt = jwtService.createJWT(jwtToken, credentials);

			return new Jwt(jwt, Integer.parseInt(configuration.getJwtTimeToLive()));
		}

		return new Jwt("Error Invalid Credentials");
	}

	private boolean validCredentials(Credentials credentials) {

		boolean valid = false;

		Optional<ApiUser> apiUser = apiUserRepository.findByName(credentials.getUsername());

		if (apiUser.isPresent()) {
			if (Cryptography.checkPassword(credentials.getPassword(), apiUser.get().getPassword())) {
				valid = true;
			}
		}
		return valid;
	}
}
