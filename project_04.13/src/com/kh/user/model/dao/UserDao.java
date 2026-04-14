package com.kh.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.user.model.dto.UserDto;

public class UserDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int save(UserDto ud) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "INSERT "
			     + "INTO "
			          + "\"USER\""
			   + "VALUES "
						+"("
						+ "'S' || SEQ_\"USER\".NEXTVAL"
						+",'" + ud.getUserName() +"'"
						+",'" + ud.getUserId() +"'"
						+",'" + ud.getUserPwd() +"'"
						+",'" + ud.getFirstDate() +"'"
						+ ")";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin@127.0.0.1:1521:XE"
					, "C##SU"
					, "SU");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
		
		
	}

}
