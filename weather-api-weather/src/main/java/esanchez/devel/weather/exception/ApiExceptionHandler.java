package esanchez.devel.weather.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mongodb.MongoException;

import esanchez.devel.weather.common.StandarizedApiExceptionResponse;

/**
 * Class used for control the microservice exceptions
 * 
 * @author Enrique Sanchez Jordan
 *
 */

@RestControllerAdvice
public class ApiExceptionHandler {
	
	/*
	 * Manage all IOExceptions of the microservices with this method
	 */
	@ExceptionHandler(IOException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleNoContentException(Exception e) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Input/Output Error", "error-1001", e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.PARTIAL_CONTENT);
	}
	
	/*
	 * Manage all MongoExceptions of the microservice with this method
	 */
	@ExceptionHandler(MongoException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleMongoException(Exception e) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Database Error", "error-1002", e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * Manage all LocationException of the microservice with this method
	 */
	@ExceptionHandler(WeatherException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleLocationException(WeatherException e) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(e.getError(), e.getCode(), e.getDetail());
		return new ResponseEntity<>(response, e.getStatusCode());
	}
}
