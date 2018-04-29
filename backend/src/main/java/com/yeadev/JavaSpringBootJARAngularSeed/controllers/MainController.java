package com.yeadev.JavaSpringBootJARAngularSeed.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    // sample code: return string value through http request/respond
    // @ResponseBody forces it to return string instead of view
    @RequestMapping("/returnString")
    @ResponseBody
    public String returnString() {
        return "Greetings from Spring Boot!";
    }

    // ref : https://www.java2blog.com/spring-restful-web-services-json-example/
    // if headers = "Accept=application/json", jackson will map it
    @RequestMapping(value = "/returnJson", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<String> returnJson1() {
        List<String> listOfCountries;
        listOfCountries = Arrays.asList("US", "UK");
        return listOfCountries;
    }

    // duplicate to test spring security
    @RequestMapping(value = "/protected/returnJson", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<String> returnJson1Protected() {
        List<String> listOfCountries;
        listOfCountries = Arrays.asList("US", "UK");
        return listOfCountries;
    }

}
