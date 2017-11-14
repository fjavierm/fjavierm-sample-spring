package com.example.todo.controller;

import com.example.todo.dto.UserDto;
import com.example.todo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserServiceImpl userService;

	@Test
	public void getUsers() throws Exception {
		final UserDto user = new UserDto().setName("John Doe");
		final List<UserDto> users = Collections.singletonList(user);

		given(userService.get()).willReturn(users);

		mvc.perform(get("/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(user.getName())));
	}

	@Test
	public void getUser() throws Exception {
	}

	@Test
	public void createUser() throws Exception {
	}

	@Test
	public void updateUser() throws Exception {
	}

	@Test
	public void deleteUser() throws Exception {
	}

}