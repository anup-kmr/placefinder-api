package com.placefinder.service;

import java.util.List;

import com.placefinder.model.Location;

public interface LocationService {

	List<Location> findAll();

	Location save(String location);

}
