package esanchez.devel.weather.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import esanchez.devel.weather.entity.Weather;

public interface WeatherRepository extends MongoRepository<Weather, String>{

}
