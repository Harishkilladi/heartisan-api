package com.heartisan.domain.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heartisan.domain.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findUserByUsername(String username);
}
