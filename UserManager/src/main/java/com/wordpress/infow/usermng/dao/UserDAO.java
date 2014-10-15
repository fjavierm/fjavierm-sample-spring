package com.wordpress.infow.usermng.dao;

import java.util.List;

import com.wordpress.infow.usermng.model.User;

public interface UserDAO {

	public List<User> list();

	public User get(int id);

	public void saveOrUpdate(User user);

	public void delete(int id);
}