package com.kh.user.controller;

import java.util.List;

import com.kh.user.model.dto.UserDto;
import com.kh.user.model.service.UserService;
import com.kh.user.model.vo.User;

public class UserController {
	

	public int save(UserDto ud) {
		return new UserService().save(ud);
	}

	public List<User> findAll() {
		return new UserService().findAll();
	}
	
	
	
	
}
