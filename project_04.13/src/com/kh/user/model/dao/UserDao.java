package com.kh.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.user.common.JdbcTemplate;
import com.kh.user.model.dto.UserDto;
import com.kh.user.model.vo.User;

public class UserDao {

	static{
		JdbcTemplate.registDriver();
	}
	
	public int save(Connection conn, UserDto ud) {
		//Connection conn = null;
		//Statement stmt = null;
		int result = 0;
		
		String sql = """
				INSERT 
			     INTO
			           "USER"
			    VALUES
					
						'S' || SEQ_"USER".NEXTVAL
						, ud.getUserName() 
						, ud.getUserId() 
						, ud.getUserPwd() 
						, ud.getFirstDate() 
						""";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, ud.getUserName());
			pstmt.setString(2, ud.getUserId());
			pstmt.setString(3, ud.getUserPwd());
			pstmt.setString(4, ud.getFirstDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
		
		
	}

	public List<User> findAll(Connection conn) {
		List<User> users = new ArrayList();
		
		String sql = """
				SELECT
						USER_NO
						, USER_NAME
						, USER_ID
						, USER_PWD
						, FIRST_DATE
					FROM
						\"USER\"
					ORDER
					BY
						USER_NO DESC
					""";
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()){
				while(rset.next()){
					
					User user = new User(rset.getString("USER_NO")
											, rset.getString("USER_NAME")
											, rset.getString("USER_ID")
											, rset.getString("USER_PWD")
											, rset.getString("FIRST_DATE"));
					users.add(user);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return users;	
	
	
	
	
	
	
	}

}
