package com.yeadev.JavaSpringBootJARAngularSeed.controllers;

import com.yeadev.JavaSpringBootJARAngularSeed.jdbc.models.Country;
import com.yeadev.JavaSpringBootJARAngularSeed.myBatis.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// ref : https://www.java2blog.com/spring-restful-web-services-json-example/
@RestController
@RequestMapping("/mybatis")
public class MyBatisCountryController {

    CountryMapper repo;

    @Autowired
    public MyBatisCountryController(CountryMapper countryMapper) {        this.repo = countryMapper;    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Country> getCountries() {
        return repo.findAll();
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountryById(@PathVariable long id) {
    	return repo.findById(id);
    }

}
