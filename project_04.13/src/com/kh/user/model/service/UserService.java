package com.kh.user.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.user.common.JdbcTemplate;
import com.kh.user.model.dao.UserDao;
import com.kh.user.model.dto.UserDto;
import com.kh.user.model.vo.User;

public class UserService {
	

	public int save(UserDto ud) {
		
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new UserDao().save(conn, ud);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		
		JdbcTemplate.close(conn);
		
		return result;
		
		
		
	}

	public List<User> findAll() {
		Connection conn = JdbcTemplate.getConnection();
		List<User> users = new UserDao().findAll(conn);
		JdbcTemplate.close(conn);
		return users;
	}

}
