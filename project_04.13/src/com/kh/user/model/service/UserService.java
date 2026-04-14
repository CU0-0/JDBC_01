package com.kh.user.model.service;

import com.kh.user.model.dao.UserDao;
import com.kh.user.model.dto.UserDto;

public class UserService {
	private UserDao userDao = new UserDao();

	public int save(UserDto ud) {
		return userDao.save(ud);
	}

}
