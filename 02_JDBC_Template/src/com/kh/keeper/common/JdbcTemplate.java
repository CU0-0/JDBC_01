package com.kh.keeper.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	/*
	 * JDBC과정에 사용되는 반복적으로 작성해야 하는 코드
	 * => 메소드로 정의해둘 클래스
	 */
	// Driver 등록
	public static void registDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// DB연결 정보를 이용해서 Connection생성해서 반환해주는 메소드
	public static Connection getConnection() {
		
		try {
		Connection conn =
				DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE"
											, "C##SU"
											, "SU");
		conn.setAutoCommit(false);
		
		return conn;
		
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return null;
	}
	
	//Connection 객체를 이용해서 commit 시켜주는 메소드
	public static void commit(Connection conn) {
		try {
			if(conn != null) {
			conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void close(Connection conn) {
		try {
			if(conn != null) {
			conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
	
	
	
	
	
	
	
	
	
	

