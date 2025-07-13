package com.shahinkhalajestani.reservations.dao;

import java.util.Optional;

import com.shahinkhalajestani.reservations.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);



}
