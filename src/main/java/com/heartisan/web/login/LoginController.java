package com.heartisan.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.heartisan.web.user.UserController;

@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/login")
	public String login() {
		LOG.debug("requested loggin page..." );
		return "/login";
	}
	
}
