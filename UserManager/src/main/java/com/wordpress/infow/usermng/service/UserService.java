package com.wordpress.infow.usermng.service;

import java.util.List;

import com.wordpress.infow.usermng.model.User;

public interface UserService {

	public List<User> list();

	public User get(int id);

	public void saveOrUpdate(User user);

	public void delete(int id);
}
