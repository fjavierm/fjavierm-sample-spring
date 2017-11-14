package com.example.todo.service;

import com.example.todo.dto.UserDto;

import java.util.List;

public interface UserService {

	void create(UserDto userDto);

	UserDto get(Long userId);

	List<UserDto> get();

	void update(Long userId, UserDto userDto);

	void delete(Long userId);
}
