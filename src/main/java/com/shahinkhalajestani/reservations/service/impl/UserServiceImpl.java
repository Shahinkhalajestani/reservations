package com.shahinkhalajestani.reservations.service.impl;

import com.shahinkhalajestani.reservations.dao.UserDao;
import com.shahinkhalajestani.reservations.model.User;
import com.shahinkhalajestani.reservations.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


	private final UserDao userDao;

	@Override
	public User findByUsername(String username) {
		log.info("Finding user by username: {}", username);
		return userDao.findByUsername(username)
				.orElseThrow(() -> new IllegalArgumentException("User with username " + username + " not found"));
	}

	@Override
	public void update(User user) {
		log.info("Updating user with id: {}", user.getId());
		userDao.save(user);
	}
}
