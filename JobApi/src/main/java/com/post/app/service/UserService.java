package com.post.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.app.dto.UserDto;
import com.post.app.entity.User;
import com.post.app.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public UserDto addUser(UserDto userDto) {
		User Convertuser= userRepo.save((modelMapper.map(userDto, User.class)));
		return modelMapper.map(Convertuser, UserDto.class);
	}
}
