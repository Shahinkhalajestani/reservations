package com.shahinkhalajestani.reservations.service;

import com.shahinkhalajestani.reservations.model.User;

public interface UserService {

	User findByUsername(String username);

	void update(User user);

}
