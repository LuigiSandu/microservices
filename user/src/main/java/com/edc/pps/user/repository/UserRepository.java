package com.edc.pps.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edc.pps.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
