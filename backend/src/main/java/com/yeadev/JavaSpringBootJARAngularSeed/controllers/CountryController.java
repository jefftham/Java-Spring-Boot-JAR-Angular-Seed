package com.yeadev.JavaSpringBootJARAngularSeed.controllers;

import com.yeadev.JavaSpringBootJARAngularSeed.databaseService.CountryService;
import com.yeadev.JavaSpringBootJARAngularSeed.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


// ref : https://www.java2blog.com/spring-restful-web-services-json-example/
@RestController
@RequestMapping("/test")
public class CountryController {

	CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Country> getCountries() {
        List<Country> listOfCountries;
       // listOfCountries = createCountryList();
        listOfCountries = countryService.findAll();
        return listOfCountries;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountryById(@PathVariable long id) {
    	return countryService.findById(id);
    	
    	/*
        List<Country> listOfCountries = new ArrayList<>();
        listOfCountries = createCountryList();

        for (Country country : listOfCountries) {
            if (country.getId() == id) {
                return country;
            }
        }

        return null;
        
        */
    }

// Utiliy method to create country list.
    public List<Country> createCountryList() {
        Country indiaCountry = new Country(1, "India");
        Country chinaCountry = new Country(4, "China");
        Country nepalCountry = new Country(3, "Nepal");
        Country bhutanCountry = new Country(2, "Bhutan");

        List <Country> listOfCountries = new ArrayList<>();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(chinaCountry);
        listOfCountries.add(nepalCountry);
        listOfCountries.add(bhutanCountry);
        return listOfCountries;
    }
}
