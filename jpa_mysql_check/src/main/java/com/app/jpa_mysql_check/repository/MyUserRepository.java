package com.app.jpa_mysql_check.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.jpa_mysql_check.entity.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Integer>{

}
