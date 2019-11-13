package com.placefinder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.placefinder.model.Location;
import com.placefinder.model.Response;
import com.placefinder.service.LocationService;
import com.placefinder.utils.LocationException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("place")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping("")
	public ResponseEntity<Response> locations() {
		List<Location> location = new ArrayList<>();
		try {
			location = locationService.findAll();
		} catch (LocationException e) {
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(location.isEmpty()) {
			return new ResponseEntity<>(
					new Response(HttpStatus.NO_CONTENT.value(), "Locations not found", location, 0),
					HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<>(
				new Response(HttpStatus.OK.value(), "Locations fetched successfully.", location, location.size()),
				HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Response> save(@RequestParam String location) {
		Location save = new Location();
		try {
			save = locationService.save(location);
		} catch (LocationException e) {
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), save, 0),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new Response(HttpStatus.CREATED.value(), "Location saved successfully", save, 0),HttpStatus.CREATED);
	}
	
}
