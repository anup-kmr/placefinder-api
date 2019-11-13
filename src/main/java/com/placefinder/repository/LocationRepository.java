package com.placefinder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.placefinder.model.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, String>{

	Location findByPlace(String location);

}
