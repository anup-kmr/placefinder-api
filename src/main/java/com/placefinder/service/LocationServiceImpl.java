package com.placefinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.placefinder.model.Location;
import com.placefinder.repository.LocationRepository;
import com.placefinder.utils.LocationException;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		List<Location> locations = null;
		try {
			locations = locationRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new LocationException("There is some network error. Please try again.");
		}
		
		return locations;
	}

	@Override
	public Location save(String location) {
		if (StringUtils.isEmpty(location)) {
			throw new LocationException("Location cannot be empty.");
		}
		Location place = locationRepository.findByPlace(location);
		if(ObjectUtils.isEmpty(place)) {
			Location entity = new Location();
			entity.setPlace(location);
			try {
				Location savedLocation = locationRepository.save(entity);
				return savedLocation;	
			} catch (Exception e) {
				e.printStackTrace();
				throw new LocationException("Unable to save location. Please try again.");
			}
		}
		else {
			throw new LocationException(location+" already exists.");
		}
		

	}

}
