package esanchez.devel.weather.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esanchez.devel.weather.entity.Weather;
import esanchez.devel.weather.exception.WeatherException;
import esanchez.devel.weather.repository.WeatherRepository;

/**
 * Weather Controller where we can control all 
 * the actions related with the weather data of one
 * specific location
 * 
 * @author Enrique Sanchez Jordan
 *
 */

@RestController
@RequestMapping("/weather/location")
public class WeatherRestController {
	
	public static final String SUCCESS_RESPONSE = "{\"status\" : \"ok\"}";
	
	@Autowired
	private WeatherRepository weatherRepository;

	@GetMapping()
	public List<Weather> list() {
		/*
		 * List all the locations
		 */
		return weatherRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Weather get(@PathVariable String id) {
		/*
		 * find location by id
		 */
		Optional<Weather> location = weatherRepository.findById(id);
		if (location.isPresent())
			return location.get();
		else
			return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put (@PathVariable String id, @RequestBody Weather input) throws WeatherException {
		/*
		 * update one location
		 */
		//TODO implement
		
		return ResponseEntity.ok(SUCCESS_RESPONSE);
	}
	
	@PostMapping()
	public ResponseEntity<?> post(@RequestBody Weather input) {
		/*
		 * create new location
		 */
		weatherRepository.save(input);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		/*
		 * remove one location
		 */
		weatherRepository.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
