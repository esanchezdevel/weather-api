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

import esanchez.devel.weather.entity.Location;
import esanchez.devel.weather.exception.LocationException;
import esanchez.devel.weather.repository.LocationRepository;

/**
 * Location Controller where we can control all 
 * the actions related with a Location
 * 
 * @author Enrique Sanchez Jordan
 *
 */

@RestController
@RequestMapping("/weather/location")
public class LocationRestController {
	
	public static final String SUCCESS_RESPONSE = "{\"status\" : \"ok\"}";
	
	@Autowired
	private LocationRepository locationRepository;

	@GetMapping()
	public List<Location> list() {
		/*
		 * List all the locations
		 */
		return locationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Location get(@PathVariable String id) {
		/*
		 * find location by id
		 */
		Optional<Location> location = locationRepository.findById(id);
		if (location.isPresent())
			return location.get();
		else
			return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put (@PathVariable String id, @RequestBody Location input) throws LocationException {
		/*
		 * update one location
		 */
		Optional<Location> location = locationRepository.findById(id);
		
		if (location.isPresent()) {
			Location locationDocument = location.get();
			locationDocument.setName(input.getName());
			locationDocument.setCountry(input.getCountry());
			locationDocument.setLatitude(input.getLatitude());
			locationDocument.setLongitude(input.getLongitude());
			
			locationRepository.save(locationDocument);
		} else {
			throw new LocationException("not found", "error-1003", "location not found", HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(SUCCESS_RESPONSE);
	}
	
	@PostMapping()
	public ResponseEntity<?> post(@RequestBody Location input) {
		/*
		 * create new location
		 */
		locationRepository.save(input);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		/*
		 * remove one location
		 */
		locationRepository.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
