package com.placefinder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "location")
public class Location {

	@Id
    private String id;
    private String place;
}
