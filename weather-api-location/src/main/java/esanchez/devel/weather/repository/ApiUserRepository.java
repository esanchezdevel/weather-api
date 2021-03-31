package esanchez.devel.weather.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import esanchez.devel.weather.entity.ApiUser;

public interface ApiUserRepository extends MongoRepository<ApiUser, String>{

	Optional<ApiUser> findByName(String name);
}
