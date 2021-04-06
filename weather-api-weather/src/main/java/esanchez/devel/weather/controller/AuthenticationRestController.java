package esanchez.devel.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esanchez.devel.weather.configuration.Credentials;
import esanchez.devel.weather.configuration.Jwt;
import esanchez.devel.weather.model.AuthenticationModel;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationRestController {

	
	@Autowired
	private AuthenticationModel model;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody Credentials credentials) {
				
		Jwt jwt = model.execute(credentials);
		
		if (jwt.getError() == null) {
			return ResponseEntity.ok(jwt);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(jwt);
		}
	}

}
