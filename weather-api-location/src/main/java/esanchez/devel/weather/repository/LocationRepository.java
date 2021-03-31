package esanchez.devel.weather.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import esanchez.devel.weather.entity.Location;

public interface LocationRepository extends MongoRepository<Location, String>{

}
