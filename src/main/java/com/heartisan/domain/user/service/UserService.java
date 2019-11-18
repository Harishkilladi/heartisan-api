package com.heartisan.domain.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heartisan.domain.user.entity.RegistrationBean;
import com.heartisan.domain.user.entity.User;
import com.heartisan.domain.user.exception.UserNotFoundException;
import com.heartisan.domain.user.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor(onConstructor_= {@Autowired})
public class UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	@NonNull private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(Long userId) throws UserNotFoundException {
		LOG.debug("finding uder by id: {}", userId);
		return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
	}

	public User createUser(RegistrationBean regisrationBean) {
		LOG.debug("creating user...");
		User user = new User();
		user.setUsername(regisrationBean.getUsername());
		user.setFirstName(regisrationBean.getFirstName());
		user.setLastName(regisrationBean.getLastName());
		user.setMobileNumber(regisrationBean.getMobileNumber());
		user.setPassword(regisrationBean.getPassword());
		user.setCreatedBy("admin");
		user.setLastModifiedBy("admin");
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}
