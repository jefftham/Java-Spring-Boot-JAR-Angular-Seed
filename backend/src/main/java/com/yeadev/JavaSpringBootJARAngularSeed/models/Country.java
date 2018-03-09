package com.yeadev.JavaSpringBootJARAngularSeed.models;

import lombok.Data;

@Data
public class Country {

    long id;
    String countryName;
    
    public Country() {
    	super();
    }
    
    public Country(int i, String countryName) {
        super();
        this.id = i;
        this.countryName = countryName;
    }
  
}
