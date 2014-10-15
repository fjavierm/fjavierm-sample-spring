package com.wordpress.infow.usermng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordpress.infow.usermng.dao.UserDAO;
import com.wordpress.infow.usermng.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public UserServiceImpl() {

	}

	@Override
	public List<User> list() {

		return this.userDAO.list();
	}

	@Override
	public User get(int id) {

		return this.userDAO.get(id);
	}

	@Override
	public void saveOrUpdate(User user) {

		this.userDAO.saveOrUpdate(user);
	}

	@Override
	public void delete(int id) {

		this.userDAO.delete(id);
	}

}
