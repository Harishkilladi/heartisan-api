package com.heartisan.infra.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.heartisan.domain.user.entity.User;
import com.heartisan.domain.user.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor(onConstructor_= {@Autowired})
public class ApiUserDetailsService implements UserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(ApiUserDetailsService.class);
	@NonNull private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOG.debug("finding user by username: {}", username);
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			
		} else {
			throw new UsernameNotFoundException(username);
		}
		UserDetails userDetails = new UserDetailsAdapter(user.get());
		return userDetails;
	}

}
