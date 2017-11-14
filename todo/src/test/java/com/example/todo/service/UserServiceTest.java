package com.example.todo.service;

import com.example.todo.dao.UserDao;
import com.example.todo.entity.User;
import com.example.todo.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

public class UserServiceTest {

	@Mock
	private UserDao userDao;

	@InjectMocks
	private UserServiceImpl userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void get() throws Exception {
		final User user = new User().setName("John Doe");

		when(userDao.findOne(anyLong())).thenReturn(user);

		assertThat(userService.get(1L), is(notNullValue()));
	}

	@Test
	public void getAll() throws Exception {
		final User user1 = new User().setName("John Doe");
		final User user2 = new User().setName("Jane Doe");
		final List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		when(userDao.findAll()).thenReturn(users);

		assertThat(userService.get(), is(notNullValue()));
		assertThat(userService.get(), hasSize(2));
	}
}