package com.wordpress.infow.usermng.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.infow.usermng.model.User;
import com.wordpress.infow.usermng.service.UserService;

@RestController
@RequestMapping("/rs/users")
public class UserRest {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public void create(User user) {

		this.userService.saveOrUpdate(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public User findById(@PathVariable int id) {

		return this.userService.get(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<User> findAll() {

		return this.userService.list();
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(User user) {

		this.userService.saveOrUpdate(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable int id) {

		this.userService.delete(id);
	}

}
