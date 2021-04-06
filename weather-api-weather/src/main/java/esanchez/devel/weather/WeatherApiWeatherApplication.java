package esanchez.devel.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class that start the service
 * 
 * @author Enrique Sanchez Jordan
 *
 */

@SpringBootApplication
@EnableSwagger2
public class WeatherApiWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiWeatherApplication.class, args);
	}

	/*
	 * configure swagger for read available functionalities from our project package
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("esanchez.devel.weather")).build();
	}
}
