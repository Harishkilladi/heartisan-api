package com.heartisan.web.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
    @GetMapping(value = {"/", "/home"})
    public String home() {
    	LOG.debug("requested home page..." );
        return "/home";
    }
}
