package com.heartisan.web.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heartisan.domain.user.entity.RegistrationBean;
import com.heartisan.domain.user.entity.User;
import com.heartisan.domain.user.exception.UserNotFoundException;
import com.heartisan.domain.user.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Controller
@RequestMapping("/users")
@AllArgsConstructor(onConstructor_= {@Autowired})
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@NonNull private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(name = "id") Long userId) {
		LOG.debug("get details of user: {}", userId);
		try {
			return ResponseEntity.ok(userService.getUserById(userId));
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody RegistrationBean userBean) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userBean));
	}
}
