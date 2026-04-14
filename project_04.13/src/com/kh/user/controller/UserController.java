package com.kh.user.controller;

import com.kh.user.model.dto.UserDto;
import com.kh.user.model.service.UserService;

public class UserController {
	private UserService userService = new UserService();
	
	

	public int save(String userName, String userId, String userPwd, String firstDate) {
		UserDto ud = new UserDto(userName, userId, userPwd, firstDate);
		return userService.save(ud);
	}
	
	
	
	
}
