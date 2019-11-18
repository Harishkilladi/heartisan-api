package com.heartisan.infra.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.heartisan.domain.user.entity.User;

public class UserDetailsAdapter implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserDetailsAdapter(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO later use to check with account state either ACTIVE or INACTIVE
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO later use to check if password expiration is implemented
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO later use to check if email or mobile_number not verified 
		return true;
	}
	
	@Override
	public int hashCode() {
		return user.getUsername().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && 
				user.getUsername().equals(((UserDetailsAdapter) obj).getUsername());
	}
	
	@Override
    public String toString() {
        return user.toString();
    }

}
