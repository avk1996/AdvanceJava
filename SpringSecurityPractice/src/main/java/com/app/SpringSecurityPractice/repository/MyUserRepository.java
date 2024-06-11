package com.app.SpringSecurityPractice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringSecurityPractice.entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
	Optional<MyUser> findByName(String name);
}
