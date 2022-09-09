package com.post.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.app.dto.UserDto;
import com.post.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUseindbr")
	public UserDto addUser(@RequestBody UserDto userDto) {
		UserDto userAdded=userService.addUser(userDto);
		return userAdded;
	}

}
