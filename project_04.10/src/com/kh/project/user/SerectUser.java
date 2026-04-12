package com.kh.project.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SerectUser {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
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
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", 
												"C##SU", 
												"SU");
			System.out.println("연결성공!");
			
			stmt = conn.createStatement();
			System.out.println("a");
			
			rset = stmt.executeQuery(sql);
			System.out.println("b");
			
			while(rset.next()) {
				String userNo = rset.getString("USER_NO");
				String userName = rset.getString("USER_NAME");
				String userId = rset.getString("USER_ID");
				String userPwd = rset.getString("USER_PWD");
				String firstDate = rset.getString("FIRST_DATE");
				
				System.out.println("유저번호 : " + userNo
						+ ", 유저명 : " + userName
						+ ", 아이디 : " + userId
						+ ", 비밀번호 : " + userPwd
						+ ", 가입일 : " + firstDate);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
		
		
	}

}
