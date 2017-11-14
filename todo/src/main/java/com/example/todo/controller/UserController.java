package com.example.todo.controller;

import com.example.todo.dto.UserDto;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers() {
		return ResponseEntity.ok(this.userService.get());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable final Long id) {
		return ResponseEntity.ok(this.userService.get(id));
	}

	@PostMapping
	public void createUser(@RequestBody final UserDto userDto) {
		this.userService.create(userDto);
	}

	@PutMapping(value = "/{id}")
	public void updateUser(@PathVariable final Long id, @RequestBody final UserDto userDto) {
		this.userService.update(id, userDto);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable final Long id) {
		this.userService.delete(id);
	}
}
