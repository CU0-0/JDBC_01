package com.kh.project.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUser {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("USER_NO를 입력해주세요 > ");
		String userNo = sc.nextLine();
		System.out.println("USER_NAME을 입력해주세요 > ");
		String userName = sc.nextLine();
		System.out.println("USER_ID을 입력해주세요 > ");
		String userId = sc.nextLine();
		System.out.println("USER_PWD을 입력해주세요 > ");
		String userPwd = sc.nextLine();
		System.out.println("FIRST_DATE을 입력해주세요 > ");
		String firstDate = sc.nextLine();
		
		String sql = "INSERT INTO USER VALUES('테스트', '테스트', '테스트', '테스트', SYSDATE)";
		
		sql = "INSERT INTO USER VALUES('" + userNo + "',"
								   + "'"  + userName + "',"
								   + "'"  + userId + "',"
								   + "'"  + userPwd + "',"
								   + "'"  + firstDate + "')";
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO \"USER\" VALUES(");
		sb.append("'" + userNo + "',");
		sb.append("'" + userName + "',");
		sb.append("'" + userId + "',");
		sb.append("'" + userPwd + "',");
		sb.append("SYSDATE)");
		sql = sb.toString();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록!");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", 
							"C##SU", 
							"SU");
			System.out.println("연결성공!");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			System.out.println("a");
			
			result = stmt.executeUpdate(sql);
			System.out.println("b");
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
