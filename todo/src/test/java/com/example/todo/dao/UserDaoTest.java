package com.example.todo.dao;

import com.example.todo.entity.User;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserDaoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findOne() {
		final User user;
		final User userFound;

		// given
		user = new User().setName("John Doe");

		entityManager.persist(user);
		entityManager.flush();

		// when
		userFound = userDao.findOne(1L);

		assertThat(userFound.getName(), Matchers.equalToIgnoringCase(user.getName()));
	}

}