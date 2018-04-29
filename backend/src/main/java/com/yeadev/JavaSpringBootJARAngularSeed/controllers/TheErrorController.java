package com.yeadev.JavaSpringBootJARAngularSeed.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

// alternative way to map error code.
// prefer to map unknown path to front-end.

//@Controller
public class TheErrorController implements ErrorController {
 

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String  renderErrorPage() {
         return "welcome";
    }

	@Override
	public String getErrorPath() {
		return "welcome";
	}
     
     
}