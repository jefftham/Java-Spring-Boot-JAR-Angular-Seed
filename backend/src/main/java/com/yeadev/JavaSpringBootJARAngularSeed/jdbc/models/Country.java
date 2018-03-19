package com.yeadev.JavaSpringBootJARAngularSeed.jdbc.models;

import lombok.Data;

// acts like entity, but jdbc is using it, so named the package as models to prevent confusion

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
