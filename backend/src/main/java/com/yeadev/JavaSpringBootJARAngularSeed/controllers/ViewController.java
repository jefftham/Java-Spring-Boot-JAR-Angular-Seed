package com.yeadev.JavaSpringBootJARAngularSeed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jsp")
public class ViewController {
	
	// return ModelAndView for view
    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
    
 // return string for view
    @RequestMapping(value = "/welcome")
    public String index(Model model){
        return "welcome";
    }

}